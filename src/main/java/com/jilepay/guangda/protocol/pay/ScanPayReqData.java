package com.jilepay.guangda.protocol.pay;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.base.BaseReqData;

/**
 * 请求被扫支付API需要提交的数据
 */
public class ScanPayReqData extends BaseReqData {

	private String groupno;// 大商户编号
	private String out_trade_no;// 商户订单号
	private String device_info;// 设备号
	private String body;// 商品描述
	private String attach;// 附加信息
	private Integer total_fee;// 总金额
	private String mch_create_ip;// 终端IP
	private String auth_code;// 授权码
	private String time_start;// 订单生成时间
	private String time_expire;// 订单超时时间
	private String op_user_id;// 操作员
	private String op_shop_id;// 门店编号
	private String op_device_id;// 设备编号
	private String goods_tag;// 商品标记
	private String sign_type;//签名类型，取值RSA_1_256，默认RSA_1_256

	public ScanPayReqData(GuangdaMchSettings mchSettings, String service, String version, String charset,
			String sign_type, String groupno, String out_trade_no, String device_info, String body, String attach,
			Integer total_fee, String mch_create_ip, String auth_code, String time_start, String time_expire,
			String op_user_id, String op_shop_id, String op_device_id, String goods_tag) {
		super(mchSettings, service);
		this.groupno = groupno;
		this.out_trade_no = out_trade_no;
		this.device_info = device_info;
		this.body = body;
		this.attach = attach;
		this.total_fee = total_fee;
		this.mch_create_ip = mch_create_ip;
		this.auth_code = auth_code;
		this.time_start = time_start;
		this.time_expire = time_expire;
		this.op_user_id = op_user_id;
		this.op_shop_id = op_shop_id;
		this.op_device_id = op_device_id;
		this.goods_tag = goods_tag;
		this.sign_type = sign_type;
	}

	public ScanPayReqData(GuangdaMchSettings mchSettings, String service, String out_trade_no, String body,
			Integer total_fee, String mch_create_ip, String auth_code,String sign_type) {
		this(mchSettings, service, null, null, sign_type, null, out_trade_no, null, body, null, total_fee, mch_create_ip,
				auth_code, null, null, null, null, null, null);
	}
	
	public ScanPayReqData(GuangdaMchSettings mchSettings, String service, String out_trade_no, String body,
			Integer total_fee, String mch_create_ip, String auth_code) {
		this(mchSettings, service, null, null, null, null, out_trade_no, null, body, null, total_fee, mch_create_ip,
				auth_code, null, null, null, null, null, null);
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

	public String getAuth_code() {
		return auth_code;
	}

	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
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

	public String getOp_shop_id() {
		return op_shop_id;
	}

	public void setOp_shop_id(String op_shop_id) {
		this.op_shop_id = op_shop_id;
	}

	public String getOp_device_id() {
		return op_device_id;
	}

	public void setOp_device_id(String op_device_id) {
		this.op_device_id = op_device_id;
	}

	public String getGroupno() {
		return groupno;
	}

	public void setGroupno(String groupno) {
		this.groupno = groupno;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	@Override
	public Map<String, Object> toMap() {

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
