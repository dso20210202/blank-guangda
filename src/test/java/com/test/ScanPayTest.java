package com.test;

import org.junit.Test;

import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.pay.ScanPayReqData;
import com.jilepay.guangda.protocol.pay.ScanPayResData;
import com.jilepay.guangda.service.ScanPayService;

public class ScanPayTest {

	@Test
	public void scanPayWeixinTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException{
		ScanPayService guandaScanPayService = new ScanPayService();

		String mchId = "100570000241";
		String key = "b165cc9b1c287096d86c42fc";
		String sign_agentno = "075020000001";
		String service = "unified.trade.micropay";
		String outTradeNo = "1000000001147151044789790988723";
		String body = "test-haixaing";
		int totalFee = 1;
		String mchCreateIp = "127.0.0.1";
		String authCode = "130041614531648561";
		String attach = "bank_mch_name=张三杂货店&bank_mch_id=123456";
		
		GuangdaMchSettings mchSettings = GuangdaMchSettings.buildWeixin(mchId, key, sign_agentno,null,null);

		ScanPayReqData scanPayReqData = new ScanPayReqData(mchSettings, service, outTradeNo, body, 
				totalFee, mchCreateIp, authCode);
		scanPayReqData.setAttach(attach);
		
		try {
			guandaScanPayService.request(scanPayReqData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void scanPayAlipayTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException{
		ScanPayService guandaScanPayService = new ScanPayService();

		String mchId = "102565541710";//
		String key = "";//58bb7db599afc86ea7f7b262c32ff42f
		String service = "unified.trade.micropay";//unified.trade.micropay
		String outTradeNo ="12ws3ws3wesx4ed4ed5rf3e";
		String body = "测试购买商品";
		int totalFee = 1;
		String mchCreateIp = "127.0.0.1";
		String authCode = "281608844674260364";
		String attach = "测试";//
		String sign_type="RSA_1_256";
		
		GuangdaMchSettings mchSettings = GuangdaMchSettings.buildAlipay(mchId, key,null,null);

		ScanPayReqData scanPayReqData = new ScanPayReqData(mchSettings, service, outTradeNo, body, 
				totalFee, mchCreateIp, authCode,sign_type);
		scanPayReqData.setAttach(attach);
		try {
			ScanPayResData scanPayResData =  guandaScanPayService.request(scanPayReqData);
			System.out.println(scanPayResData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void scanPayQqTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException{
		ScanPayService guandaScanPayService = new ScanPayService();

		String mchId = "7551000001";
		String key = "9d101c97133837e13dde2d32a5054abb";
		String service = "unified.trade.micropay";
		String outTradeNo = System.currentTimeMillis()+"";
		String body = "testhaixaing";
		int totalFee = 1;
		String mchCreateIp = "127.0.0.1";
		String authCode = "910194318999678000";

		GuangdaMchSettings mchSettings = GuangdaMchSettings.buildQq(mchId, key,null,null);

		ScanPayReqData scanPayReqData = new ScanPayReqData(mchSettings, service, outTradeNo, body, 
				totalFee, mchCreateIp, authCode);
		scanPayReqData.setDevice_info("001");
		try {
			ScanPayResData scanPayResData =  guandaScanPayService.request(scanPayReqData);
			System.out.println(scanPayResData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
