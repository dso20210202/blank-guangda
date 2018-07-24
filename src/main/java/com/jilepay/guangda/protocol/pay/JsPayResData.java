package com.jilepay.guangda.protocol.pay;


import com.alibaba.fastjson.JSON;
import com.jilepay.guangda.protocol.base.BaseResData;

public class JsPayResData extends BaseResData {

	private String token_id;
	private String pay_info;

	@Override
	public String toString() {
		return "JsPayResData [token_id=" + token_id + ", pay_info=" + pay_info + ", version=" + version + ", charset="
				+ charset + ", sign_type=" + sign_type + ", status=" + status + ", message=" + message
				+ ", result_code=" + result_code + ", mch_id=" + mch_id + ", sign_agentno=" + sign_agentno
				+ ", device_info=" + device_info + ", nonce_str=" + nonce_str + ", err_code=" + err_code + ", err_msg="
				+ err_msg + ", sign=" + sign + "]";
	}

	public String getToken_id() {
		return token_id;
	}

	public void setToken_id(String token_id) {
		this.token_id = token_id;
	}

	public String getPay_info() {
		return pay_info;
	}

	public void setPay_info(String pay_info) {
		this.pay_info = pay_info;
	}

	public JsPayResDataPayInfo getPayInfo() {
		return JSON.parseObject(getPay_info(), JsPayResDataPayInfo.class);
	}

	
}
