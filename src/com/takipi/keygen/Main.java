package com.takipi.keygen;

import com.takipi.keygen.instructions.InstructionsBuilder;
import com.takipi.keygen.key.SecretKeyGenerator;
import com.takipi.keygen.net.TakipiCom;

public class Main
{
	public static void main(String[] args)
	{
		if (!(args.length == 3 || args.length == 4))
		{
			System.out.println("Takipi Key Generator");
			System.out.println("====================");
			System.out.println("Usage: USERNAME PASSWORD NAMESPACES [SERVER-PROXY]");
			System.out.println("Example: john@example.com Pa$$woRd com.company;org.company2.product");
			
			return;
		}
		
		String username 	= args[0];
		String password 	= args[1];
		String namespaces 	= args[2];
		
		String proxy = "";
		
		if (args.length == 4)
		{
			proxy = args[3];
		}
		
		String keyPrefix = TakipiCom.generateKeyPrefix(username, password, namespaces);
		
		if (keyPrefix == null)
		{
			System.err.println("Problem creating key");
			System.err.println("Contact keygen@takipi.com for help.");
			return;
		}
		
		String secretKey = SecretKeyGenerator.generateKey(keyPrefix); 
		
		System.out.println("Your secret key is: " + secretKey);
		
		InstructionsBuilder.buildInstructionsFile(username, secretKey, proxy);
	}
}
