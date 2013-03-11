package com.takipi.keygen.instructions;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;

public class InstructionsVelocity
{
	private static final String TEMPLATE_FILE = "key_file.vm";
	
	static
	{
		Properties prop = buildProperties();
		
		try
		{
			Velocity.init(prop);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String generateText(String username, String secretKey, String proxy)
	{
		VelocityContext ctx = new VelocityContext();
		
		ctx.put("username", username);
		ctx.put("secret_key", secretKey);
		ctx.put("proxy", proxy);
		
		try
		{
			return mergeContextAndVelocity(TEMPLATE_FILE, ctx);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	private static String mergeContextAndVelocity(String templateFile, VelocityContext ctx) throws Exception
	{
		StringWriter sw = new StringWriter();

		Velocity.mergeTemplate(templateFile, "UTF-8", ctx, sw);

		return sw.toString();
	}
	
	private static Properties buildProperties()
	{
		Properties prop = new Properties();
		prop.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_CACHE, "false");
		prop.setProperty("file.resource.loader.modificationCheckInterval", "0");
		
		prop.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
		prop.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, "");
		
		prop.setProperty("file.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.FileResourceLoader");
		
		prop.setProperty(RuntimeConstants.RESOURCE_LOADER, "class");
		prop.setProperty("class.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		
		return prop;
	}
}
