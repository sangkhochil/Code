package leetcode.string;

public class ReverseString {

	public static void main(String[] args) {
		new ReverseString().reverseString("hello".toCharArray());
	}
	public void reverseString(char[] s) {
        int len = s.length;
        for(int i=0, j=len-1; i<j; i++, j--) {
            char a = s[i];
            s[i] = s[j];
            s[j] = a;
        }            
    }
}
