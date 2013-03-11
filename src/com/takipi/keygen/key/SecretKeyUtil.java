package com.takipi.keygen.key;

import java.security.MessageDigest;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Base64;

import com.takipi.keygen.util.HexUtil;

public class SecretKeyUtil
{
	private static final String	CHECKSUM_STRING_ENCODING	= "UTF-8";
	private static final String	CHECKSUM_DIGEST_ALGORITHM	= "MD5";
	
	private static final String	ENCRYPTION_KEY_ALGORITHM	= "AES";
	private static final int	ENCRYPTION_KEY_SIZE			= 256;
	
	public static String generateEncryptionKey()
	{
		try
		{
			KeyGenerator kgen = KeyGenerator.getInstance(ENCRYPTION_KEY_ALGORITHM);
			kgen.init(ENCRYPTION_KEY_SIZE);
			
			SecretKey key = kgen.generateKey();
			byte[] bytes = key.getEncoded();
			
			return Base64.encodeBase64String(bytes);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static String generateKeyChecksum(String key, int size)
	{
		try
		{
			byte[] bytes = key.getBytes(CHECKSUM_STRING_ENCODING);
			byte[] digest = MessageDigest.getInstance(CHECKSUM_DIGEST_ALGORITHM).digest(bytes);
			
			String md5Hex = HexUtil.toHexString(digest);
			String result = md5Hex.substring(0, size);
			
			return result;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
