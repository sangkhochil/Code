package com.string.leetcode;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		
	}
	public int firstUniqChar(String s) {
        int check[] = new int[26];
        for (char c : s.toCharArray()) {
			int index = c - 'a';
			check[index]++;
		}
        int i = 0;
        for (char c : s.toCharArray()) {
        	int index = c - 'a';
        	
        	if(check[index] == 1)
        		return i;
        	i++;
        }
        return -1;
    }
}
