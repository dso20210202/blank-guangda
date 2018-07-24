package com.jilepay.guangda.protocol.base;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.jilepay.guangda.common.RandomStringGenerator;
import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

public abstract class BaseReqData {

	protected String mch_id;// 商户号
	protected String sign_agentno;//光大分配的渠道号(微信专用)
	protected String service;// 接口类型
	protected String version;// 版本号
	protected String charset;// 字符集
	protected String sign_type;// 签名方式
	protected String nonce_str;// 随机字符串
	protected String sign;// 签名
	
	@XStreamOmitField
	protected GuangdaMchSettings guangdaMchSettings;
	
	public BaseReqData(GuangdaMchSettings guangdaMchSettings, String mch_id, String service, String version, String charset, String sign_type,
			String nonce_str, String sign) {
		this.guangdaMchSettings = guangdaMchSettings;
		this.mch_id = guangdaMchSettings.getMchId();
		this.sign_agentno = guangdaMchSettings.getSign_agentno();
		this.service = service;
		this.version = version;
		this.charset = charset;
		this.sign_type = sign_type;
		this.nonce_str = RandomStringGenerator.getRandomStringByLength(32);
		this.sign = sign;
	}
	
	public BaseReqData(GuangdaMchSettings settings, String service){
		this(settings, null, service, null, null, null, null, null);
	}

	public BaseReqData() {
	}
	
	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getSign_agentno() {
		return sign_agentno;
	}

	public void setSign_agentno(String sign_agentno) {
		this.sign_agentno = sign_agentno;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public GuangdaMchSettings getGuangdaMchSettings() {
		return guangdaMchSettings;
	}

	public void setGuangdaMchSettings(GuangdaMchSettings settings) {
		this.guangdaMchSettings = settings;
	}
	
	public Map<String, Object> toMap(){
		Map<String, Object> map = new HashMap<String, Object>();

		Class<? extends Object> clazz = this.getClass();
		do {
			
			Method[] methods = clazz.getDeclaredMethods();
			Field[] fields = clazz.getDeclaredFields();
			toMapHandle(this, methods, fields, map);
			
			clazz = clazz.getSuperclass();
		} while (!clazz.getName().equals(Object.class.getName()));

		return map;
	}
	
	private void toMapHandle(Object object, Method[] methods, Field[] fields, Map<String, Object> map){
		
		for (Field field : fields) {
			
			String fieldName = field.getName();
			Object obj = this.getFieldObject(object, fieldName, methods);
			
			if (obj != null) {
				// GuangdaMchSettings 不加入签名
				if (!(obj instanceof GuangdaMchSettings)) {
					map.put(fieldName, obj);
				}
			}
		}
	}
	
	private Object getFieldObject(Object object, String fieldName, Method[] methods){
		
		if (null == fieldName || fieldName.length() == 0){
			return null;
		}
		
		String firstString = fieldName.substring(0, 1);
		String methodName = "get" + firstString.toUpperCase() + fieldName.substring(1, fieldName.length());
		
		for (Method method : methods){
			if (method.getName().equals(methodName)){
				try {
					return method.invoke(object);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
					return null;
				} 
			}
		}
		
		return null;
	}
}
