package com.array;

public class Remove_Duplicates {
	public void problem() {
		int[] arr = {0,0,1,1,1,2,2,3,3,4};
		int n = 10;
		int count = 1;
		int tmp = arr[0];
		for(int i = 1; i<n; i++) {
			if(tmp != arr[i]) {
				arr[count] = arr[i];
				count++;
			}
				
			tmp = arr[i];
		}
		for(int i=0; i<count; i++)
			System.out.print(arr[i] + " ");
		System.out.print(count);
	}
}
