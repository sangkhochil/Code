package com.string;

public class ValidPalindrome {

	public static void main(String[] args) {
		new ValidPalindrome().isPalindrome("0P");
	}
	public boolean isPalindrome(String s) {
		if(s.isEmpty())
			return true;
		
		char[] array = s.toCharArray();
		int value1 = 0;
		int value2 = 0;
		int n = s.length();
		for(int i = 0, j = n - 1; i<j; i++, j--){
			while(i < n && !('a' <= array[i] && array[i] <= 'z') && !('A' <= array[i] && array[i] <= 'Z') && !('0' <= array[i] && array[i] <= '9'))
				i++;
			while(j >= 0 && !('a' <= array[j] && array[j] <= 'z') && !('A' <= array[j] && array[j] <= 'Z') && !('0' <= array[j] && array[j] <= '9'))
				j--;
			if(i==n && j<0) return true;
			
			if(('a' <= array[i] && array[i] <= 'z'))
				value1 = array[i] - 97;
			else
				value1 = array[i] - 65;
			
			if(('a' <= array[j] && array[j] <= 'z'))
				value2 = array[j] - 97;
			else
				value2 = array[j] - 65;
			
			if(value1 != value2)
				return false;
		}
		return true;
    }
}
