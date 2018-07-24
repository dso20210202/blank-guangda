package com.test;

import org.junit.Test;

import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.refund.RefundReqData;
import com.jilepay.guangda.protocol.refund.RefundResData;
import com.jilepay.guangda.service.RefundService;

public class RefundTest {

	@Test
	public void refundTest() throws Exception{
		
		RefundService refundService = new RefundService();
		
		String mchId = "100570000241";
		String key = "b165cc9b1c287096d86c42fc";
		String sign_agentno = "075020000001";
		String service = "unified.trade.refund";
		String outTradeNo = "1470885035146";
		String out_refund_no = "1470900522056";
		String total_fee = "1";
		String refund_fee = "1";
		String op_user_id = "111111111111111111";
		
		GuangdaMchSettings settings = GuangdaMchSettings.buildWeixin(mchId, key, sign_agentno,null,null);
		
		RefundReqData refundReqData = new RefundReqData(service, outTradeNo, out_refund_no, total_fee, refund_fee, op_user_id, settings);
		
		RefundResData refundResData = refundService.request(refundReqData);
		
		System.out.println(refundResData.toString());
	}
	
}
