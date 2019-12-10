package Soluciones;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * 
 * @author a.pedraza && s.fajardot
 *
 */
public class ProblemaB {

	static class Tupla implements Comparable<Tupla>
	{ 
		int x;
		int a;
		int b;

		public Tupla(String data) 
		{ 
			String[] datos=data.split(" ");
			x=Integer.parseInt(datos[0]);
			a=Integer.parseInt(datos[1]);
			b=Integer.parseInt(datos[2]);
		}


		@Override
		public int compareTo(Tupla o) {
			int s=((Integer)a).compareTo(o.a);
			return s;
		} 

	} 


	public static void solucionB(Tupla[] valores) {

		if(valores.length<=1) {//El arreglo esta vacio o solo tiene un dato
			System.out.println(0);
			System.out.println("*");
			return;
		}
		//Ordenamiento del arreglo de tuplas
		sort(valores, 0, valores.length-1);

		int[] numero=new int[valores.length];
		int[] ruta=new int[valores.length];

		int n = valores.length; 
		int max = -1;
		int pMax = n;
		for (int i = n-1; i >= 0; i--) {
			numero[i]=1;
			ruta[i]=n;
			for (int j = i+1; j < n; j++) {
				if (numero[i] <= numero[j] && valores[i].b>=valores[j].b) { 
					numero[i]=numero[j]+1;
					ruta[i]=j;
				} 
				else if(numero[i]==numero[j]+1 && valores[j].x<ruta[i]) {
					ruta[i]=j;
				}
			}
			if(max<numero[i]) {
				max=numero[i];
				pMax=i;
			}
		}

		if(max==1) {
			System.out.println(0);
			System.out.println("*");
			return;
		}
		System.out.println(max);
		boolean fin=false;
		String respuesta="";
		while(!fin) {
			respuesta+=valores[pMax].x+" ";
			pMax=ruta[pMax];
			fin=pMax==n;
		}
		System.out.println(respuesta);

	}

	public static void merge(Tupla arr[], int l, int m, int r) //Se ordena por la segunda columna, valores A
	{ 
		// Find sizes of two subarrays to be merged 
		int n1 = m - l + 1; 
		int n2 = r - m; 

		/* Create temp arrays */
		Tupla L[] = new Tupla [n1]; 
		Tupla R[] = new Tupla [n2]; 

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i) 
			L[i] = arr[l + i]; //Valor a
		for (int j=0; j<n2; ++j) 
			R[j] = arr[m + 1+ j]; //Valor a


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays 
		int i = 0, j = 0; 

		// Initial index of merged subarry array 
		int k = l; 
		while (i < n1 && j < n2) 
		{ 
			if (L[i].compareTo(R[j]) <= 0) 
			{ 
				arr[k] = L[i]; 
				i++; 
			} 
			else
			{ 
				arr[k] = R[j]; 
				j++; 
			} 
			k++; 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < n1) 
		{ 
			arr[k] = L[i]; 
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2) 
		{ 
			arr[k] = R[j]; 
			j++; 
			k++; 
		} 
	} 

	// Main function that sorts arr[l..r] using 
	// merge() 
	public static void sort(Tupla arr[], int l, int r) 
	{ 
		if (l < r) 
		{ 
			// Find the middle point 
			int m = (l+r)/2; 

			// Sort first and second halves 
			sort(arr, l, m); 
			sort(arr , m+1, r); 

			// Merge the sorted halves 
			merge(arr, l, m, r); 
		} 
	} 


	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Entrada");
		boolean h=false;
		ArrayList<Tupla[]> datos=new ArrayList<Tupla[]>();
		while(!h) {
			int n=Integer.parseInt(sc.nextLine());
			if(n==0) {
				h=true;
			}
			else {
				Tupla[] act=new Tupla[n];
				for (int i=0;i<n;i++) {
					act[i]=new Tupla(sc.nextLine());
				}
				datos.add(act);
			}


		}
		sc.close();

		System.out.println();
		System.out.println("Salida");
		for(int i=0; i<datos.size();i++) {
			solucionB(datos.get(i));

		}
	}
}
