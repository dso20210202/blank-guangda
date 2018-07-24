package com.jilepay.guangda.service;

import com.jilepay.guangda.common.Configure;
import com.jilepay.guangda.common.Util;
import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.query.RefundQueryReqData;
import com.jilepay.guangda.protocol.query.RefundQueryResData;

public class RefundQueryService extends BaseService{

	public RefundQueryService()
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		super(Configure.PAY_API);
	}
	
	public RefundQueryResData request(RefundQueryReqData refundQueryReqData) throws Exception{
		
		GuangdaMchSettings gms = refundQueryReqData.getGuangdaMchSettings();
		if(gms.getKey()==null||gms.getKey().trim().length()<8)
    	{//rsa签名
			refundQueryReqData.setSign_type("RSA_1_256");
    	}
		
		refundQueryReqData.setSign(sign(refundQueryReqData));
		
		String responseString = sendPost(refundQueryReqData);
		
		Util.log(responseString);
		
		RefundQueryResData refundQueryResData = (RefundQueryResData) Util.getObjectFromXML(responseString, RefundQueryResData.class);
		refundQueryResData.setResponse(responseString);
		
		return refundQueryResData;
	}

}
