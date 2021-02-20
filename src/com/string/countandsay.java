package com.string;

public class countandsay {

	public static void main(String[] args) {
		System.out.println(new countandsay().countAndSay(4));
	}
	
	 public String countAndSay(int n) {
		 return Solution("11", 2, n);
	 }
	 
	 private String Solution(String str, int level, int n) {
		 if(n == 1) return "1";
		 if(n == level) return str;
		 char[] ch = str.toCharArray();
		 int len = ch.length;
		 int count = 1;
		 String ret = "";
		 int i , j;
		 for( i = 0, j = 1; j<len; ) {
			 if(ch[i] == ch[j]){
				 count++;
				 i++;
				 j++;
			 } else {
				 ret += String.valueOf(count) + String.valueOf(ch[i]);
				 count = 1;
				 i++; 
				 j++;
			 }
		 }
		 ret += String.valueOf(count) + String.valueOf(ch[i]);
		 return Solution(ret, level + 1, n);
	 }
}
