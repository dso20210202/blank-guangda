package com.jilepay.guangda.business;

import org.slf4j.LoggerFactory;

import com.jilepay.guangda.common.Log;
import com.jilepay.guangda.common.Signature;
import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.pay.ScanPayReqData;
import com.jilepay.guangda.protocol.pay.ScanPayResData;
import com.jilepay.guangda.service.ScanPayService;

/**
 * 微信业务处理流程
 */
public class ScanPayBusiness {

	public interface ResultListener {

		//API返回ReturnCode不合法，支付请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问
		void onFailByReturnCodeError(ScanPayResData scanPayResData);

		//API返回ReturnCode为FAIL，支付API系统返回失败，请检测Post给API的数据是否规范合法
		void onFailByReturnCodeFail(ScanPayResData scanPayResData);

		//支付请求API返回的数据签名验证失败，有可能数据被篡改了
		void onFailBySignInvalid(ScanPayResData scanPayResData);

		//授权码无效，提示用户刷新一维码/二维码，之后重新扫码支付"
		void onFailByAuthCodeInvalid(ScanPayResData scanPayResData);

		//用户余额不足，换其他卡支付或是用现金支付
		void onFailByMoneyNotEnough(ScanPayResData scanPayResData);

		//其他支付失败
		void onFail(ScanPayResData scanPayResData);

		//支付成功
		void onSuccess(ScanPayResData scanPayResData);

		//支付中
		void onPaying(ScanPayResData scanPayResData);

	}

	private ScanPayService scanPayService;

	//打log用
	private static Log log = new Log(LoggerFactory.getLogger(ScanPayBusiness.class));

	public ScanPayBusiness() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
		scanPayService = new ScanPayService();
	}

	public void run(GuangdaMchSettings mchSettings,ScanPayReqData scanPayReqData,ResultListener resultListener) throws Exception{

		//将从API返回的XML数据映射到Java对象
		ScanPayResData scanPayResData = scanPayService.request(scanPayReqData);

		if (scanPayResData == null || scanPayResData.getStatus() == null) {
			log.e("【支付失败】支付请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问");
			resultListener.onFailByReturnCodeError(scanPayResData);
			return;
		}

		if (!scanPayResData.getStatus().equals("0")) {
			//注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
			log.e("【支付失败】支付API系统返回失败，请检测Post给API的数据是否规范合法");
			resultListener.onFailByReturnCodeFail(scanPayResData);
			return;
		}

		log.i("支付API系统成功返回数据");
		//--------------------------------------------------------------------
		//收到API的返回数据的时候得先验证一下数据有没有被第三方篡改，确保安全
		//--------------------------------------------------------------------
		if (!Signature.checkIsSignValidFromResponseString(scanPayResData.getResponse(),mchSettings)) {
			log.e("【支付失败】支付请求API返回的数据签名验证失败，有可能数据被篡改了");
			resultListener.onFailBySignInvalid(scanPayResData);
			return;
		}

		//获取错误码
		String errorCode = scanPayResData.getErr_code();
		//获取错误描述
		String errorCodeDes = scanPayResData.getErr_msg();

		if (scanPayResData.getResult_code().equals("0")) {

			//--------------------------------------------------------------------
			//1)直接扣款成功
			//--------------------------------------------------------------------

			log.i("【一次性支付成功】");
			resultListener.onSuccess(scanPayResData);
		}else{

			//出现业务错误
			log.i("业务返回失败");
			log.i("err_code:" + errorCode);
			log.i("err_code_des:" + errorCodeDes);

			//业务错误时错误码有好几种，商户重点提示以下几种
			if (errorCode.equals("AUTHCODEEXPIRE") || errorCode.equals("AUTH_CODE_INVALID") || errorCode.equals("NOTENOUGH")  //微信
					|| errorCode.equals("ACQ.PAYMENT_AUTH_CODE_INVALID")  || errorCode.equals("ACQ.BUYER_BALANCE_NOT_ENOUGH") //支付宝
					|| errorCode.equals("66227006")  || errorCode.equals("66227008") //qq
					) {
				//--------------------------------------------------------------------
				//2)扣款明确失败
				//--------------------------------------------------------------------

				if (errorCode.equals("AUTHCODEEXPIRE") || errorCode.equals("AUTH_CODE_INVALID")//微信
						|| errorCode.equals("ACQ.PAYMENT_AUTH_CODE_INVALID")//支付宝
						|| errorCode.equals("66227006")	//qq
						) {
					//授权码无效或者过期，提示用户刷新一维码/二维码，之后重新扫码支付
					log.w("【支付扣款明确失败】原因是：" + errorCodeDes);
					resultListener.onFailByAuthCodeInvalid(scanPayResData);
				} else if (errorCode.equals("NOTENOUGH") //微信
						|| errorCode.equals("ACQ.BUYER_BALANCE_NOT_ENOUGH") //支付宝
						|| errorCode.equals("66227008")) //qq
					{
					//提示用户余额不足，换其他卡支付或是用现金支付
					log.w("【支付扣款明确失败】原因是：" + errorCodeDes);
					resultListener.onFailByMoneyNotEnough(scanPayResData);
				}
			}else if (errorCode.equals("USERPAYING") //微信
					|| errorCode.equals("1003") //支付宝
					|| errorCode.equals("66227005")) //qq
				{

				//--------------------------------------------------------------------
				//3)需要输入密码
				//--------------------------------------------------------------------

				//表示有可能单次消费超过300元(微信)，或是免输密码消费次数已经超过当天的最大限制
				resultListener.onPaying(scanPayResData);
			} else {

				//--------------------------------------------------------------------
				//4)扣款未知失败
				//--------------------------------------------------------------------

				resultListener.onFail(scanPayResData);
				
				//明确扣款失败应该走失败流程
			}
		}
	}
}
