package com.beans;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        System.out.println("请输入字符串:");
	        String s1 = "";
	        while (true) {
	            s1 = s.nextLine();
	            /**
	             * 进行判断，将字符串s以字符串‘0’分割
	             */
	            String[] t = s1.split("0");
	            int y = 0;
	            int x = 0;
	            int z = 0;
	            for (int i = 0; i < t.length; i++) {
	                /**
	                 * 判断每个被分割出来的字符串含有1的个数。如果出现奇数个则输出NO，如果是偶数个，则进行统计并输出数量
	                 */
	                char[] c = t[i].toCharArray();
	                if (c.length != 0 && c.length % 2 == 0) {
	                    x++;
	                } else if (c.length % 2 != 0) {
	                    z++;

	                }
	            }
	            if (z == 0) {
	                for (int i = 0; i < t.length; i++) {
	                    /**
	                     * 判断每个被分割出来的字符串含有1的个数。如果出现奇数个则输出NO，如果是偶数个，则进行统计并输出数量
	                     */
	                    char[] c = t[i].toCharArray();
	                    if (c.length != 0 && c.length % 2 == 0) {
	                        y += c.length / 2;
	                    }
	                }
	            } else {
	                System.out.println("NO");
	            }
	            if (y != 0) {
	                System.out.println(y);
	            }
	        }

	    }

	    
	

}
