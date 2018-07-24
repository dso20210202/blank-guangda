package com.jilepay.guangda.protocol.query;

import com.jilepay.guangda.protocol.base.BaseResData;

public class RefundQueryResData extends BaseResData {

	private String transaction_id;
	private String out_trade_no;
	private String refund_count;//
	private String out_refund_no_0;//
	private String refund_id_0;//
	private String refund_channel_0;
	private String refund_fee_0;
	private String coupon_refund_fee_0;
	private String refund_time_0;
	private String refund_status_0;

	@Override
	public String toString() {
		return "RefundQueryResData [transaction_id=" + transaction_id + ", out_trade_no=" + out_trade_no
				+ ", refund_count=" + refund_count + ", out_refund_no_0=" + out_refund_no_0 + ", refund_id_0="
				+ refund_id_0 + ", refund_channel_0=" + refund_channel_0 + ", refund_fee_0=" + refund_fee_0
				+ ", coupon_refund_fee_0=" + coupon_refund_fee_0 + ", refund_time_0=" + refund_time_0
				+ ", refund_status_0=" + refund_status_0 + ", version=" + version + ", charset=" + charset
				+ ", sign_type=" + sign_type + ", status=" + status + ", message=" + message + ", result_code="
				+ result_code + ", mch_id=" + mch_id + ", sign_agentno=" + sign_agentno + ", device_info=" + device_info
				+ ", nonce_str=" + nonce_str + ", err_code=" + err_code + ", err_msg=" + err_msg + ", sign=" + sign
				+ "]";
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getRefund_count() {
		return refund_count;
	}

	public void setRefund_count(String refund_count) {
		this.refund_count = refund_count;
	}

	public String getOut_refund_no_0() {
		return out_refund_no_0;
	}

	public void setOut_refund_no_0(String out_refund_no_0) {
		this.out_refund_no_0 = out_refund_no_0;
	}

	public String getRefund_id_0() {
		return refund_id_0;
	}

	public void setRefund_id_0(String refund_id_0) {
		this.refund_id_0 = refund_id_0;
	}

	public String getRefund_channel_0() {
		return refund_channel_0;
	}

	public void setRefund_channel_0(String refund_channel_0) {
		this.refund_channel_0 = refund_channel_0;
	}

	public String getRefund_fee_0() {
		return refund_fee_0;
	}

	public void setRefund_fee_0(String refund_fee_0) {
		this.refund_fee_0 = refund_fee_0;
	}

	public String getCoupon_refund_fee_0() {
		return coupon_refund_fee_0;
	}

	public void setCoupon_refund_fee_0(String coupon_refund_fee_0) {
		this.coupon_refund_fee_0 = coupon_refund_fee_0;
	}

	public String getRefund_time_0() {
		return refund_time_0;
	}

	public void setRefund_time_0(String refund_time_0) {
		this.refund_time_0 = refund_time_0;
	}

	public String getRefund_status_0() {
		return refund_status_0;
	}

	public void setRefund_status_0(String refund_status_0) {
		this.refund_status_0 = refund_status_0;
	}

}
