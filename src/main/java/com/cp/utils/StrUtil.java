/**
 * StrUtil.java 
 * 版权所有@2014 前沿体育
 * Create by 郑水金
 * At 2015-11-2 下午6:28:39
 */
package com.cp.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**字符串处理类
 */
public class StrUtil
{
    final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
        '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    final static char[] udigits = { '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    /**
     * 把字节数组转成大写字串
     * @param b 字节数组 
     * @return 转换后的大写字串
     */
    public static String toUpperStr(byte[] b)
    {
        StringBuilder d = new StringBuilder(b.length * 2 + 2);
        for (int i = 0; i < b.length; i++)
        {
            d.append(udigits[((b[i] & 0xF0) >> 4)]);
            d.append(udigits[(b[i] & 0x0F)]);

        }
        return d.toString();

    }
    /**
     * 把字节数组转成小写字串
     * @param b 字节数组 
     * @return 转换后的小写字串
     */

    public static String toLowerStr(byte[] b)
    {
        StringBuilder d = new StringBuilder(b.length * 2 + 2);
        for (int i = 0; i < b.length; i++)
        {
            d.append(digits[((b[i] & 0xF0) >> 4)]);
            d.append(digits[(b[i] & 0x0F)]);

        }
        return d.toString();

    }
    /**
     * 把字节数组转成打印字串，同转成大写字串
     * @param b 字节数组 
     * @return 转换后的大写字串
     */
    public static String printHexBinary(byte[] b) {
    	return toUpperStr(b);
    }
    private static int hexToBin(char ch) {
        if ('0' <= ch && ch <= '9') {
            return ch - '0';
        }
        if ('A' <= ch && ch <= 'F') {
            return ch - 'A' + 10;
        }
        if ('a' <= ch && ch <= 'f') {
            return ch - 'a' + 10;
        }
        return -1;
    }
    /**
     * 把十六进制的字串转成字节数组
     * @param s 长度必须是2的倍数
     * @return 字节数组
     */
   public static byte[] parseHexBinary(String s) {
        final int len = s.length();

        // "111" is not a valid hex encoding.
        if (len % 2 != 0) {
            throw new IllegalArgumentException("hexBinary needs to be even-length: " + s);
        }

        byte[] out = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            int h = hexToBin(s.charAt(i));
            int l = hexToBin(s.charAt(i + 1));
            if (h == -1 || l == -1) {
                throw new IllegalArgumentException("contains illegal character for hexBinary: " + s);
            }

            out[i / 2] = (byte) (h * 16 + l);
        }

        return out;
    }
    /**
     * 字串是否为空串
     * @param str
     * @return
     */
    public static boolean isEmpty(String str)
    {
        return str==null||str.isEmpty();
    }
    /**
     * 字串是否不为空串
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str)
    {
        return str!=null&&!str.isEmpty();
    }
    /**
     * 字串是否为空白串
     * 相比isEmpty，空隔、制表符串本方法返回true
     * @param str
     * @return
     */
    public static boolean isBlank(String str)
    {
        return str==null||str.trim().isEmpty();
    }
    /**
     * 字串是否不为空白串
     * @param str
     * @return
     */    
    public static boolean isNotBlank(String str)
    {
        return str!=null&&!str.trim().isEmpty();
    }
    /**
     * 字符串是否符合指定的正则表示式规则
     * 当要用同个规则，校验多个值时，效率高
     * @param str
     * @param pattern 编译后的正则表示式 ，比如Pattern.compile("1[3|4|5|7|8][0-9]\\d{8}") 
     * @return
     */
    public static boolean isRegexStr(String str,Pattern pattern)
    {
        if (str==null)
            return false;
        Matcher matcher = pattern.matcher(str); 
        return matcher.matches();       
    }
    
    /**
     *  字符串是否为数字字串
     * @param str    需要校验的字符串
     * @return          返回结果符合返回true
     */
    public static boolean isNumber(String str){
        return isNotEmpty(str)&&str.matches("[0-9]+") ;
    }
    /**
     * 字符串是否为十六进制数字字串
     * @param str
     * @return
     */
    public static boolean isHexNumber(String str){
        return isNotEmpty(str)&&str.matches("[0-9A-Fa-f]+") ;
    }
    
    /**
     * 字符串是否为汉字字串
     * @param str
     * @return
     */
    public static boolean isHan(String str)
    {
        return isNotEmpty(str)&&str.matches("[\u4e00-\u9fa5]+");
    }
    /**
     *  字符串是否为英文字串
     * @param str
     * @return
     */
    public static boolean isAlpha(String str)
    {
        return isNotEmpty(str)&&str.matches("[a-zA-Z]+");
    }
    /**
     * 字符串是否为英文和数字字串
     * @param str
     * @return
     */
    public static boolean isAlphaOrNumber(String str)
    {
        return isNotEmpty(str)&&str.matches("[a-zA-Z0-9]+");
    }
    /**
     * 子串长度是否在指定（含）之间
     * @param str
     * @param minLen 长度小值
     * @param maxLen 长度大值
     * @return
     */
    
    public static boolean lengthRange(String str,int minLen,int maxLen)
    {
        return isNotEmpty(str)&&str.length()>=minLen&&str.length()<=maxLen;        
    }
    /**
     * 去掉前后空白后子串长度是否在指定（含）之间
     * @param str
     * @param minLen 长度小值
     * @param maxLen 长度大值
     * @return
     */
    
    public static boolean trimLengthRange(String str,int minLen,int maxLen)
    {
        if (str==null)
            return false;
        str=str.trim();
        return str.length()>=minLen&&str.length()<=maxLen;        
    }
    /**
     * 获取一定长度的随机字符串
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    public static String toString(byte[] buffer)
    {
    	return new String(buffer);
    }

}
