package com.gmcc.pboss.common.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SecurityPass {

	private static String Algorithm = "DES"; // 定义 加密算法,可用 DES,DESede,Blowfish

	public static byte[] getKey() throws Exception {
		KeyGenerator keygen = KeyGenerator.getInstance(Algorithm);
		SecretKey deskey = keygen.generateKey();

		return deskey.getEncoded();
	}

	public static byte[] encode(byte[] input, byte[] key) throws Exception {
		SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, Algorithm);
		Cipher c1 = Cipher.getInstance(Algorithm);
		c1.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] cipherByte = c1.doFinal(input);
		return cipherByte;
	}

	public static byte[] decode(byte[] input, byte[] key) throws Exception {
		SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, Algorithm);
		Cipher c1 = Cipher.getInstance(Algorithm);
		c1.init(Cipher.DECRYPT_MODE, deskey);
		byte[] clearByte = c1.doFinal(input);
		return clearByte;
	}

	public static String byte2hex(byte bytes[]) {
		StringBuffer retString = new StringBuffer();
		for (int i = 0; i < bytes.length; ++i) {
			retString.append(Integer.toHexString(0x0100 + (bytes[i] & 0x00FF)).substring(1).toUpperCase());
		}
		return retString.toString();
	}

	public static byte[] hex2byte(String hex) {
		byte[] bts = new byte[hex.length() / 2];
		for (int i = 0; i < bts.length; i++) {
			bts[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}
		return bts;
	}

	public static void main(String[] args) {
		String aa = "comszs123";

		if (args != null && args.length > 0) {
			aa = args[0];
		}
		try {
			//decode
			String code = byte2hex(SecurityPass.encode(aa.getBytes(), hex2byte("70469B26CBF1E575")));
			System.out.println(code);
//			System.out.println(new String(SecurityPass.decode(hex2byte(code), hex2byte("70469B26CBF1E575"))));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
