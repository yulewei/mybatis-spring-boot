package com.example.util;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HTTP 工具类
 *
 * @author yulewei
 */
public class HttpUtils {

    private static CloseableHttpClient httpClient = null;
    public static final String DEFAULT_CHARSET = "UTF-8";

    static {
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(30000)
                .setConnectTimeout(30000)
                .setConnectionRequestTimeout(30000).build();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setDefaultConnectionConfig(ConnectionConfig.custom().setCharset(Consts.UTF_8).build());
        connManager.setDefaultMaxPerRoute(10); // 设置最大路由
        connManager.setMaxTotal(50);          // 设置最大链接数

        httpClient = HttpClients.custom()
                .setConnectionManager(connManager)
                .setDefaultRequestConfig(requestConfig).build();
//        httpClient = HttpClients.createDefault(); // 底层默认使用 PoolingHttpClientConnectionManager
    }

    /**
     * POST 表单
     *
     * @param url
     * @param params
     * @return
     */
    public static String postForm(String url, Map<String, String> params) {
        return postForm(httpClient, url, params, null, DEFAULT_CHARSET);
    }

    public static String postForm(String url, Map<String, String> params, Map<String, String> header) {
        return postForm(httpClient, url, params, header, DEFAULT_CHARSET);
    }

    public static String postForm(String url, Map<String, String> params, String charset) {
        return postForm(httpClient, url, params, null, charset);
    }

    public static String postForm(CloseableHttpClient httpClient, String url, Map<String, String> params, Map<String, String> header, String charset) {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            for (String name : params.keySet()) {
                formParams.add(new BasicNameValuePair(name, params.get(name)));
            }
            HttpEntity reqEntity = new UrlEncodedFormEntity(formParams, charset);
            httpPost.setEntity(reqEntity);
            if (header != null) {
                for (String name : header.keySet()) {
                    httpPost.addHeader(name, header.get(name));
                }
            }
            response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        } finally {
            HttpClientUtils.closeQuietly(response);
        }
    }

    /**
     * POST json 格式数据
     *
     * @param url
     * @param json
     * @return
     */
    public static String postJson(String url, String json) {
        return postJson(httpClient, url, json, null, DEFAULT_CHARSET);
    }

    public static String postJson(String url, String json, String charset) {
        return postJson(httpClient, url, json, null, charset);
    }

    public static String postJson(CloseableHttpClient httpClient, String url, String json, Map<String, String> header, String charset) {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            StringEntity reqEntity = new StringEntity(json, charset);
            reqEntity.setContentType("application/json; charset=" + charset); // 设置为 json 数据
            httpPost.setEntity(reqEntity);
            if (header != null) {
                for (String name : header.keySet()) {
                    httpPost.addHeader(name, header.get(name));
                }
            }
            response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity(), charset);
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        } finally {
            HttpClientUtils.closeQuietly(response);
        }
    }

    /**
     * POST 文件
     *
     * @param url
     * @param inputName
     * @param file
     * @return
     */
    public static String postFile(String url, String inputName, File file) {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            FileBody fileBody = new FileBody(file);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create().addPart(inputName, fileBody);
            HttpEntity reqEntity = builder.build();
            httpPost.setEntity(reqEntity);
            response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        } finally {
            HttpClientUtils.closeQuietly(response);
        }
    }

    /**
     * GET 请求
     *
     * @param url
     * @return
     */
    public static String get(String url) {
        return get(httpClient, url, null, DEFAULT_CHARSET);
    }

    public static String get(String url, String charset) {
        return get(httpClient, url, null, charset);
    }

    public static String get(CloseableHttpClient httpClient, String url, Map<String, String> header, String charset) {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            if (header != null) {
                for (String name : header.keySet()) {
                    httpGet.addHeader(name, header.get(name));
                }
            }
            response = httpClient.execute(httpGet);
            return EntityUtils.toString(response.getEntity(), charset);
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        } finally {
            HttpClientUtils.closeQuietly(response);
        }
    }

}
