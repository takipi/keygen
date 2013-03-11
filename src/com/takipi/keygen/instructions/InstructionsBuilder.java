package com.takipi.keygen.instructions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class InstructionsBuilder
{
	private static final char[] FILE_ILLEGAL_CHARACTERS		= { '/', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':' };
	
	public static void buildInstructionsFile(String username, String secretKey, String proxy)
	{
		String installInstructions = InstructionsVelocity.generateText(username, secretKey, proxy);
		
		String id = secretKey.substring(0, secretKey.indexOf('#'));
		
		String filenamePrefix = username+"-"+id;
		
		String filename = getFilenameForDownload(filenamePrefix, proxy);
		
		System.out.println("");
		
		System.out.println(installInstructions);
		
		try
		{
			FileUtils.writeStringToFile(new File(filename), installInstructions);
		}
		catch (IOException e)
		{
			System.err.println("Can't create file '" + filename + "'with install instructions");
		}
		
		System.out.println("");
		System.out.println("File saved as: " + filename);
	}
	
	private static String getFilenameForDownload(String input, String proxy)
	{
		String helper = input;
		
		for (char c : FILE_ILLEGAL_CHARACTERS)
		{
			helper = helper.replace(c, '-');
		}
		
		if ((proxy != null) && (!proxy.isEmpty()))
		{
			helper = helper + "-behind-proxy";
		}
		
		helper = helper + "-takipi.key.txt";
		
		return helper;
	}
}
