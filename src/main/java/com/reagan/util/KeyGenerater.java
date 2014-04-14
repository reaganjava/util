package com.reagan.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Base64; 
import org.springframework.stereotype.Component;




/**
 * 
 * <p>Description:生成公钥私钥</p>
 * @date 2013年8月14日
 * @author tongbiao
 * @version 1.0
 * <p>Company:reagan</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class KeyGenerater {
	/**
	 *私钥
	 */
	private static byte[] priKey;
	
	/**
	 * 公钥
	 */
	private static byte[] pubKey;
	
	/**
	 * 
	 * 方法用途: 使用RSA算法生成公钥、私钥<br>
	 * 实现步骤: <br>
	 * @throws Exception
	 */
	public static void generater() throws Exception {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
			SecureRandom secure = new SecureRandom();
			secure.setSeed("abcdefghijklmnopqrstuvwxyz1234567890".getBytes());// 初始化随机产生器
			keyGen.initialize(512, secure);
			KeyPair keys = keyGen.genKeyPair();
			PublicKey pubkey = keys.getPublic();
			PrivateKey prikey = keys.getPrivate();
			pubKey = new Base64().encode(pubkey.getEncoded());
			priKey = new Base64().encode(prikey.getEncoded());
		} catch (Exception e) {
			throw e;
		}
	}

	public static byte[] getPriKey() {
		return priKey;
	}

	public static byte[] getPubKey() {
		return pubKey;
	}
	
	public static void main(String[] args) throws Exception {
		//生成公钥私钥
		KeyGenerater.generater();
		//私钥
		byte[] priKey = KeyGenerater.getPriKey();
		//公钥
		byte[] pubKey = KeyGenerater.getPubKey();
		
		Signaturer signaturer = new Signaturer();
		//签名
		byte[] signData = signaturer.sign(priKey, "abcde");
		System.out.println(new String(signData));
		SignProvider signProvider = new SignProvider();
		//签名比对
		System.out.println(signProvider.verify(pubKey, "abcde", signData));
	}

}
