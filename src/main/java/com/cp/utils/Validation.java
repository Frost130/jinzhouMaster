package com.cp.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

import static com.cp.utils.StrUtil.*;


public class Validation {

    /**
     * 字符串是否符合指定的正则表示式规则
     * 当要用同个模式，校验多个值时，效率高
     * @param str
     * @param pattern 编译后的正则表示式 ，比如Pattern.compile("1[3|4|5|7|8][0-9]\\d{8}") 
     * @return
     */
    public static boolean isValid(String str,Pattern pattern)
    {
        return isRegexStr(str,pattern);
    }

	/**
	 * 	字符串是否为合法用户名
	 * 规则：长度为3-20位的任何非空白字串
	 * @param loginName		需要校验的用户名
	 * @return				返回结果符合返回true
	 */
	public static boolean isValidLoginName(String loginName){
	    return trimLengthRange(loginName,3,20);
	}
	
	/**
	 * 	字符串是否为合法密码
	 * 规则：长度为6-16位的任何字串
	 * @param password		需要校验的密码
	 * @return				返回结果符合返回true
	 */
	public static boolean isValidPassword(String password){
	    return lengthRange(password,6,16);
	}
	
	/**
	 * 	字符串是否为合法email
	 * @param email		需要校验的email
	 * @return			返回结果符合返回true
	 */
	public static boolean isValidEmail(String email){
		String re ="^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$"; 
		return isNotEmpty(email)&&email.matches(re);
	}
	
	/**
	 * 	是否为合法的中国手机号码
	 * @param mobile	需要校验的手机
	 * @return			返回结果符合返回true
	 */
	public static boolean isValidMobile(String mobile){
		return isNotEmpty(mobile)&&mobile.matches("1[3|4|5|7|8][0-9]\\d{8}") ;
	}
	/**
	 * 是否为合法的姓名
	 * 规则：长度2-5位的全中文或中间带点中文串为或2-30位的全或中间空隔英文串
	 * @return
	 */
	public static boolean isValidName(String name)
	{
	    if(isBlank(name))
	        return false;
	    if (isHan(name))//全为汉字
	        return lengthRange(name,2,5);
	    if (name.matches("[\u4e00-\u9fa5]+(·?[\u4e00-\u9fa5]+)*"))
	        return trimLengthRange(name,2,25);
	    if (name.matches("[a-zA-Z]+[ a-zA-Z]*"))
	        return trimLengthRange(name,2,30);
	    return false;
	}
	public static boolean isValidIP(String ip)
	{
	    //String ipRule="(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";
	    //用正则表达式效率低
	    
        if (ip==null||ip.length()<"0.0.0.0".length()||ip.length()>"255.255.255.255".length())
            return false;
        String[] ipSects=ip.trim().split("\\.");
        if (ipSects.length!=4)
            return false;
        try
        {
            for (String s:ipSects)
            {
                int value=Integer.parseInt(s);
                if (value<0||value>255)
                    return false;
            }
        }
        catch (NumberFormatException e)
        {
            return false;
        }
	    return true;
	}
	/**
	 * 加密密码
	 * @param password 需要加密的密码
	 * @param factor1 加密因子1
	 * @param factor2 加密因子2
	 * @return 加密后的密码
	 */
	private static byte[] encrypt(byte[] content,byte[] factor1,byte[] factor2)
	{
        byte[] b=content.clone();
	        for(int i=0;i<b.length;i++){  
	            for(byte keyBytes0:factor1){  
	                b[i] = (byte) (b[i]^keyBytes0);  
	            }  
	            for(byte keyBytes0:factor2){  
	                b[i] = (byte) (b[i]^keyBytes0);  
	            }  
	        }  
        return b;  
	}
	public static String encryptPassword(String password,byte[] factor1,byte[] factor2)
	{
		try {
			return StrUtil.toUpperStr(encrypt( password.getBytes("utf-8"),factor1,factor2));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}  
	}
	public static String encryptPassword(String password,String factor1,String factor2)
	{
		try {
			return StrUtil.toUpperStr(encrypt( password.getBytes("utf-8"),factor1.getBytes("utf-8"),factor2.getBytes("utf-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}  
	}
	/**
	 * 解密密码
	 * @param encryptedPwd 已加密的密码
     * @param factor1 加密因子1
     * @param factor2 加密因子2
	 * @return 解密后的密码
	 */
    public static String decryptPassword(String encryptedPwd,byte[] factor1,byte[] factor2)
    {
		try {
			return new String(encrypt( StrUtil.parseHexBinary(encryptedPwd),factor1,factor2),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}  
    }
    public static String decryptPassword(String encryptedPwd,String factor1,String factor2)
    {
		try {
			return new String(encrypt( StrUtil.parseHexBinary(encryptedPwd),factor1.getBytes("utf-8"),factor2.getBytes("utf-8")),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}  
    }
}
