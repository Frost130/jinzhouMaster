/**
 * HttpUtil.java 
 * 版权所有@2014 前沿体育
 * Create by 郑水金
 * At 2014-11-21 下午1:47:46
 */
package com.cp.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: http工具
 */
public class HttpUtil
{
    static{
        System.setProperty ("jsse.enableSNIExtension", "false");
    }
    public static  List<String> getRemoteData(final String requstUrl,String Referer, final String charsetName)
    {
        List<String> result = new ArrayList<String>();
        try
        {
            URL url = new URL(requstUrl);
            URLConnection urlconn = url.openConnection(); // 抽象类
                                                          // URLConnection　　
            urlconn.setRequestProperty("Referer", Referer);
            // 是所有类的超类，它代表应用程序和 URL 之间的通信链接，通过在　　
            // URL 上调用 openConnection 方法创建连接对象　　
            urlconn.connect();
            // 使用 connect 方法建立到远程对象的实际连接　
            HttpURLConnection httpconn = (HttpURLConnection) urlconn;
            // 每个　　// HttpURLConnection　　
            // 实例都可用于生成单个请求，但是其他实例可以透明地共享连接到　　
            // HTTP 服务器的基础网络　　
            int HttpResult = httpconn.getResponseCode();
            
            // getResponseCode可以从 HTTP　　// 响应消息获取状态码　　
            if (HttpResult == HttpURLConnection.HTTP_OK)
            {

                InputStreamReader isr = new InputStreamReader(
                    httpconn.getInputStream(), charsetName);
                BufferedReader in = new BufferedReader(isr);
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                {
                    if (inputLine.length() != 0)
                    {
                        result.add(inputLine);
                    }

                }
                in.close();

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
        
    }
    public static  List<String> getRemoteData(final String requstUrl, final String charsetName)
    {
        List<String> result = new ArrayList<String>();
        try
        {
            URL url = new URL(requstUrl);
            URLConnection urlconn = url.openConnection(); // 抽象类
                                                          // URLConnection　　
            // 是所有类的超类，它代表应用程序和 URL 之间的通信链接，通过在　　
            // URL 上调用 openConnection 方法创建连接对象　　
            urlconn.connect();
            // 使用 connect 方法建立到远程对象的实际连接　
            HttpURLConnection httpconn = (HttpURLConnection) urlconn;
            // 每个　　// HttpURLConnection　　
            // 实例都可用于生成单个请求，但是其他实例可以透明地共享连接到　　
            // HTTP 服务器的基础网络　　
            int HttpResult = httpconn.getResponseCode();
            // getResponseCode可以从 HTTP　　// 响应消息获取状态码　　
            if (HttpResult == HttpURLConnection.HTTP_OK)
            {

                InputStreamReader isr = new InputStreamReader(
                    httpconn.getInputStream(), charsetName);
                BufferedReader in = new BufferedReader(isr);
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                {
                    if (inputLine.length() != 0)
                    {
                        result.add(inputLine);
                    }

                }
                in.close();

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;

    }
    public static  String getRemoteDataAsString(final String requstUrl,String Referer, final String charsetName)
    {
        StringBuilder b = new StringBuilder(1000);
        try
        {
            URL url = new URL(requstUrl);
            URLConnection urlconn = url.openConnection(); // 抽象类
                                                          // URLConnection　　
            urlconn.setRequestProperty("Referer", Referer);
            // 是所有类的超类，它代表应用程序和 URL 之间的通信链接，通过在　　
            // URL 上调用 openConnection 方法创建连接对象　　
            urlconn.connect();
            // 使用 connect 方法建立到远程对象的实际连接　
            HttpURLConnection httpconn = (HttpURLConnection) urlconn;
            // 每个　　// HttpURLConnection　　
            // 实例都可用于生成单个请求，但是其他实例可以透明地共享连接到　　
            // HTTP 服务器的基础网络　　
            int HttpResult = httpconn.getResponseCode();
            // getResponseCode可以从 HTTP　　// 响应消息获取状态码　　
            if (HttpResult == HttpURLConnection.HTTP_OK)
            {

                InputStreamReader isr = new InputStreamReader(
                    httpconn.getInputStream(), charsetName);
                BufferedReader in = new BufferedReader(isr);
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                {
                    if (inputLine.length() != 0)
                    {
                        b.append(inputLine);
                    }

                }
                in.close();

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return b.toString();
        
    }
    public static  String getRemoteDataAsString(final String requstUrl, final String charsetName)
    {
        StringBuilder b = new StringBuilder(1000);
        try
        {
            URL url = new URL(requstUrl);
            URLConnection urlconn = url.openConnection(); // 抽象类
                                                          // URLConnection　　
            // 是所有类的超类，它代表应用程序和 URL 之间的通信链接，通过在　　
            // URL 上调用 openConnection 方法创建连接对象　　
            urlconn.connect();
            // 使用 connect 方法建立到远程对象的实际连接　
            HttpURLConnection httpconn = (HttpURLConnection) urlconn;
            // 每个　　// HttpURLConnection　　
            // 实例都可用于生成单个请求，但是其他实例可以透明地共享连接到　　
            // HTTP 服务器的基础网络　　
            int HttpResult = httpconn.getResponseCode();
            // getResponseCode可以从 HTTP　　// 响应消息获取状态码　　
            if (HttpResult == HttpURLConnection.HTTP_OK)
            {

                InputStreamReader isr = new InputStreamReader(
                    httpconn.getInputStream(), charsetName);
                BufferedReader in = new BufferedReader(isr);
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                {
                    if (inputLine.length() != 0)
                    {
                        b.append(inputLine);
                    }

                }
                in.close();

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return b.toString();
        
    }
    
    public static boolean postDataToRemote(final String requstUrl,
        final String charsetName, final String data,String contentType)
    {
        try
        {
            URL url = new URL(requstUrl);
            HttpURLConnection urlconn = (HttpURLConnection) url
                .openConnection(); // 抽象类
            urlconn.setDoInput(true);
            urlconn.setDoOutput(true);
            urlconn.setRequestMethod("POST");
            urlconn.setRequestProperty("Content-Length",
                Integer.toString(data.length()));
            urlconn.setRequestProperty("Content-Type", contentType);
            urlconn.setUseCaches(false);
            urlconn.connect();
            // OutputStream outStream = urlconn.getOutputStream();
            // 获取URLConnection对象对应的输出流
            OutputStreamWriter outWriter=new OutputStreamWriter(urlconn.getOutputStream(),charsetName);
            try
            {
                // 发送请求参数
                outWriter.write(data);
                outWriter.flush();
            }
            finally
            {
                outWriter.close();
            }
            int HttpResult = urlconn.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK)
                return true;

            System.out
                .println("postDataToRemote server return error,responseCode:"
                    + HttpResult);
            return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;

    }
    public static String postDataAndHandleReturn(final String requstUrl,
        final String charsetName, final String data,String contentType)
    {
        StringBuilder b = new StringBuilder(1000);
        try
        {
            URL url = new URL(requstUrl);
            HttpURLConnection urlconn = (HttpURLConnection) url
                .openConnection(); // 抽象类
            
            urlconn.setDoInput(true);
            urlconn.setDoOutput(true);
            urlconn.setConnectTimeout(5*1000);//连接超时5秒
            urlconn.setReadTimeout(10*1000);//读超时10秒


            urlconn.setRequestMethod("POST");
            urlconn.setRequestProperty("Content-Length",
                Integer.toString(data.length()));
            urlconn.setRequestProperty("Content-Type", contentType);
            urlconn.setUseCaches(false);
            urlconn.connect();
            // OutputStream outStream = urlconn.getOutputStream();
            // 获取URLConnection对象对应的输出流
            OutputStreamWriter outWriter=new OutputStreamWriter(urlconn.getOutputStream(),charsetName);
            try
            {
                // 发送请求参数
                outWriter.write(data);
                outWriter.flush();
            }
            finally
            {
                outWriter.close();
            }
            int HttpResult = urlconn.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK)
            {

                InputStreamReader isr = new InputStreamReader(
                    urlconn.getInputStream(), charsetName);
                BufferedReader in = new BufferedReader(isr);
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                {
                    if (inputLine.length() != 0)
                    {
                        b.append(inputLine);
                    }

                }
                in.close();

            }
            else
            {
                System.out
                .println("postDataAndHandleReturn server return error,responseCode:"
                    + HttpResult);
                return "";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return b.toString();

    }
    /**
     * 发起https请求并获取结果
     * 
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return 返回的内容字串表示
     */
    public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            
            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            return buffer.toString();
        }catch (Exception e) {
            e.printStackTrace() ;
        }
        return null;
    }
    /**
     * 把url地址转换成百度短地址
     * @param url
     * @return
     */
    public static String shortUrl(String url)
    {
        try
        {
            //url=http%3A%2F%2Flocalhost%3A8080%2Fgame%2Fapi%2Flogin.do%3Fname%3Db25l%26password%3D0DA9C79F7E43A0471A07E44D8C561802%26randStr%3Dsdfsfq&alias=&access_type=web
            String param=URLEncoder.encode(url,"utf-8");
            String data= postDataAndHandleReturn("http://dwz.cn/create.php","utf-8","url="+param,"application/x-www-form-urlencoded");
            if (!StrUtil.isBlank(data))
            {
                ObjectMapper mapper=new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                try
                {
                    JsonNode node = mapper.readTree(data);
                    if(node.get("status").asInt()==0)
                        return node.get("tinyurl").asText();
                }
                catch (JsonProcessingException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return "";
        
    }

}
