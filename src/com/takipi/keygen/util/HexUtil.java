package com.takipi.keygen.util;

import java.io.UnsupportedEncodingException;

public class HexUtil
{
	private static final byte[] HEX_CHAR_TABLE = {
		(byte)'0', (byte)'1', (byte)'2', (byte)'3',
		(byte)'4', (byte)'5', (byte)'6', (byte)'7',
		(byte)'8', (byte)'9', (byte)'a', (byte)'b',
		(byte)'c', (byte)'d', (byte)'e', (byte)'f' };
	
	public static String toHexString(byte[] raw)
	{
		byte[] hex = new byte[2 * raw.length];
		
		for (int i = 0; i < raw.length; i++)
		{
			int v = raw[i] & 0xFF;
			
			hex[2 * i]		= HEX_CHAR_TABLE[v >>> 4];
			hex[2 * i + 1]	= HEX_CHAR_TABLE[v & 0xF];
		}
		
		try
		{
			return new String(hex, "UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			throw new IllegalStateException(e);
		}
	}
}
