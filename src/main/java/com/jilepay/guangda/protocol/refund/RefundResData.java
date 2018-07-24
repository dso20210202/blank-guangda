package com.jilepay.guangda.protocol.refund;

import com.jilepay.guangda.protocol.base.BaseResData;

public class RefundResData extends BaseResData {

	// 一下字段在status 和 result_code 都为0的时候有返回
	private String transaction_id;// 光大订单号
	private String out_trade_no;// 商户订单号
	private String out_refund_no;// 商户退款单号
	private String refund_id;// 光大退款单号
	private String refund_channel;// 退款渠道
	private String refund_fee;// 退款金额
	private String coupon_refund_fee;// 现金券退款金额
	
	//微信有的字段
	private String appid;//公众号id
	private String openid;//用户标识
	private String is_subscribe;//是否关注公众号账号
	
	//文档没有，实际有返回的字段
	private String trade_type;
	private String trade_state;
	private String total_fee;
	private String time_end;
	private String out_transaction_id;
	private String bank_type;
	private String fee_type;

	@Override
	public String toString() {
		return "RefundResData [version=" + version + ", charset=" + charset + ", sign_type=" + sign_type + ", status="
				+ status + ", message=" + message + ", result_code=" + result_code + ", mch_id=" + mch_id
				+ ", device_info=" + device_info + ", nonce_str=" + nonce_str + ", err_code=" + err_code + ", err_msg="
				+ err_msg + ", sign=" + sign + ", transaction_id=" + transaction_id + ", out_trade_no=" + out_trade_no
				+ ", out_refund_no=" + out_refund_no + ", refund_id=" + refund_id + ", refund_channel=" + refund_channel
				+ ", refund_fee=" + refund_fee + ", coupon_refund_fee=" + coupon_refund_fee + ", appid=" + appid
				+ ", openid=" + openid + ", is_subscribe=" + is_subscribe + ", sign_agentno=" + sign_agentno
				+ ", trade_type=" + trade_type + ", trade_state=" + trade_state + ", total_fee=" + total_fee
				+ ", time_end=" + time_end + ", out_transaction_id=" + out_transaction_id + ", bank_type=" + bank_type
				+ ", fee_type=" + fee_type + "]";
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

	public String getOut_refund_no() {
		return out_refund_no;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
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

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getIs_subscribe() {
		return is_subscribe;
	}

	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getTrade_state() {
		return trade_state;
	}

	public void setTrade_state(String trade_state) {
		this.trade_state = trade_state;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	public String getOut_transaction_id() {
		return out_transaction_id;
	}

	public void setOut_transaction_id(String out_transaction_id) {
		this.out_transaction_id = out_transaction_id;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
