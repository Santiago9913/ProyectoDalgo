

import java.util.ArrayList;
import java.util.Scanner;



/**
 * 
 * @author a.pedraza && s.fajardot
 *
 */
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


		Scanner sc=new Scanner(System.in);
		System.out.println("Entrada");
		boolean h=false;
		int[] datos;
		ArrayList<Integer> tamaños=new ArrayList<>();
		ArrayList<int[]> numeros=new ArrayList<int[]>();
		while(!h) {
			int n=Integer.parseInt(sc.nextLine());
			if(n==0) {
				h=true;
			}
			else {
				datos=new int[n];
				String[] data=sc.nextLine().split(" ");

				for (int i = 0; i < n; i++) {
					datos[i]=Integer.parseInt(data[i]);
				}
				tamaños.add(n);
				numeros.add(datos);
			}
		}
		sc.close();

		System.out.println();
		System.out.println("Salida");
		for(int i=0; i<tamaños.size();i++) {
			if(numeros.get(i).length!=tamaños.get(i)) {
				System.out.println("No esta el numero de datos solicitado");
			}
			else {
				System.out.println(longestSubArr(numeros.get(i), tamaños.get(i)));
			}
		}


	}
}
