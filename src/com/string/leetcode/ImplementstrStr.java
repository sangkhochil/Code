package com.string.leetcode;

public class ImplementstrStr {

	public static void main(String[] args) {
		//System.out.println(new ImplementstrStr().strStr("ababbbbaaabbbaaa","bbbb"));
		System.out.println(new ImplementstrStr().strStr("mississippi","issip"));
	}
	
	public int strStr(String haystack, String needle) {
		int ret = -1;
		if(haystack.isEmpty() && needle.isEmpty()) return 0;
		if(needle.isEmpty()) return 0;
		
		char[] text = haystack.toCharArray();
		char[] pattern = needle.toCharArray();
		
		int lps[] = new int[needle.length()];
		lps[0] = 0;
		int index = 0;
		int i = 1;
		while(i < needle.length()) {
			
			if(pattern[index] == pattern[i]) {
				lps[i] = index + 1;
				index++; i++;				
			} else {
				if(index != 0) {
					index = lps[index - 1];
				}
				else {
					lps[i] = 0; 
					i++;
				}
			}			
		}
		
		i = 0; 
		int j = 0;
		while(i < haystack.length() && j < needle.length()) {
			if(text[i] == pattern[j]) {
				ret = i - j;
				i++;
				j++;
			} else {
				if(j != 0) {
					j = lps[j-1];
				} else {
					i++;
				}
			}
		}
		if(j != needle.length())
			ret = -1;
		
		return ret;
	}
}
