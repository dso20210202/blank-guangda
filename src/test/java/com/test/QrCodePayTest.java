package com.test;

import org.junit.Test;

import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.pay.QrCodePayOfAlipayReqData;
import com.jilepay.guangda.protocol.pay.QrCodePayOfAlipayResData;
import com.jilepay.guangda.protocol.pay.QrCodePayOfWeixinReqData;
import com.jilepay.guangda.protocol.pay.QrCodePayOfWeixinResData;
import com.jilepay.guangda.service.QrCodePayService;

public class QrCodePayTest {

	@Test
	public void scanPayWeixinTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException{
		
		QrCodePayService qrCodePayService = new QrCodePayService();

		String mchId = "100570000241";
		String key = "b165cc9b1c287096d86c42fc";
		String sign_agentno = "075020000001";
		String service = "pay.weixin.native";
		String outTradeNo = System.currentTimeMillis()+"";
		String body = "test-haixaing";
		int totalFee = 1;
		String mchCreateIp = "127.0.0.1";
		String notifyUrl = "http://test.jilepay.com";
		String attach = "bank_mch_name=张三杂货店&bank_mch_id=123456";
		
		GuangdaMchSettings mchSettings = GuangdaMchSettings.buildWeixin(mchId, key, sign_agentno,null,null);
		
		QrCodePayOfWeixinReqData qrCodePayOfWeixinReqData = new QrCodePayOfWeixinReqData
				(mchSettings, service, sign_agentno, outTradeNo, body, totalFee, mchCreateIp, notifyUrl);
		qrCodePayOfWeixinReqData.setAttach(attach);
		
		try {
			QrCodePayOfWeixinResData res = qrCodePayService.request(qrCodePayOfWeixinReqData);
			System.out.println(res.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void scanPayAllPayTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException{
		
		QrCodePayService qrCodePayService = new QrCodePayService();
		
//		String mchId = "101520000465";
//		String key = "58bb7db599afc86ea7f7b262c32ff42f";
//		String service = "pay.alipay.native";
//		String outTradeNo = System.currentTimeMillis()+"";
//		String body = "testhaixaing";
//		int totalFee = 1;
//		String mchCreateIp = "127.0.0.1";
//		String notifyUrl = "http://www.jilepay.com";
		
		
	
		GuangdaMchSettings mchSettings = GuangdaMchSettings.buildAlipay("102532336411", "",null,null);
		
//		QrCodePayOfAlipayReqData qrCodePayOfAlipayReqData = new QrCodePayOfAlipayReqData
//				(mchSettings, service, outTradeNo, body, totalFee, mchCreateIp, notifyUrl);
		
		QrCodePayOfAlipayReqData qrCodePayOfAlipayReqData =  new QrCodePayOfAlipayReqData();
		qrCodePayOfAlipayReqData.setGuangdaMchSettings(mchSettings);
		qrCodePayOfAlipayReqData.setAttach("附加信息");
		qrCodePayOfAlipayReqData.setNonce_str("wNzpaD0sN17KI80yBQwINNHfmOIeNqap");
		qrCodePayOfAlipayReqData.setOut_trade_no("6057113230875089");
		qrCodePayOfAlipayReqData.setBody("测试购买商品");
		qrCodePayOfAlipayReqData.setVersion("1.0");
		qrCodePayOfAlipayReqData.setService("pay.alipay.native");
		qrCodePayOfAlipayReqData.setMch_create_ip("127.0.0.1");
		qrCodePayOfAlipayReqData.setNotify_url("http://www.baidu.cn/notify.aspx");
		qrCodePayOfAlipayReqData.setTotal_fee(1);
		qrCodePayOfAlipayReqData.setSign_type("RSA_1_256");
		qrCodePayOfAlipayReqData.setMch_id("102532336411");
		try {
			QrCodePayOfAlipayResData res = qrCodePayService.request(qrCodePayOfAlipayReqData);
			System.out.println(res.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
