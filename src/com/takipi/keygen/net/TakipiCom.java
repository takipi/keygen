package com.takipi.keygen.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TakipiCom
{
	public static String TAKIPI_BASE_URL	= "https://app.takipi.com";
	public static String GENERATE_SERVLET	= TAKIPI_BASE_URL + "/app/keygen/generate";
	public static String REQUEST_METHOD		= "POST";
	
	public static String generateKeyPrefix(String username, String password, String packages)
	{
		try
		{
			URL url = new URL(GENERATE_SERVLET);
			
			HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();
			httpCon.setDoInput(true);
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod(REQUEST_METHOD);
			httpCon.setUseCaches(false);
			
			DataOutputStream dataOutput = new DataOutputStream(httpCon.getOutputStream());
			dataOutput.writeUTF(username);
			dataOutput.writeUTF(password);
			dataOutput.writeUTF(packages);
			dataOutput.flush();
			dataOutput.close();
			
			DataInputStream dataInput = new DataInputStream(httpCon.getInputStream());
			String idPrefix = dataInput.readUTF();
			
			if (idPrefix.isEmpty())
			{
				System.err.println("Problem generating key. Abort");
				return null;
			}
			
			return idPrefix;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println("Problem reaching to Takipi's server. Abort");
			return null;
		}
	}
}
