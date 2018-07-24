package com.jilepay.guangda.protocol.notify;

import com.jilepay.guangda.protocol.base.BaseResData;

/**
 * 
 * 支付宝通知接口
 *
 */
public class NotifyAliPayResData extends BaseResData {

	private String service;
	private String openid;
	private String trade_type;
	private String pay_result;
	private String pay_info;
	private String transaction_id;
	private String out_transaction_id;
	private String out_trade_no;
	private String total_fee;
	private String fee_type;
	private String attach;
	private String time_end;
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
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
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	@Override
	public String toString() {
		return "NotifyAliPayResData [service=" + service + ", openid=" + openid + ", trade_type=" + trade_type
				+ ", pay_result=" + pay_result + ", pay_info=" + pay_info + ", transaction_id=" + transaction_id
				+ ", out_transaction_id=" + out_transaction_id + ", out_trade_no=" + out_trade_no + ", total_fee="
				+ total_fee + ", fee_type=" + fee_type + ", attach=" + attach + ", time_end=" + time_end + ", version="
				+ version + ", charset=" + charset + ", sign_type=" + sign_type + ", status=" + status + ", message="
				+ message + ", result_code=" + result_code + ", mch_id=" + mch_id + ", sign_agentno=" + sign_agentno
				+ ", device_info=" + device_info + ", nonce_str=" + nonce_str + ", err_code=" + err_code + ", err_msg="
				+ err_msg + ", sign=" + sign + "]";
	}
	
}
