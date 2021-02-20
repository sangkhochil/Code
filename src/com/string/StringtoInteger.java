package com.string;

public class StringtoInteger {

	public static void main(String[] args) {
		System.out.println(new StringtoInteger().myAtoi("-2147483648"));
	}
	public int myAtoi(String s) {
		if(s.isEmpty()) return 0;
        char[] array = s.toCharArray();
        int len = s.length();
        int i=0;
        int sign = 1;
        int value = 0;
        while(i<len && array[i] == ' ') i++;
        
        if(i< len && (array[i] == '-' || array[i] == '+')){
        	sign = array[i] == '-' ? -1 : 1;
        	i++;
        }
        
        int digit = 0;
        while(i < len && '0' <= array[i] && array[i] <= '9') {
        	digit = array[i] - '0';
        	if(value > Integer.MAX_VALUE/10 || (value == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10))
        		return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        	value = value*10 + digit;
        	i++;
        }
        
        return sign * value;
    }
}
