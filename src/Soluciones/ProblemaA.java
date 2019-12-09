package Soluciones;

public class ProblemaA {


	static int longestSubArr(int[] arr, int N) { 

		int dp[][] = new int[N + 1][N + 1]; 

		int res_length = 0; 

		int i, index = 0; 
		for (i = 1; i <= N; i++) { 
			for (int j = i + 1; j <= N; j++) { 

				if (arr[(i - 1)] == arr[(j - 1)] 
						&& dp[i - 1][j - 1] < (j - i)) { 
					dp[i][j] = dp[i - 1][j - 1] + 1; 


					if (dp[i][j] > res_length) { 
						res_length = dp[i][j]; 
						index = Math.max(i, index); 
					} 
				} else { 
					dp[i][j] = 0; 
				} 
			} 
		} 

		return res_length; 
	} 




	public static void main(String[] args) {


		int[] arrT = {
				0,1,2,1,4,1,2,1,0,5
		};

		int N = arrT.length; 

		System.out.println(longestSubArr(arrT, N));

	}
}
