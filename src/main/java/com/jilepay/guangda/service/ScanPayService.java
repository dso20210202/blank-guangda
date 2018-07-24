package com.jilepay.guangda.service;


import com.jilepay.guangda.common.Configure;
import com.jilepay.guangda.common.Signature;
import com.jilepay.guangda.common.Util;
import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.pay.ScanPayReqData;
import com.jilepay.guangda.protocol.pay.ScanPayResData;



public class ScanPayService extends BaseService{

	public ScanPayService()
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		super(Configure.PAY_API);
	}

	/**
	 * 请求支付服务
	 * @param scanPayReqData 这个数据对象里面包含了API要求提交的各种数据字段
	 * @return 返回封装后的对象
	 * @throws Exception
	 */
	public ScanPayResData request(ScanPayReqData scanPayReqData) throws Exception {

		GuangdaMchSettings gms = scanPayReqData.getGuangdaMchSettings();
		if(gms.getKey()==null||gms.getKey().trim().length()<8)
    	{//rsa签名
			scanPayReqData.setSign_type("RSA_1_256");
    	}
		
		scanPayReqData.setSign(sign(scanPayReqData));
		//--------------------------------------------------------------------
		//发送HTTPS的Post请求到API地址
		//--------------------------------------------------------------------
		String responseString = sendPost(scanPayReqData);

		Util.log(responseString);

		//将从API返回的XML数据映射到Java对象
		ScanPayResData scanPayResData = (ScanPayResData) Util.getObjectFromXML(responseString, ScanPayResData.class);
		scanPayResData.setResponse(responseString);
		
		return scanPayResData;
	}
}
