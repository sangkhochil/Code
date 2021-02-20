package com.array;

public class PlusOne {

	public static void main(String[] args) {
		new Solution1().plusOne(new int[]{9,9});
	}

}
class Solution1 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int ret[] = new int[len + 1];
        int digit = 1;
        int remind = 0;
        for(int i = len - 1; i >= 0; i--) {
            digit += digits[i] + remind;
            ret[i+1] = digit % 10;
            remind = digit / 10;
            digit = 0;
        }
        if(remind == 1){
            ret[0] = remind;
            return ret;
        }
        int []tmp = new int[len];
        for(int i = 1; i <= len; i++)
            tmp[i-1] = ret[i];
        
        return tmp;
    }
}