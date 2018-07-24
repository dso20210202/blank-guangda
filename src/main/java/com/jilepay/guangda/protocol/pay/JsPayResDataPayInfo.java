package com.jilepay.guangda.protocol.pay;

import com.alibaba.fastjson.annotation.JSONField;

public class JsPayResDataPayInfo {

	private String appId;
	private String timeStamp;
	private String status;
	private String signType;
	@JSONField(name="package") 
	private String packagePrepayId;
	private String callback_url;
	private String nonceStr;
	private String paySign;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getPackagePrepayId() {
		return packagePrepayId;
	}
	public void setPackagePrepayId(String packagePrepayId) {
		this.packagePrepayId = packagePrepayId;
	}
	public String getCallback_url() {
		return callback_url;
	}
	public void setCallback_url(String callback_url) {
		this.callback_url = callback_url;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getPaySign() {
		return paySign;
	}
	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}
	@Override
	public String toString() {
		return "PayInfo [appId=" + appId + ", timeStamp=" + timeStamp + ", status=" + status + ", signType=" + signType
				+ ", packagePrepayId=" + packagePrepayId + ", callback_url=" + callback_url + ", nonceStr=" + nonceStr
				+ ", paySign=" + paySign + "]";
	}
}
