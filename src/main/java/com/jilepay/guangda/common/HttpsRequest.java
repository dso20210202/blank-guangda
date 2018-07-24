package com.jilepay.guangda.common;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import com.jilepay.guangda.service.IServiceRequest;
import com.thoughtworks.xstream.XStream;

public class HttpsRequest implements IServiceRequest{

    public interface ResultListener {


        public void onConnectionPoolTimeoutError();

    }

    private static Log log = new Log(LoggerFactory.getLogger(HttpsRequest.class));

    //表示请求器是否已经做了初始化工作
    private boolean hasInit = false;

    //连接超时时间，默认10秒
    private int socketTimeout = 10000;

    //传输超时时间，默认30秒
    private int connectTimeout = 30000;

    //请求器的配置
    private RequestConfig requestConfig;

    //HTTP请求器
    private CloseableHttpClient httpClient;

    public HttpsRequest() throws UnrecoverableKeyException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        init();
    }

    private void init() throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {

    	//构建不需要https证书的httpclient
        SSLContext sslContext = new SSLContextBuilder()
                .loadTrustMaterial(null, new TrustStrategy() {
                    public boolean isTrusted(X509Certificate[] x509Certificates, String s)
                            throws CertificateException {
                        // 直接返回true 不做任何验证
                        return true;
                    }
                })
                .build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
        
        httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();
        
        //根据默认超时限制初始化requestConfig
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();

        hasInit = true;
    }

    /**
     * 通过Https往API post xml数据
     *
     * @param url    API地址
     * @param xmlObj 要提交的XML数据对象
     * @return API回包的实际数据
     * @throws IOException
     * @throws KeyStoreException
     * @throws UnrecoverableKeyException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */

    public String sendPost(String url, Object xmlObj) throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {

        if (!hasInit) {
            init();
        }

        String result = null;

        HttpPost httpPost = new HttpPost(url);

        //解决XStream对出现双下划线的bug
//        XStream xStreamForRequestPostData = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
        XStream xStreamForRequestPostData = XStreamUtil.initXStream();
        xStreamForRequestPostData.autodetectAnnotations(true);  
        //将要提交给API的数据对象转换成XML格式数据Post给API
//        Util.log(xmlObj);
        String postDataXML = xStreamForRequestPostData.toXML(xmlObj);
        
//        postDataXML = "<com.jilepay.guangda.protocol.pay.QrCodePayOfAlipayReqData><out_trade_no><![CDATA[6057113230875088]]></out_trade_no>"
//        		+ "<nonce_str><![CDATA[wNzpaD0sN17KI80yBQwINNHfmOIeNqap]]></nonce_str>"
//        		+ "<time_expire><![CDATA[]]></time_expire>"
//        		+ "<mch_create_ip><![CDATA[127.0.0.1]]></mch_create_ip>"
//        		+ "<sign_type><![CDATA[RSA_1_256]]></sign_type>"
//        		+ "<total_fee><![CDATA[1]]></total_fee>"
//        		+ "<notify_url><![CDATA[http://www.baidu.cn/notify.aspx]]></notify_url>"
//        		+ "<body><![CDATA[测试购买商品]]></body>"
//        		+ "<version><![CDATA[1.0]]></version>"
//        		+ "<mch_id><![CDATA[102532336411]]></mch_id>"
//        		+ "<time_start><![CDATA[]]></time_start>"
//        		+ "<attach><![CDATA[附加信息]]></attach><service><![CDATA[pay.alipay.native]]></service>"
//        		+ "<sign><![CDATA[SE008JDir0uwOuBy8d48SmdfG37PyGvhtqu8pDTO0DpdNkgkLuegNsb6SaL/dEfzuO35bwAVwiKSc9m9xBKohGJEMtzRm3tLNnpQ0BDpLl"
//        		+ "YNWQkr0JN3JAjy6wk1icSmfbjXgEvWCcx17MUe59NfIl0JRR3MgFg/ySYq2cT4U/o6WJisxtIbre0ZPM66WL8l5gAzosJW3Gwr+B8fkRyOckF4w64i0TM2"
//        		+ "0xoSHGEa8w1utOFik5wvxyPHb/JcjhRyrBnb2LFZy5Rq3XzZLW6FaK1gunWnjK5+4NiNuHDgm7CKZPp8BphA/qnJtAMGfexEZ8J4z9ktyywDK8b8VWJ"
//        		+ "5ow==]]></sign></com.jilepay.guangda.protocol.pay.QrCodePayOfAlipayReqData>";
//        Util.log("API，POST过去的数据是：");
        Util.log(postDataXML);

        //得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
        StringEntity postEntity = new StringEntity(postDataXML, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.setEntity(postEntity);

        //设置请求器的配置
        httpPost.setConfig(requestConfig);

        Util.log("executing request" + httpPost.getRequestLine());

        try {
            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity, "UTF-8");

        } catch (ConnectionPoolTimeoutException e) {
            log.e("http get throw ConnectionPoolTimeoutException(wait time out)");
            e.printStackTrace();

        } catch (ConnectTimeoutException e) {
            log.e("http get throw ConnectTimeoutException");
            e.printStackTrace();

        } catch (SocketTimeoutException e) {
            log.e("http get throw SocketTimeoutException");
            e.printStackTrace();

        } catch (Exception e) {
        	log.e("http get throw Exception");
        	e.printStackTrace();
        } finally {
            httpPost.abort();
        }

        return result;
    }

    /**
     * 设置连接超时时间
     *
     * @param socketTimeout 连接时长，默认10秒
     */
    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
        resetRequestConfig();
    }

    /**
     * 设置传输超时时间
     *
     * @param connectTimeout 传输时长，默认30秒
     */
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        resetRequestConfig();
    }

    private void resetRequestConfig(){
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
    }

    /**
     *
     * @param requestConfig 设置HttpsRequest的请求器配置
     */
    public void setRequestConfig(RequestConfig requestConfig) {
        this.requestConfig = requestConfig;
    }
}
