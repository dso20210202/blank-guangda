package com.jilepay.guangda.protocol.pay;

import com.jilepay.guangda.protocol.base.BaseResData;

/**
 * 被扫支付提交Post数据给到API之后，API会返回XML格式的数据，这个类用来装这些数据
 */
public class ScanPayResData extends BaseResData {

	// 以下字段在 status 和 result_code 都为 0的时候有返回
	private String openid;
	private String trade_type;
	private String is_subscribe;
	private String pay_result;
	private String pay_info;
	private String transaction_id;
	private String out_trade_no;
	private String refund_id;
	private String refund_channel;
	private String refund_fee;
	private String coupon_refund_fee;
	private String fee_type;
	private String attach;
	private String bank_type;
	private String bank_billno;
	private String time_end;
	private String sub_openid;

	public String getSub_openid() {
		return sub_openid;
	}

	public void setSub_openid(String sub_openid) {
		this.sub_openid = sub_openid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getIs_subscribe() {
		return is_subscribe;
	}

	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	public String getPay_result() {
		return pay_result;
	}

	public void setPay_result(String pay_result) {
		this.pay_result = pay_result;
	}

	public String getPay_info() {
		return pay_info;
	}

	public void setPay_info(String pay_info) {
		this.pay_info = pay_info;
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

	public String getRefund_id() {
		return refund_id;
	}

	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}

	public String getRefund_channel() {
		return refund_channel;
	}

	public void setRefund_channel(String refund_channel) {
		this.refund_channel = refund_channel;
	}

	public String getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	}

	public String getCoupon_refund_fee() {
		return coupon_refund_fee;
	}

	public void setCoupon_refund_fee(String coupon_refund_fee) {
		this.coupon_refund_fee = coupon_refund_fee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public String getBank_billno() {
		return bank_billno;
	}

	public void setBank_billno(String bank_billno) {
		this.bank_billno = bank_billno;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	@Override
	public String toString() {
		return "ScanPayResData [openid=" + openid + ", trade_type=" + trade_type + ", is_subscribe=" + is_subscribe
				+ ", pay_result=" + pay_result + ", pay_info=" + pay_info + ", transaction_id=" + transaction_id
				+ ", out_trade_no=" + out_trade_no + ", refund_id=" + refund_id + ", refund_channel=" + refund_channel
				+ ", refund_fee=" + refund_fee + ", coupon_refund_fee=" + coupon_refund_fee + ", fee_type=" + fee_type
				+ ", attach=" + attach + ", bank_type=" + bank_type + ", bank_billno=" + bank_billno + ", time_end="
				+ time_end + "]";
	}
	
}
