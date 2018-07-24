package com.test;

import org.junit.Test;

import com.jilepay.guangda.common.Util;
import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.query.RefundQueryReqData;
import com.jilepay.guangda.protocol.query.RefundQueryResData;
import com.jilepay.guangda.service.RefundQueryService;

public class RefundQueryTest {

	@Test
	public void refundQueryTest() throws Exception{
		
		RefundQueryService refundQueryService = new RefundQueryService();
		
		String mchId = "100570000241";
		String key = "b165cc9b1c287096d86c42fc";
		String sign_agentno = "075020000001";
		String service = "unified.trade.refundquery";
		String outTradeNo = "1470885035146";
		String out_refund_no = "1470900522056";
//		String out_refund_no = null;
		
		GuangdaMchSettings guangdaMchSettings = GuangdaMchSettings.buildWeixin(mchId, key, sign_agentno,null,null);
		RefundQueryReqData refundQueryReqData = new RefundQueryReqData(guangdaMchSettings, service, outTradeNo, out_refund_no);
		RefundQueryResData refundQueryResData = refundQueryService.request(refundQueryReqData);
		
		Util.log(refundQueryResData.toString());
	}
	
}
