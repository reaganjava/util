package com.reagan.util;

import java.security.Security;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @date 2013年10月29日
 * @author REAGAN
 * @version 1.0
 *          <p>
 *          Company:reagan
 *          </p>
 *          <p>
 *          Copyright:Copyright(c)2013
 *          </p>
 */
public class TDes {

	private static final String Algorithm = "DESede"; // 定义 加密算法,可用
													// DES,DESede,Blowfish
	
	private static Logger logger = Logger.getLogger(TDes.class);

	// keybyte为加密密钥，长度为24字节
	// src为被加密的数据缓冲区（源）
	public static byte[] encryptMode(byte[] keybyte, byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

			// 加密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// keybyte为加密密钥，长度为24字节
	// src为加密后的缓冲区
	public static byte[] decryptMode(byte[] keybyte, byte[] src) {
		long beginTime = System.currentTimeMillis();
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

			// 解密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		
		return null;
	}

	// 转换成十六进制字符串
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";

		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;

		}
		return hs.toUpperCase();
	}

	public static byte hex2Byte(String str) {
		String seed = "0123456789ABCDEF";
		return (byte) (seed.indexOf(str.substring(0, 1)) * 16 + seed
				.indexOf(str.substring(1, 2)));
	}

	public static byte[] hexString2Bytes(String str) {
		byte[] b = new byte[str.length() / 2];
		for (int i = 0; i < b.length; i++) {
			String s = str.substring(i * 2, i * 2 + 2);
			b[i] = hex2Byte(s);
		}
		return b;
	}
	
	public static String getDesKey() throws Exception {
		KeyGenerater.generater();
		byte[] pubKeyArray = KeyGenerater.getPubKey();
		StringBuffer desKey = new StringBuffer("");
		do {
			Random random = new Random();
			int index = random.nextInt(pubKeyArray.length);
			desKey.append((char)pubKeyArray[index]);
		} while(desKey.length() < 24);
		System.out.println(desKey.toString());
		return desKey.toString().substring(0, 24);
	}
	

	public static void main(String[] args) throws Exception {
		// 添加新安全算法,如果用JCE就要把它添加进去
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		
		final byte[] keyBytes = getDesKey().getBytes(); // 24字节的密钥
		String szSrc = "494444450683;;;";

		System.out.println("加密前的字符串:" + szSrc);

		byte[] encoded = encryptMode(keyBytes, szSrc.getBytes());
		System.out.println("加密后的字符串:" + new String(encoded));

		byte[] srcBytes = decryptMode(keyBytes, encoded);
		System.out.println("解密后的字符串:" + (new String(srcBytes)));

		String value = byte2hex(encoded);

		System.out.println(value);

		String src = new String(decryptMode(keyBytes, hexString2Bytes(value)));
		System.out.println(src);
	}

}
