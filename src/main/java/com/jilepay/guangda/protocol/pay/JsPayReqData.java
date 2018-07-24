package com.jilepay.guangda.protocol.pay;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.base.BaseReqData;

public class JsPayReqData extends BaseReqData {

	private String is_raw;// 是否原生态
	private String out_trade_no;
	private String device_info;
	private String body;
	private String sub_openid;
	private String attach;
	private Integer total_fee;
	private String mch_create_ip;
	private String notify_url;
	private String callback_url;
	private String time_start;
	private String time_expire;
	private String goods_tag;
	private String limit_credit_pay;

	public JsPayReqData(GuangdaMchSettings guangdaMchSettings, String mch_id, String service, String version,
			String charset, String sign_type, String nonce_str, String sign, String is_raw, String out_trade_no,
			String device_info, String body, String sub_openid, String attach, Integer total_fee, String mch_create_ip,
			String notify_url, String callback_url, String time_start, String time_expire, String goods_tag,
			String limit_credit_pay) {
		super(guangdaMchSettings, service);
		this.is_raw = is_raw;
		this.out_trade_no = out_trade_no;
		this.device_info = device_info;
		this.body = body;
		this.sub_openid = sub_openid;
		this.attach = attach;
		this.total_fee = total_fee;
		this.mch_create_ip = mch_create_ip;
		this.notify_url = notify_url;
		this.callback_url = callback_url;
		this.time_start = time_start;
		this.time_expire = time_expire;
		this.goods_tag = goods_tag;
		this.limit_credit_pay = limit_credit_pay;
	}
	
	public JsPayReqData(GuangdaMchSettings guangdaMchSettings, String service, String is_raw, String out_trade_no,
			String body, String sub_openid, Integer total_fee, String mch_create_ip, String notify_url) {
		this(guangdaMchSettings, null, service, null, null, null, null, null, is_raw, out_trade_no, is_raw, body, sub_openid,
				null, total_fee, mch_create_ip, notify_url, null, null, null, null, null);
	}

	public String getIs_raw() {
		return is_raw;
	}

	public void setIs_raw(String is_raw) {
		this.is_raw = is_raw;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSub_openid() {
		return sub_openid;
	}

	public void setSub_openid(String sub_openid) {
		this.sub_openid = sub_openid;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public String getMch_create_ip() {
		return mch_create_ip;
	}

	public void setMch_create_ip(String mch_create_ip) {
		this.mch_create_ip = mch_create_ip;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getCallback_url() {
		return callback_url;
	}

	public void setCallback_url(String callback_url) {
		this.callback_url = callback_url;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getLimit_credit_pay() {
		return limit_credit_pay;
	}

	public void setLimit_credit_pay(String limit_credit_pay) {
		this.limit_credit_pay = limit_credit_pay;
	}

	@Override
	public Map<String, Object> toMap()  {

		Map<String, Object> map = new HashMap<String, Object>();

		Field[] thisFields = this.getClass().getDeclaredFields();
		Field[] superFields = this.getClass().getSuperclass().getDeclaredFields();
		Field[] fields = new Field[thisFields.length + superFields.length];
		System.arraycopy(thisFields, 0, fields, 0, thisFields.length);
		System.arraycopy(superFields, 0, fields, thisFields.length, superFields.length);
		
		for (Field field : fields) {
			Object obj;
			try {
				obj = field.get(this);
				if (obj != null) {
					// GuangdaMchSettings 不加入签名
					if (!(obj instanceof GuangdaMchSettings)) {
						map.put(field.getName(), obj);
					}
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		return map;
	}

}
