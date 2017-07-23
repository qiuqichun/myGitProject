/*
 * ================================================================
 * Copyright 2008-2016 Everelegance
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Everelegance Corp. Ltd, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Everelegance.
 * 
 * ================================================================
 *  创建人: renzenggang
 *	创建时间: 2016年6月22日 - 上午9:04:25
 */
package cn.boc.sfjh.utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * AES加密Util
 * </p>
 *
 * @author renzenggang
 *
 * @version 1.0.0
 *
 * @since 1.0.0
 *
 */
public class AesUtil {

	private static final Logger logger = LoggerFactory.getLogger(AesUtil.class);

	private static final String AESTYPE = "AES/ECB/PKCS5Padding";

	public static String encrypt(String keyStr, String plainText) throws Exception {
		byte[] encrypt = null;
		try {
			Key key = generateKey(keyStr);
			Cipher cipher = Cipher.getInstance(AESTYPE);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			encrypt = cipher.doFinal(plainText.getBytes());
		} catch (Exception e) {
			logger.error("AES加密处理失败:{} / {}。", keyStr, plainText, e);
			throw e;
		}
		return new String(Base64.encodeBase64(encrypt));
	}

	public static String decrypt(String keyStr, String encryptData) throws Exception {
		byte[] decrypt = null;
		try {
			Key key = generateKey(keyStr);
			Cipher cipher = Cipher.getInstance(AESTYPE);
			cipher.init(Cipher.DECRYPT_MODE, key);
			decrypt = cipher.doFinal(Base64.decodeBase64(encryptData));
		} catch (Exception e) {
			logger.error("AES解密处理失败:{} / {}。", keyStr, encryptData, e);
			throw e;
		}
		return new String(decrypt).trim();
	}

	private static Key generateKey(String key) throws Exception {
		try {
			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
			return keySpec;
		} catch (Exception e) {
			logger.error("生成AES Key失败:{} / {}。", key, e);
			throw e;
		}

	}

	public static void main(String[] args) throws Exception {

		String keyStr = "MI2NG1511TA17ICO";

		String plainText = "lisita";

		String encText = encrypt(keyStr, plainText);
		String decString = decrypt(keyStr, encText);

		System.out.println(encText);
		System.out.println(decString);

	}
}
