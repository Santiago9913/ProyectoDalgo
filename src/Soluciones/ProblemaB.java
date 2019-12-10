package Soluciones;

import java.util.ArrayList;

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
			return s==0?((Integer)b).compareTo(o.b):s;
		} 
	    
	} 
	  

	public static void solucionB(Tupla[] valores) {

		if(valores.length<=1) {//El arreglo esta vacio o solo tiene un dato
			System.out.println(0);
			System.out.println("*");
		}
		//Ordenamiento del arreglo de tuplas
		sort(valores, 0, valores.length-1);
		//Se agrega el ultimo valor a la solucion
		int i=valores.length-1;
		Tupla[] solucion=new Tupla[valores.length];
		solucion[i]=valores[i];
		int j=i;
		i--;
		
		while(i>=0) {
			if(valores[i].b>=solucion[j].b) {
				solucion[--j]=valores[i--];
			}
			else {
				if(valores.length-j==1) {//Solo hay un valor no nulo en el arreglo 
					if(valores[i].b<solucion[j].b) {//El valor de entrada es menor
						solucion[j]=valores[i];
					}
				}
				i--;
			}
		}
		if(valores.length-j==1) {
			System.out.println(0);
			System.out.println("*");
			return;
		}
		System.out.println(valores.length-j);//Candidad de valores en el contraejemplo
		String contraejemplo="";
		for (Tupla tupla : solucion) {
			if(tupla!=null) {
				contraejemplo+=tupla.x+" ";
			}
		}
		System.out.println(contraejemplo);
		

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
	private static Tupla tupla1=new Tupla("1 1 8");
	private static Tupla tupla2=new Tupla("2 2 9");
	private static Tupla tupla3=new Tupla("3 3 6");
	private static Tupla tupla4=new Tupla("4 4 7");
	private static Tupla tupla5=new Tupla("5 5 3");
	private static Tupla tupla6=new Tupla("6 6 2");
	private static Tupla tupla7=new Tupla("7 7 1");
	private static Tupla tupla8=new Tupla("8 8 5");
	private static Tupla tupla9=new Tupla("9 9 4");
	
	private static Tupla tupla10=new Tupla("1 100 50");
	private static Tupla tupla11=new Tupla("2 300 70");
	private static Tupla tupla12=new Tupla("3 200 60");

	
	private static Tupla tupla13=new Tupla("1 601 65");
	private static Tupla tupla14=new Tupla("2 600 105");
	private static Tupla tupla15=new Tupla("3 50 100");
	private static Tupla tupla16=new Tupla("4 100 200");
	
	public static void main(String[] args) {
		Tupla[] entrada= {tupla1,tupla2,tupla3,tupla4,tupla5,tupla6,tupla7,tupla8,tupla9};
		solucionB(entrada);
		Tupla[] entrada2= {tupla10,tupla11,tupla12};
		solucionB(entrada2);
		Tupla[] entrada3={tupla13,tupla14,tupla15,tupla16};
		solucionB(entrada3);
	}
}
