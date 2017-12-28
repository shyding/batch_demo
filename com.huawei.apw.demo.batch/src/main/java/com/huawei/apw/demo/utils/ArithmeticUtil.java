/**
 * 
 */
package com.huawei.apw.demo.utils;

/**
 * @author Liquid
 *
 */
public class ArithmeticUtil {
	
	
	public int countOne(int n, char k){
		int count = 0;
		int m_n = n;
		String m_n_s = "";
		while(m_n > 0){
			m_n_s = String.valueOf(m_n);
			for(char c : m_n_s.toCharArray()){
				count = (c==k)?++count:count;
			}
			m_n--;
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		ArithmeticUtil util = new ArithmeticUtil();
		System.out.println(util.countOne(500, '1'));
	}

}
