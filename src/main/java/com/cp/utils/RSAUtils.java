/**
 * RSA加解密工具类
 */
package com.cp.utils;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**

 */
public class RSAUtils {

	    //公钥加密
	    public static String encrypt(String content, PublicKey publicKey) {
	        try{
	            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");//java默认"RSA"="RSA/ECB/PKCS1Padding"
	            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
	            byte[] output = cipher.doFinal(content.getBytes());
	            StrUtil.toUpperStr(output);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return null;
	    }
	 
	    //公钥加密
	    public static byte[] encrypt(byte[] content, PublicKey publicKey) {
	        try{
	            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");//java默认"RSA"="RSA/ECB/PKCS1Padding"
	            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
	            return  cipher.doFinal(content);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return null;
	    }
	 
	    //私钥解密
	    public static byte[] decrypt(byte[] content, PrivateKey privateKey) {
	        try {
	            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	            cipher.init(Cipher.DECRYPT_MODE, privateKey);
	            return cipher.doFinal(content);
	        } catch (Exception e){
	            e.printStackTrace();
	            return null;
	        }
	    }
	    //私钥解密
	    public static String decrypt(String content, PrivateKey privateKey) {
	        try {
	            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	            cipher.init(Cipher.DECRYPT_MODE, privateKey);
	            byte [] b = cipher.doFinal(StrUtil.parseHexBinary(content));
	            return StrUtil.toUpperStr(b);
	        } catch (Exception e){
	            e.printStackTrace();
	            return null;
	        }
	    }
	 
	    /**
	     * String转公钥PublicKey
	     * @param key
	     * @return
	     * @throws Exception
	     */
	    public static PublicKey getPublicKey(String key) throws Exception {
	        byte[] keyBytes=key.getBytes();
	        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
	        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	        PublicKey publicKey = keyFactory.generatePublic(keySpec);
	        return publicKey;
	    }
	 
	    /**
	     * String转私钥PrivateKey
	     * @param key
	     * @return
	     * @throws Exception
	     */
	    public static PrivateKey getPrivateKey(String key) throws Exception {
	        byte[] keyBytes=key.getBytes();
	        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
	        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
	        return privateKey;
	    }
}
