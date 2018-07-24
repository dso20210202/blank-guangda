package com.jilepay.guangda.service;



import com.jilepay.guangda.common.Configure;
import com.jilepay.guangda.common.Util;
import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.pay.QrCodePayOfAlipayReqData;
import com.jilepay.guangda.protocol.pay.QrCodePayOfAlipayResData;
import com.jilepay.guangda.protocol.pay.QrCodePayOfWeixinReqData;
import com.jilepay.guangda.protocol.pay.QrCodePayOfWeixinResData;



public class QrCodePayService extends BaseService{

	public QrCodePayService()
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		super(Configure.PAY_API);
	}
	
    /**
     * 微信请求支付服务
     * @param scanPayReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return 返回封装后的对象
     * @throws Exception
     */
    public QrCodePayOfWeixinResData request(QrCodePayOfWeixinReqData qrCodePayOfWeixinReqData) throws Exception {

    	GuangdaMchSettings gms = qrCodePayOfWeixinReqData.getGuangdaMchSettings();
		if(gms.getKey()==null||gms.getKey().trim().length()<8)
    	{//rsa签名
			qrCodePayOfWeixinReqData.setSign_type("RSA_1_256");
    	}
    	qrCodePayOfWeixinReqData.setSign(super.sign(qrCodePayOfWeixinReqData));
        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(qrCodePayOfWeixinReqData);

        Util.log(responseString);
        
        QrCodePayOfWeixinResData qrCodePayOfWeixinResData = (QrCodePayOfWeixinResData) Util.getObjectFromXML(responseString, QrCodePayOfWeixinResData.class);
        qrCodePayOfWeixinResData.setResponse(responseString);
        
        return qrCodePayOfWeixinResData;
    }
    
    /**
     * 支付宝请求支付服务
     * @param scanPayReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return 返回封装后的对象
     * @throws Exception
     */
    public QrCodePayOfAlipayResData request(QrCodePayOfAlipayReqData qrCodePayOfAlipayReqData) throws Exception {

    	GuangdaMchSettings gms = qrCodePayOfAlipayReqData.getGuangdaMchSettings();
		if(gms.getKey()==null||gms.getKey().trim().length()<8)
    	{//rsa签名
			qrCodePayOfAlipayReqData.setSign_type("RSA_1_256");
    	}
    	qrCodePayOfAlipayReqData.setSign(super.sign(qrCodePayOfAlipayReqData));
        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(qrCodePayOfAlipayReqData);

        Util.log(responseString);
        
        QrCodePayOfAlipayResData qrCodePayOfAlipayResData = (QrCodePayOfAlipayResData) Util.getObjectFromXML(responseString, QrCodePayOfAlipayResData.class);
        qrCodePayOfAlipayResData.setResponse(responseString);
        
        return qrCodePayOfAlipayResData;
    }
}
