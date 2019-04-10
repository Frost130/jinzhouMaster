package com.cp.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * crypto 加密工具
 *
 */
public class CryptoUtil {
	String type;//加密类型AES (128)、DES (56)、DESede (168)、HmacSHA1HmacSHA256
	Integer keySize;//密码长度若是“AES”，可以是128, 192或256位，“DES”算法，则密钥长度必须是56位；若是“DESede”，则可以是112或168位
    //加密
    public String encrypt(String content, SecretKey key) throws Exception {
    	return StrUtil.toUpperStr(encrypt(content.getBytes("utf-8"),key));
    }
    
    //加密
    public byte[] encrypt(byte[] content, SecretKey key) throws Exception {
		Cipher c = Cipher.getInstance(type);
		c.init(Cipher.ENCRYPT_MODE, key);
		return c.doFinal(content);   	
    }
    public CryptoUtil(String type,Integer keySize) {
		super();
		this.type = type;
		this.keySize = keySize;
	}
    public CryptoUtil(String type) {
		super();
		this.type = type;
		this.keySize = null;
	}

	//解密
    public byte[] decrypt(byte[] content, SecretKey key) throws Exception {
		Cipher c = Cipher.getInstance(type);
		c.init(Cipher.DECRYPT_MODE, key);
		return c.doFinal(content);   	    	
    }
    //解密
    public String decrypt(String content, SecretKey key) throws Exception {
    	return new String(decrypt(StrUtil.parseHexBinary(content),key),"utf-8");
   	
    }
    /**
     * 通过key因子获得密钥
     * @param keyFactor key因子
     * @param size 指定生成秘钥的大小，若是“AES”，可以是128, 192或256位，“DES”算法，则密钥长度必须是56位；若是“DESede”，则可以是112或168位
     * @return
     * @throws NoSuchAlgorithmException 
     */
    public SecretKey getKey(String keyFactor) throws NoSuchAlgorithmException
    {
    	KeyGenerator keygen = KeyGenerator.getInstance(type);
    	if (keySize==null)
    		keygen.init(new SecureRandom(keyFactor.getBytes()));
    	else    		
    		keygen.init(keySize, new SecureRandom(keyFactor.getBytes()));
		//生成密钥
		return  keygen.generateKey();
   	
    }
    public SecretKey getKey() throws NoSuchAlgorithmException
    {
    	KeyGenerator keygen = KeyGenerator.getInstance(type);
		return  keygen.generateKey();
   	
    }
    public byte[] encrypt(byte[] content, SecretKey key, String keyFactor) throws Exception {
		Cipher c = Cipher.getInstance(type);
		c.init(Cipher.ENCRYPT_MODE,key, new SecureRandom(keyFactor.getBytes()));
		return c.doFinal(content);   	
    }
   public String encrypt(String content, SecretKey key, String keyFactor) throws Exception {
    	return StrUtil.toUpperStr(encrypt(content.getBytes("utf-8"),key,keyFactor));
    }

}
