/**
 * Base64.java 
 * 版权所有@2014 前沿体育
 * Create by 郑水金
 * At 2016-6-13 下午1:43:25
 */
package com.cp.utils;

import java.io.UnsupportedEncodingException;


/**Base64工具类
 */
public class Base64
{
    /**
     * 对字节数组进行base64编码
     * @param b
     * @return
     */
    public static String encode(byte[] b)
    {
        if (b!=null)
        try
        {
        	return java.util.Base64.getEncoder().encodeToString(b);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "";
        
    }
    /**
     * 对字串进行base64编码
     * @param s
     * @return
     */
    public static String encode(String s)
    {
        try
        {
        	return encode(s.getBytes("utf-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
        
    }
    /**
     * 对base64字串解码成字节数组
     * @param s
     * @return
     */
    public static byte[] decodeToBytes(String s)
    {
        if (s != null) {
             try {
            	return java.util.Base64.getDecoder().decode(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
        
    }
    
    /**
     * 对base64字串解码成字串
     * @param s
     * @return
     */
    public static String decode(String s)
    {
        byte[] b=decodeToBytes(s);
        if (b!=null)
            try
            {
            	return new String(b, "utf-8");
            }
            catch (UnsupportedEncodingException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return "";
        
    }

}
