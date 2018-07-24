package com.jilepay.guangda.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import com.jilepay.guangda.common.Configure;
import com.jilepay.guangda.common.Signature;
import com.jilepay.guangda.protocol.GuangdaMchSettings;
import com.jilepay.guangda.protocol.base.BaseReqData;

/**
 * 服务的基类
 */
public abstract class BaseService{

    //API的地址
    private String apiURL;

    //发请求的HTTPS请求器
    private IServiceRequest serviceRequest;

    public BaseService(String api) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        apiURL = api;
        Class<?> c = Class.forName(Configure.HttpsRequestClassName);
        serviceRequest = (IServiceRequest) c.newInstance();
    }

    protected String sendPost(Object xmlObj) throws UnrecoverableKeyException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        return serviceRequest.sendPost(apiURL,xmlObj);
    }

    /**
     * @param request 实现了IserviceRequest接口的HttpsRequest
     */
    public void setServiceRequest(IServiceRequest request){
        serviceRequest = request;
    }
    
    /**
     * 对象属性签名
     */
    public String sign(BaseReqData baseReqData){
    	GuangdaMchSettings gms = baseReqData.getGuangdaMchSettings();
    	if(gms.getKey()==null||gms.getKey().trim().length()<8)
    	{//rsa签名
    		return Signature.getSignRsa(baseReqData.toMap(), gms);
    	}else{
    		
    		return Signature.getSign(baseReqData.toMap(), gms);
    	}
    }
}
