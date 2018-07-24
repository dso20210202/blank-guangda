package com.jilepay.guangda.service;

import java.io.IOException;

import com.jilepay.guangda.common.Configure;
import com.jilepay.guangda.common.Util;
import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.pay.JsPayReqData;
import com.jilepay.guangda.protocol.pay.JsPayResData;

public class JsPayService extends BaseService{

	public JsPayService(String api) throws Exception {
		super(api);
	}
	
	public JsPayService() throws Exception {
		super(Configure.PAY_API);
	}
	
	public JsPayResData request(JsPayReqData jsPayReqData) throws Exception, IOException{

		GuangdaMchSettings gms = jsPayReqData.getGuangdaMchSettings();
		if(gms.getKey()==null||gms.getKey().trim().length()<8)
    	{//rsa签名
			jsPayReqData.setSign_type("RSA_1_256");
    	}
		jsPayReqData.setSign(super.sign(jsPayReqData));
		
		String responseString = super.sendPost(jsPayReqData);
		
		Util.log(responseString);
		
		JsPayResData jsPayResData = (JsPayResData) Util.getObjectFromXML(responseString, JsPayResData.class);
		jsPayResData.setResponse(responseString);
		
		return jsPayResData;
	}

}
