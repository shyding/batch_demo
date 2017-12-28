/**
 * 
 */
package com.huawei.apw.demo.utils;

import java.util.Random;

/**
 * @author Liquid
 *
 */
public class StringUtils {
	
	public static String generateRandomString(int length) {
		return generateRandomString(length, false);
	}

	public static String generateRandomString(int length, boolean isSolidLength) {
		Random random = new Random();
		int localLength = isSolidLength?length:random.nextInt(length);
		localLength = localLength == 0?1:localLength; // 除零
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < localLength; i++) {
			int number = random.nextInt(3);
			long result = 0;
			switch (number) {
			case 0:
				result = Math.round(Math.random() * 25 + 65);
				sb.append(String.valueOf((char) result));
				break;
			case 1:
				result = Math.round(Math.random() * 25 + 97);
				sb.append(String.valueOf((char) result));
				break;
			case 2:
				sb.append(String.valueOf(new Random().nextInt(10)));
				break;
			}

		}
		return sb.toString();
	}
	
	public static String generateDoubleString(){
		Random r = new Random();
		StringBuffer buffer = new StringBuffer();
		buffer.append(r.nextInt(999999));
		buffer.append('.');
		buffer.append(r.nextInt(999));
		return buffer.toString();
	}
	
	
	public static void main(String[] args) {
		System.out.println(Double.valueOf(generateDoubleString()));
	}

}
