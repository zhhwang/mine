package com.botany.mint.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

/**
 * @Description: HttpClient工具类，用于手动发POST/GET请求
 *  <p>
 *      commons-httpclient-3.1.jar
 *  </p>
 */
public class HttpClientUtil {

    /** http连接超时时间 */
    public static final int HTTP_CONNECT_TIME = 3000;
    /** http读取超时时间 */
    public static final int HTTP_READ_TIME = 5000;

    private static HttpClient client = new HttpClient();

    static {
        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams params = new HttpConnectionManagerParams();
        params.setDefaultMaxConnectionsPerHost(100);
        params.setMaxTotalConnections(1000);
        params.setConnectionTimeout(HTTP_CONNECT_TIME);
        params.setSoTimeout(HTTP_READ_TIME);
        connectionManager.setParams(params);
        client.setHttpConnectionManager(connectionManager);
        client.getParams().setConnectionManagerTimeout(HTTP_CONNECT_TIME);
    }

    /**
     * 发送post请求
     * 
     * @param url
     *            请求地址
     * @param params
     * @param type
     *            application/xml;charset=UTF-8
     * @return
     * @throws Exception
     */
    public static String post(String url, String params, String type) throws Exception {
        String resp = null;
        PostMethod postMethod = new PostMethod(url);
        try {
            postMethod.setRequestEntity(new StringRequestEntity(params, type, "UTF-8"));
            int respCode = client.executeMethod(postMethod);
            if (respCode == HttpStatus.SC_OK) {
                resp = postMethod.getResponseBodyAsString();
            } else {
                throw new RuntimeException("HttpClient Post Failed, Code:" + respCode);
            }
        } finally {
            postMethod.releaseConnection();
        }
        return resp;
    }

    /**
     * 发送get请求
     * 
     * @param url
     *            请求地址
     * @return
     * @throws Exception
     */
    public static String get(String url) throws Exception {
        String resp = null;
        GetMethod getMethod = new GetMethod(url);
        try {
            int respCode = client.executeMethod(getMethod);
            if (respCode == HttpStatus.SC_OK) {
                resp = getMethod.getResponseBodyAsString();
            } else {
                throw new RuntimeException("HttpClient Get Failed, Code:" + respCode);
            }
        } finally {
            getMethod.releaseConnection();
        }
        return resp;
    }

}
