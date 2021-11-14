package array.spiral.print;

public class Main {

	public static void main(String[] args) {
		int r = 3;
        int c = 6;
        int arr[][] = { { 1, 2, 3, 4, 5, 6 },
                      { 7, 8, 9, 10, 11, 12 },
                      { 13, 14, 15, 16, 17, 18 } };
		new SpiralPrint().solution(r, c, arr);
	}
}

class SpiralPrint {
	void solution(int m, int n, int[][] arr) {
		int r = 0, c = 0, i = 0;

		while (r < m && c < n) {

			for (i = c; i < n; i++) {
				System.out.print(arr[r][i] + " ");
			}
			r++;

			for (i = r; i < m; i++) {
				System.out.print(arr[i][n - 1] + " ");
			}
			n--;

			if (r < m) {
				for (i = n - 1; i >= c; i--) {
					System.out.print(arr[m - 1][i] + " ");
				}
				m--;
			}
			if (c < n) {
				for (i = m - 1; i >= r; i--) {
					System.out.print(arr[i][c] + " ");
				}
				c++;
			}

		}
	}
}
