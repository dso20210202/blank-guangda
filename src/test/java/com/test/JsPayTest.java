package com.test;

import org.junit.Test;

import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.pay.JsPayReqData;
import com.jilepay.guangda.protocol.pay.JsPayResData;
import com.jilepay.guangda.service.JsPayService;

public class JsPayTest {

	@Test
	public void jsPayTest() throws Exception{
		
		JsPayService jsPayService = new JsPayService();
		
		String mchId = "100570000241";
		String key = "b165cc9b1c287096d86c42fc";
		String sign_agentno = "075020000001";
		String service = "pay.weixin.jspay";
		String out_trade_no = System.currentTimeMillis() + "";
		String body = "测试商品";
		String sub_openid = null;//测试不用
		String is_raw = "1";//是否原生态
		int total_fee = 1;
		String mch_create_ip = "127.0.0.1";
		String notify_url = "http://www.jilepay.com";
		String attach = "bank_mch_name=张三杂货店&bank_mch_id=123456";
		
		GuangdaMchSettings guangdaMchSettings = GuangdaMchSettings.buildWeixin(mchId, key, sign_agentno,null,null);
		
		JsPayReqData jsPayReqData = new JsPayReqData(guangdaMchSettings, service, is_raw, out_trade_no, body, sub_openid, total_fee, mch_create_ip, notify_url);
		jsPayReqData.setAttach(attach);
		
		JsPayResData jsPayResData = jsPayService.request(jsPayReqData);
		
		System.out.println(jsPayResData.getPayInfo().toString());
	}
	
}
