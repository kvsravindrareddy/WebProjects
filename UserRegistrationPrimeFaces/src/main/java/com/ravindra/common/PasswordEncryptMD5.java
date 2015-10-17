package com.ravindra.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

public class PasswordEncryptMD5 {
	private static final Logger logger = Logger.getLogger(PasswordEncryptMD5.class);
	public static String encryptPassword(String password) {
		logger.debug("**********Password encryption started**********");
		MessageDigest digest;
		StringBuilder sb = new StringBuilder();
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(password.getBytes());
			byte[] digArr = digest.digest();
			for(int i=0;i<digArr.length;i++) {
				sb.append(Integer.toString((digArr[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			logger.error("Error occured while encrypting the password : "+e);
		}
		return sb.toString();
	}
}
