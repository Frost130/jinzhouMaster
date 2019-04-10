package com.cp.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{

    static String enc="utf-8";
    /**
     * 对byte数组进行md5处理，结果为16字节的位byte数组
     * @param b
     * @return
     */
    public static byte[] toMd5Bytes(byte[] b)
    {
        MessageDigest currentAlgorithm;
        try
        {
            currentAlgorithm = MessageDigest.getInstance("MD5");
            currentAlgorithm.reset();
            currentAlgorithm.update(b);
            return currentAlgorithm.digest();

        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 对字串进行md5处理，结果为小写32字节长字串
     * @param args 需要处理的md5
     * @return
     */
    public static String toMd5Lower(String args,String encoding)
    {
        try
        {
            byte[] pending=args.getBytes(encoding);
            return StrUtil.toLowerStr(toMd5Bytes(pending));
        }
        catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";

    }

    /**
     * 对字串进行md5处理，结果为大写32字节长字串，同computeDigest
     * @param args 需要处理的md5
     * @return
     */
    public static String toMd5Upper(String args,String encoding)
    {
        try
        {
            return StrUtil.toUpperStr(toMd5Bytes(args.getBytes(encoding)));
        }
        catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";

    }
    /**
     * 对字串进行md5处理，结果为小写32字节长字串
     * @param args 需要处理的md5
     * @return
     */
    public static String toMd5Lower(String args)
    {
        return toMd5Lower(args,enc);

    }

    /**
     * 对字串进行md5处理，结果为大写32字节长字串，同computeDigest
     * @param args 需要处理的md5
     * @return
     */
    public static String toMd5Upper(String args)
    {
        return toMd5Upper(args,enc);

    }

    /**
     * 对字串进行md5处理，结果为大写32字节长字串,同toMd5Upper
     * @param args 需要处理的md5
     * @return
     */

    public static String computeDigest(String args)
    {
        return toMd5Upper(args);
    }

}
