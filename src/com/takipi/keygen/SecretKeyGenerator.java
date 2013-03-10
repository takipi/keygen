package com.takipi.keygen;

public class SecretKeyGenerator
{
	private static final int CHECKSUM_SIZE = 4;
	
	public static String generateKey(String prefix)
	{
		String privateKey = KeyUtil.getSecureRandomString();
		
		String combineKey = prefix + "#" + privateKey;
		
		String checksum = KeyUtil.generateMd5ForKey(combineKey, CHECKSUM_SIZE);
		
		return combineKey + "#" + checksum;
	}
}
