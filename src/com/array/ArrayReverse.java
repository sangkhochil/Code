package com.array;
public class ArrayReverse {
	private void reverse(int[] arr, int low, int high) {
		for (int i = low, j = high; i < j; i++, j--) {
			arr[i] = arr[i] + arr[j];
			arr[j] = arr[i] - arr[j];
			arr[i] = arr[i] - arr[j];
		}
	}

	void leftRotate(int arr[], int d, int n) {
		d = d % n;
		int i, j, k, temp;
		int g_c_d = gcd(d, n);
		for (i = 0; i < g_c_d; i++) {
			temp = arr[i];
			j = i;
			while (true) {
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}

	int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public void problem(int arr[], int k) {
		int n = arr.length;
        k = k % n;
        
        reverse(arr, n - k, n - 1);
        reverse(arr, 0, n - k - 1);
        reverse(arr, 0, n - 1);
	}

	public static void main(String[] args) {
		ArrayReverse rotate = new ArrayReverse();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
//		rotate.problem(arr, 3);
		rotate.leftRotate(arr, 3, arr.length);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}