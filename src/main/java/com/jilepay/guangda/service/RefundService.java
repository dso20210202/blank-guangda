package com.jilepay.guangda.service;

import com.jilepay.guangda.common.Configure;
import com.jilepay.guangda.common.Util;
import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.refund.RefundReqData;
import com.jilepay.guangda.protocol.refund.RefundResData;

public class RefundService extends BaseService {

	public RefundService() throws Exception {
		super(Configure.PAY_API);
	}
	
	public RefundResData request (RefundReqData refundReqData) throws Exception{
		
		GuangdaMchSettings gms = refundReqData.getGuangdaMchSettings();
		if(gms.getKey()==null||gms.getKey().trim().length()<8)
    	{//rsa签名
			refundReqData.setSign_type("RSA_1_256");
    	}
		refundReqData.setSign(super.sign(refundReqData));
		
		String responseString = super.sendPost(refundReqData);
		
		Util.log(responseString);
		
		RefundResData refundResData = (RefundResData) Util.getObjectFromXML(responseString, RefundResData.class);
		refundResData.setResponse(responseString);
		
		return refundResData;
	}

}
