package com.jilepay.guangda.common;

/**
 * 这里放置各种配置数据
 */
public class Configure {

	//1）被扫支付API
	public static String PAY_API = "https://pay.swiftpass.cn/pay/gateway";

	public static String HttpsRequestClassName = "com.jilepay.guangda.common.HttpsRequest";

	public static void setHttpsRequestClassName(String name){
		HttpsRequestClassName = name;
	}
	
	//public static String platPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqNxzebovJ6R+LF0jFyJD4vgdvj+Apmb5h+pW3T0EtDzWZAr7tyiSAtNedYvRjJCqN5cYw0rIwGMZFbD3lQHbJGC+IvpqXwPB8AWqRAwItI82fo2+AyHkq11yE27IgOjSrKofgg3GWJ6SSQonYuXZ0c09chXXiZPKYe0zRbvq83kAVsYDu1sMwi8mfiVff6CIALsehs1MOjmdLW40N1CicVmJaWuh2yee+sj1/0xMOlV1LyJq63hShBD7T93qpGbHoNkpdz+BFc2byrhv1idbB4DRbUiKynzj3FX2Nz8Dv9TFQv8p2Z8dIOst890atv3P8DO7a9FI8I1reLvFDdyPawIDAQAB";

}
