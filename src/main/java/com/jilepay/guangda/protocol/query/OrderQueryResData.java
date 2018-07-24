package com.jilepay.guangda.protocol.query;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jilepay.guangda.protocol.base.BaseResData;

public class OrderQueryResData extends BaseResData {

	// 以下字段在result_code = 0时有返回
	private String trade_state;// 交易状态
	private String trade_type;// 交易类型
	private String transaction_id;// 光大订单号
	private String out_transaction_id;// 第三方商户号
	private String out_trade_no;// 商户订单号
	private String total_fee;// 总金额
	private String coupon_fee;// 现金券金额
	private String fee_type;// 货币种类
	private String attach;// 附加信息
	private String bank_type;// 付款银行
	private String bank_billno;// 银行订单号
	private String time_end;// 支付完成时间
	
	//微信有的字段
	private String appid;//公众号id
	private String is_subscribe;//是否关注公众号账号
	private String sign_agentno;//光大分配的渠道号
	private String sub_openid;//关注公众号的openid
	
	//支付宝有的字段
	private String buyer_logon_id;//买家支付宝账号
	private String buyer_user_id;//买家在支付宝的用户id
	private String fund_bill_list;//json的交易支付使用的资金渠道
	
	//微信、支付宝都有，但是文档上面没有。
	private String openid;//用户标识
	
	@Override
	public String toString() {
		return "OrderQueryResData [version=" + version + ", charset=" + charset + ", sign_type=" + sign_type
				+ ", status=" + status + ", message=" + message + ", result_code=" + result_code + ", mch_id=" + mch_id
				+ ", device_info=" + device_info + ", nonce_str=" + nonce_str + ", err_code=" + err_code + ", err_msg="
				+ err_msg + ", sign=" + sign + ", trade_state=" + trade_state + ", trade_type=" + trade_type
				+ ", transaction_id=" + transaction_id + ", out_transaction_id=" + out_transaction_id
				+ ", out_trade_no=" + out_trade_no + ", total_fee=" + total_fee + ", coupon_fee=" + coupon_fee
				+ ", fee_type=" + fee_type + ", attach=" + attach + ", bank_type=" + getBank_type() + ", bank_billno="
				+ bank_billno + ", time_end=" + time_end + ", appid=" + appid + ", is_subscribe=" + is_subscribe
				+ ", sign_agentno=" + sign_agentno + ", buyer_logon_id=" + buyer_logon_id + ", buyer_user_id="
				+ buyer_user_id + ", fund_bill_list=" + fund_bill_list + ", openid=" + openid + ",sub_openid="+sub_openid+"]";
	}

	public String getSub_openid() {
		return sub_openid;
	}

	public void setSub_openid(String sub_openid) {
		this.sub_openid = sub_openid;
	}

	public String getTrade_state() {
		return trade_state;
	}

	public void setTrade_state(String trade_state) {
		this.trade_state = trade_state;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transasction_id) {
		this.transaction_id = transasction_id;
	}

	public String getOut_transaction_id() {
		return out_transaction_id;
	}

	public void setOut_transaction_id(String out_transaction_id) {
		this.out_transaction_id = out_transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getCoupon_fee() {
		return coupon_fee;
	}

	public void setCoupon_fee(String coupon_fee) {
		this.coupon_fee = coupon_fee;
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
		if (null != fund_bill_list){
			JSONArray jsonArr = new JSONArray(fund_bill_list);
			JSONObject fundBill = jsonArr.getJSONObject(0);
			bank_type = fundBill.getString("fundChannel");//支付宝的接口文档和返回的参数名不一样
		}
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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSign_agentno() {
		return sign_agentno;
	}

	public void setSign_agentno(String sign_agentno) {
		this.sign_agentno = sign_agentno;
	}

	public String getBuyer_logon_id() {
		return buyer_logon_id;
	}

	public void setBuyer_logon_id(String buyer_logon_id) {
		this.buyer_logon_id = buyer_logon_id;
	}

	public String getBuyer_user_id() {
		return buyer_user_id;
	}

	public void setBuyer_user_id(String buyer_user_id) {
		this.buyer_user_id = buyer_user_id;
	}

	public String getFund_bill_list() {
		return fund_bill_list;
	}

	public void setFund_bill_list(String fund_bill_list) {
		this.fund_bill_list = fund_bill_list;
	}

}
