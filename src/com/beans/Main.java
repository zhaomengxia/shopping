package com.beans;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        System.out.println("�������ַ���:");
	        String s1 = "";
	        while (true) {
	            s1 = s.nextLine();
	            /**
	             * �����жϣ����ַ���s���ַ�����0���ָ�
	             */
	            String[] t = s1.split("0");
	            int y = 0;
	            int x = 0;
	            int z = 0;
	            for (int i = 0; i < t.length; i++) {
	                /**
	                 * �ж�ÿ�����ָ�������ַ�������1�ĸ�����������������������NO�������ż�����������ͳ�Ʋ��������
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
	                     * �ж�ÿ�����ָ�������ַ�������1�ĸ�����������������������NO�������ż�����������ͳ�Ʋ��������
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
