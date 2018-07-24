package com.test;

import org.junit.Test;

import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.query.OrderQueryReqData;
import com.jilepay.guangda.protocol.query.OrderQueryResData;
import com.jilepay.guangda.service.OrderQueryService;

public class OrderQueryTest {

	@Test
	public void queryWeixinTest() throws Exception{
		OrderQueryService orderQueryService = new OrderQueryService();
		
		String mchId = "102590490734";
		String key = "4577b7dceba6947407dbb3d2f4b3476a";
		String sign_agentno = "075020000001";
		String service = "unified.trade.query";
		String outTradeNo = "40242336692704111831";
		
		GuangdaMchSettings guangdaMchSetting = GuangdaMchSettings.buildWeixin(mchId, key, sign_agentno,null,null);
		
		OrderQueryReqData orderQueryReqData = new OrderQueryReqData 
				(guangdaMchSetting, service, outTradeNo);
				
		OrderQueryResData orderQueryResData = orderQueryService.request(orderQueryReqData);
		System.out.println("1000000001147151044789790988722".length());
	}
	
	@Test
	public void queryAlipayTest() throws Exception{
		OrderQueryService orderQueryService = new OrderQueryService();
		
		String mchId = "101520000465";
		String key = "58bb7db599afc86ea7f7b262c32ff42f";
		String service = "unified.trade.query";
		String outTradeNo = "1470886553837";
		
		GuangdaMchSettings guangdaMchSetting = GuangdaMchSettings.buildAlipay(mchId, key,null,null);
		
		OrderQueryReqData orderQueryReqData = new OrderQueryReqData 
				(guangdaMchSetting, service, outTradeNo);
				
		OrderQueryResData orderQueryResData = orderQueryService.request(orderQueryReqData);
		System.out.println(orderQueryResData.toString());
	}
}
