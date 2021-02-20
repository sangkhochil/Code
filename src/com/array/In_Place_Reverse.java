package com.array;

public class In_Place_Reverse {
	void problem(){
		int []arr = {2,3,5,6,7,8,9,12,45,50,89,99};
		int n = 12;
		for(int i=0, j=n-1; i<j; i++,j--){
			arr[i] = arr[i] + arr[j];
			arr[j] = arr[i] - arr[j];
			arr[i] = arr[i] - arr[j];
		}
		for(int i=0; i<n; i++)
			System.out.print(arr[i] + " ");
	}
}
