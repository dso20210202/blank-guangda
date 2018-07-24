package com.jilepay.guangda.service;

import com.jilepay.guangda.common.Configure;
import com.jilepay.guangda.common.Util;
import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.query.OrderQueryReqData;
import com.jilepay.guangda.protocol.query.OrderQueryResData;

public class OrderQueryService extends BaseService {

	public OrderQueryService() throws Exception {
		super(Configure.PAY_API);
	}

	public OrderQueryResData request(OrderQueryReqData orderQueryReqData) throws Exception {

		GuangdaMchSettings gms = orderQueryReqData.getGuangdaMchSettings();
		if(gms.getKey()==null||gms.getKey().trim().length()<8)
    	{//rsa签名
			orderQueryReqData.setSign_type("RSA_1_256");
    	}
		orderQueryReqData.setSign(super.sign(orderQueryReqData));

		String responseString = super.sendPost(orderQueryReqData);

		Util.log(responseString);

		OrderQueryResData orderQueryResData = (OrderQueryResData) Util.getObjectFromXML(responseString, OrderQueryResData.class);
		orderQueryResData.setResponse(responseString);
		
		return orderQueryResData;
	}

}
