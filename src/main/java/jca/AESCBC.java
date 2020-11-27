package jca;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class AESCBC extends BCBase {

	public static void main(String[] args)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException {
		Cipher c1 = Cipher.getInstance("AES/CBC/NoPadding", "BC"); // Noncompliant: AES + CBC + NoPadding => invalid padding for CBC
		Cipher c1default = Cipher.getInstance("AES/CBC/NoPadding"); // Noncompliant: AES + CBC + NoPadding => invalid padding for CBC

		Cipher c2 = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC"); // Compliant: AES + CBC + PKCS5Padding
		Cipher c2default = Cipher.getInstance("AES/CBC/PKCS5Padding"); // Compliant: AES + CBC + PKCS5Padding
		Cipher c3 = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC"); // Compliant: AES + CBC + PKCS7Padding
		Cipher c3default = Cipher.getInstance("AES/CBC/PKCS7Padding"); // Compliant: AES + CBC + PKCS7Padding

		Cipher c4 = Cipher.getInstance("AES/CBC/ISO7816-4Padding", "BC"); // Compliant: AES + CBC + ISO7816-4Padding
		Cipher c4default = Cipher.getInstance("AES/CBC/ISO7816-4Padding"); // Compliant: AES + CBC + ISO7816-4Padding

		// AES must be used with these Block Cipher Modes: ["CCM", "GCM", "CBC", "CTR"] (here we don't care/look at the "padding" part)
		Cipher c1ccm = Cipher.getInstance("AES/CCM/Foo"); // Compliant: AES + CCM
		Cipher c1gcm = Cipher.getInstance("AES/GCM/Foo"); // Compliant: AES + GCM
		Cipher c1cbc = Cipher.getInstance("AES/CBC/Foo"); // Compliant: AES + CBC
		Cipher c1ctr = Cipher.getInstance("AES/CTR/Foo"); // Compliant: AES + CTR
	}

}
