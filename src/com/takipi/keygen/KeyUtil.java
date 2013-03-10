package com.takipi.keygen;

import java.security.MessageDigest;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Base64;

import com.takipi.keygen.util.HexUtil;

public class KeyUtil
{
	private static final String MESSAGE_DIGEST_ALGORITHM 	= "MD5";
	private static final String KEY_GENERATOR_ALGORITHM 	= "AES";
	private static final int 	KEY_GENERATOR_SIZE 			= 256;
	
	public static String getSecureRandomString()
	{
		try
		{
			KeyGenerator kgen = KeyGenerator.getInstance(KEY_GENERATOR_ALGORITHM);
			kgen.init(KEY_GENERATOR_SIZE);
			SecretKey key = kgen.generateKey();
			byte[] bytes = key.getEncoded();
			
			return Base64.encodeBase64String(bytes);
		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	public static String generateMd5ForKey(String key, int size)
	{
		try
		{
			byte[] bytes = key.getBytes("UTF-8");
			
			MessageDigest md = MessageDigest.getInstance(MESSAGE_DIGEST_ALGORITHM);
			byte[] thedigest = md.digest(bytes);
			
			String md5Hex = HexUtil.toHexString(thedigest);
			return md5Hex.substring(0, size);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
