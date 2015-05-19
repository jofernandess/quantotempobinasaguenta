/**
 * 
 */
package org.bet.binas.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @author jonny
 *
 */
public class Security {

	// cheap random alpha-numeric-string
	private static final char[] symbols;

	static {
		StringBuilder tmp = new StringBuilder();
		for (char ch = '0'; ch <= '9'; ++ch)
			tmp.append(ch);
		for (char ch = 'a'; ch <= 'z'; ++ch)
			tmp.append(ch);
		symbols = tmp.toString().toCharArray();
	}

	private final Random random = new Random();

	private char[] buf;

	public void RandomString(int length) {
		if (length < 1)
			throw new IllegalArgumentException("length < 1: " + length);
		buf = new char[length];
	}

	public String nextString() {
		for (int idx = 0; idx < buf.length; ++idx)
			buf[idx] = symbols[random.nextInt(symbols.length)];
		return new String(buf);
	}

	// expensive random alpha-numeric-string
	private SecureRandom secureRandom = new SecureRandom();

	public String nextSessionId() {
		return new BigInteger(130, secureRandom).toString(32);
	}

	// Hashing a token with Md5 and salt
	public String MD5Security(String tokenPlusSalt) {

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(tokenPlusSalt.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
