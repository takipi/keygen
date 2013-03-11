package com.takipi.keygen.key;

public class SecretKeyGenerator
{
	private static final String KEY_DELIM = "#";
	
	private static final int CHECKSUM_SIZE = 4;
	
	public static String generateKey(String keyPrefix)
	{
		StringBuilder sb = new StringBuilder();
		
		String encryptionKey = SecretKeyUtil.generateEncryptionKey();
		
		sb.append(keyPrefix);
		sb.append(KEY_DELIM);
		sb.append(encryptionKey);
		
		String keyChecksum = SecretKeyUtil.generateKeyChecksum(sb.toString(), CHECKSUM_SIZE);
		
		sb.append(KEY_DELIM);
		sb.append(keyChecksum);
		
		return sb.toString();
	}
}
