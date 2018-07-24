package com.jilepay.guangda.protocol.pay;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.base.BaseReqData;

public class QrCodePayOfAlipayReqData extends BaseReqData {

	private String out_trade_no;// 商户订单号
	private String device_info;// 设备号
	private String body;// 商品描述
	private String attach;// 附加信息
	private Integer total_fee;// 总金额
	private String mch_create_ip;// 终端IP
	private String notify_url;// 通知地址
	private String time_start;// 订单生成时间
	private String time_expire;// 订单超时时间
	private String op_user_id;// 操作员
	private String goods_tag;// 商品标记
	private String product_id;// 预留字段
	public QrCodePayOfAlipayReqData(){
		
	}
	public QrCodePayOfAlipayReqData(GuangdaMchSettings guangdaMchSettings, String service, String version,
			String charset, String sign_type, String out_trade_no, String device_info, String body, String attach,
			Integer total_fee, String mch_create_ip, String notify_url, String time_start, String time_expire,
			String op_user_id, String goods_tag, String product_id) {
		super(guangdaMchSettings, service);
		this.out_trade_no = out_trade_no;
		this.device_info = device_info;
		this.body = body;
		this.attach = attach;
		this.total_fee = total_fee;
		this.mch_create_ip = mch_create_ip;
		this.notify_url = notify_url;
		this.time_start = time_start;
		this.time_expire = time_expire;
		this.op_user_id = op_user_id;
		this.goods_tag = goods_tag;
		this.product_id = product_id;
	}

	public QrCodePayOfAlipayReqData(GuangdaMchSettings guangdaMchSettings, String service, String out_trade_no,
			String body, Integer total_fee, String mch_create_ip, String notify_url) {
		this(guangdaMchSettings, service, null, null, null, out_trade_no, null, body, null, total_fee, mch_create_ip,
				notify_url, null, null, null, null, null);
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

	public String getOp_user_id() {
		return op_user_id;
	}

	public void setOp_user_id(String op_user_id) {
		this.op_user_id = op_user_id;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
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
