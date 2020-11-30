package jca;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class AESCBC extends BCBase {

	public static void main(String[] args)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException {
		Cipher c1 = Cipher.getInstance("AES/CBC/NoPadding", "BC");

		Cipher c2 = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
		Cipher c3 = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");

		Cipher c4 = Cipher.getInstance("AES/CBC/ISO7816-4Padding", "BC");

		// AES must be used with these Block Cipher Modes: ["CCM", "GCM", "CBC", "CTR"]
		// (here we don't care/look at the "padding" part)
		Cipher c1ccm = Cipher.getInstance("AES/CCM/Foo"); // Compliant: AES + CCM
		Cipher c1gcm = Cipher.getInstance("AES/GCM/Foo"); // Compliant: AES + GCM
		Cipher c1cbc = Cipher.getInstance("AES/CBC/Foo"); // Compliant: AES + CBC
		Cipher c1ctr = Cipher.getInstance("AES/CTR/Foo"); // Compliant: AES + CTR
	}

}
