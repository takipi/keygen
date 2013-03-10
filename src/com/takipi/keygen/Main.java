package com.takipi.keygen;

public class Main
{
	public static void main(String[] args)
	{
		if (args.length != 3)
		{
			System.out.println("Takipi key Generator");
			System.out.println("Usage: USERNAME PASSWORD NAMESPACES");
			System.out.println("Example: john@example.com Pa$$woRd com.company;org.company2.product");
			
			return;
		}
		
		String username = args[0];
		String password = args[1];
		String namespaces = args[2];
		
		String keyPrefix = NetUtil.generateKeyPrefix(username, password, namespaces);
		
		if (keyPrefix == null)
		{
			System.err.println("Problem creating key");
			return;
		}
		
		String secretKey = SecretKeyGenerator.generateKey(keyPrefix); 
		
		System.out.println("Your secret key is: " + secretKey);
	}
}
