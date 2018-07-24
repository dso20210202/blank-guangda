package com.jilepay.guangda.protocol;

/**
 * 商户设置
 * 
 */
public class GuangdaMchSettings {

	//光大分配的商户号
	private String mchId;
	//光大分配的商户key
	private String key;
	//光大分配的渠道号(微信专用)
	private String sign_agentno;
	private String private_key;
	private String public_key;
	
	
	private GuangdaMchSettings(String mchId, String key, String sign_agentno,String private_key,String public_key) {
		super();
		this.mchId = mchId;
		this.key = key;
		this.sign_agentno = sign_agentno;
		this.private_key = private_key;
		this.public_key = public_key;
	}
	
	
	public String getMchId() {
		return mchId;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	public String getSign_agentno() {
		return sign_agentno;
	}

	public void setSign_agentno(String sign_agentno) {
		this.sign_agentno = sign_agentno;
	}
	
	public String getPrivate_key() {
		return private_key;
	}


	public void setPrivate_key(String private_key) {
		this.private_key = private_key;
	}


	public String getPublic_key() {
		return public_key;
	}


	public void setPublic_key(String public_key) {
		this.public_key = public_key;
	}


	public static GuangdaMchSettings buildWeixin(String mchId, String key, String sign_agentno,String private_key,String public_key){
		GuangdaMchSettings mchSettings = new GuangdaMchSettings(mchId,key,sign_agentno,private_key,public_key);
		return mchSettings;
	}
	public static GuangdaMchSettings buildAlipay(String mchId, String key,String private_key,String public_key){
		GuangdaMchSettings mchSettings = new GuangdaMchSettings(mchId,key,null,private_key,public_key);
		return mchSettings;
	}
	public static GuangdaMchSettings buildQq(String mchId, String key,String private_key,String public_key){
		GuangdaMchSettings mchSettings = new GuangdaMchSettings(mchId,key,null,private_key,public_key);
		return mchSettings;
	}
}
