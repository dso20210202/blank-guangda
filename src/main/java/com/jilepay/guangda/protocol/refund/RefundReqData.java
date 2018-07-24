package com.jilepay.guangda.protocol.refund;

import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.base.BaseReqData;

public class RefundReqData extends BaseReqData{

	private String out_trade_no;//商户订单号
	private String transaction_id;//光大订单号
	private String out_refund_no;//退款单号
	private String total_fee;//总金额
	private String refund_fee;//退款金额
	private String op_user_id;//操作人员
	private String refund_channel;//退款渠道
	
	public RefundReqData(String service, String out_trade_no, String out_refund_no,
			String total_fee, String refund_fee, String op_user_id, GuangdaMchSettings settings) {
		this(service, null, null, null, null,null, out_trade_no, null, out_refund_no,
				total_fee, refund_fee, op_user_id, null, null, null,settings);
	}

	public RefundReqData(String service, String version, String charset, String sign_type, String mch_id,
			String sign_agentno, String out_trade_no, String transaction_id, String out_refund_no, String total_fee,
			String refund_fee, String op_user_id, String refund_channel, String nonce_str, String sign,
			GuangdaMchSettings settings) {
		super(settings, service);
		this.out_trade_no = out_trade_no;
		this.transaction_id = transaction_id;
		this.out_refund_no = out_refund_no;
		this.total_fee = total_fee;
		this.refund_fee = refund_fee;
		this.op_user_id = op_user_id;
		this.refund_channel = refund_channel;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_refund_no() {
		return out_refund_no;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	}

	public String getOp_user_id() {
		return op_user_id;
	}

	public void setOp_user_id(String op_user_id) {
		this.op_user_id = op_user_id;
	}

	public String getRefund_channel() {
		return refund_channel;
	}

	public void setRefund_channel(String refund_channel) {
		this.refund_channel = refund_channel;
	}

}
