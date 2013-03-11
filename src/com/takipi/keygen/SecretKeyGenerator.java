package com.takipi.keygen;

public class SecretKeyGenerator
{
	private static final int CHECKSUM_SIZE = 4;
	
	private static final String KEY_DELIM = "#";
	
	public static String generateKey(String prefix)
	{
		String privateKey = KeyUtil.getSecureRandomString();
		
		String combineKey = prefix + KEY_DELIM + privateKey;
		
		String checksum = KeyUtil.generateMd5ForKey(combineKey, CHECKSUM_SIZE);
		
		return combineKey + KEY_DELIM + checksum;
	}
}
