package com.jilepay.guangda.protocol.query;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.base.BaseReqData;

public class RefundQueryReqData extends BaseReqData {

	private String out_trade_no;// 商户订单号
	private String transaction_id;// 光大订单号
	private String out_refund_no;// 商户退款单号
	private String refund_id;// 光大退款单号
	
	public RefundQueryReqData(GuangdaMchSettings guangdaMchSettings, String mch_id, String service, String version,
			String charset, String sign_type, String nonce_str, String sign, String out_trade_no, String transaction_id,
			String out_refund_no, String refund_id) {
		super(guangdaMchSettings, service);
		this.out_trade_no = out_trade_no;
		this.transaction_id = transaction_id;
		this.out_refund_no = out_refund_no;
		this.refund_id = refund_id;
	}
	
	public RefundQueryReqData(GuangdaMchSettings guangdaMchSettings, String service, String out_trade_no, String out_refund_no){
		this(guangdaMchSettings, null, service, null, null, null, null, null, out_trade_no, null, out_refund_no, null);
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
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
