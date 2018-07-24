package com.jilepay.guangda.common;

import org.xml.sax.SAXException;

import com.jilepay.guangda.protocol.GuangdaMchSettings;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Signature {
    /**
     * 签名算法
     * @param o 要参与签名的数据对象
     * @return 签名
     * @throws IllegalAccessException
     */
    public static String getSign(Object o,GuangdaMchSettings mchSettings) throws IllegalAccessException {
        ArrayList<String> list = new ArrayList<String>();
        Class<?> cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.get(o) != null && f.get(o) != "") {
                list.add(f.getName() + "=" + f.get(o) + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + mchSettings.getKey();
        //Util.log("Sign Before MD5:" + result);
        result = MD5.MD5Encode(result).toUpperCase();
        //Util.log("Sign Result:" + result);
        return result;
    }

    public static String getSign(Map<String,Object> map,GuangdaMchSettings mchSettings){
        ArrayList<String> list = new ArrayList<String>();
        for(Map.Entry<String,Object> entry:map.entrySet()){
            if(entry.getValue()!=""){
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + mchSettings.getKey();
        //Util.log("Sign Before MD5:" + result);
        result = MD5.MD5Encode(result).toUpperCase();
        //Util.log("Sign Result:" + result);
        return result;
    }
    
    //rsa 签名
    public static String getSignRsa(Map<String,Object> map,GuangdaMchSettings mchSettings){
        ArrayList<String> list = new ArrayList<String>();
        for(Map.Entry<String,Object> entry:map.entrySet()){
            if(entry.getValue()!=""){
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result = result.substring(0,result.length()-1);
        
       // System.out.println("relust:"+result);
      //  String private_key="MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKatwON/+23KDY+KOIKbTri+YJYBCQxxaSIpM6khuLwjGbhuAQ7+L3y7YeKujmMT8YFmkm3euPb+lshmQh+QvPYTp5j0lPKDiI9X2fKk7W55PmGwGNqPx6E4Cv+UgWYpwUnDlZRZl61mBnn6q7KKVxYMZNhK7h0pJ8yBE8PpcD/tAgMBAAECgYEAlVdZXH1vag9/1vyhZWSCREVPhReoY925tUH1Z7UvMGLCyNzHVgepxLigG9sK+PsFiEu/J3JHiAbUUvpMhLvKkb5XVI0Y0HurT/eCY9snl5ywMQRJHE3eE3qCXwsn2p2HGpegUpVDu24oSe2PUaD6XZHM9txZ7IdjtguT+w/j1AECQQDcdXCStKLxdeG7smS3IG+8AHxfRrLWd66HjRT8m5aoph1eVeF122UwQkbzrdwHVhfvBbbIWLMrCT96hQPbGwc1AkEAwYzBrxsxxAkkCpDngTZh6W6qEws2Ra7yuMRllPAb7p0XVckSOFIK4ykZZt0yPOr02qPfEBzWzerxi5sjOvsU2QJBAKozzR6mcSpkLUvA9brgQwNtiJfyOD4WFlu2k15XLOC1pvTe7vsT0DKK6MZXEwli8YVq7uwMdv8h261WplxxqIUCQALcmuyE4Wp9nBvP4qxlanMyIK+hZc8H9CzJMptOJYuUpQiurWdJx0FulSKROLHv42jsLVsmogJva9zdkVrI5ZkCQQClGrFz2wS0kOiEssTEyYLlCVYzsqdwi4NmcJzjokVCwNo1r7QOVLGgL0sKc8N7DiX2xPJJrIlZKJbPTP+k/lGM";

        //System.out.println("private_key:"+private_key.length());
        try {
			result = RSAUtil.getSign(result,mchSettings.getPrivate_key());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Util.log("Sign Result:" + result);
        return result;
    }

    /**
     * 从API返回的XML数据里面重新计算一次签名
     * @param responseString API返回的XML数据
     * @return 新鲜出炉的签名
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static String getSignFromResponseString(String responseString,GuangdaMchSettings mchSettings) throws IOException, SAXException, ParserConfigurationException {
        Map<String,Object> map = XMLParser.getMapFromXML(responseString);
        //清掉返回数据对象里面的Sign数据（不能把这个数据也加进去进行签名），然后用签名算法进行签名
        map.put("sign","");
        //将API返回的数据根据用签名算法进行计算新的签名，用来跟API返回的签名进行比较
        return Signature.getSign(map,mchSettings);
    }

    /**
     * 检验API返回的数据里面的签名是否合法，避免数据在传输的过程中被第三方篡改
     * @param responseString API返回的XML数据字符串
     * @return API签名是否合法
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static boolean checkIsSignValidFromResponseString(String responseString,GuangdaMchSettings mchSettings) throws ParserConfigurationException, IOException, SAXException {

        Map<String,Object> map = XMLParser.getMapFromXML(responseString);
        //Util.log(map.toString());

        String signFromAPIResponse = map.get("sign").toString();
        if(signFromAPIResponse=="" || signFromAPIResponse == null){
            Util.log("API返回的数据签名数据不存在，有可能被第三方篡改!!!");
            return false;
        }
        //Util.log("服务器回包里面的签名是:" + signFromAPIResponse);
        //清掉返回数据对象里面的Sign数据（不能把这个数据也加进去进行签名），然后用签名算法进行签名
        map.put("sign","");
        //将API返回的数据根据用签名算法进行计算新的签名，用来跟API返回的签名进行比较
        String signForAPIResponse = Signature.getSign(map,mchSettings);

        if(!signForAPIResponse.equals(signFromAPIResponse)){
            //签名验不过，表示这个API返回的数据有可能已经被篡改了
            Util.log("API返回的数据签名验证不通过，有可能被第三方篡改!!!");
            return false;
        }
        //Util.log("恭喜，API返回的数据签名验证通过!!!");
        return true;
    }

}
