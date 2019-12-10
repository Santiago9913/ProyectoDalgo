import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author a.pedraza && s.fajardot
 *
 */
public class ProblemaC {

	public static void solucionC(int[] puntos, int[] figura) {

		if(figura.length!=2*puntos[1]) {
			System.out.println("La figura no tiene el numero de puntos indicado");
			return;
		}
		int xp=puntos[2];
		int yp=puntos[3];

		int x1=figura[0];
		int y1=figura[1];

		int x2=figura[2];
		int y2=figura[3];

		int c=0;
		double pDif=-1;
		int n=2*puntos[1];
		boolean borde=false;
		boolean empezoHorizontal=false;

		for(int i=0; i<n;i+=2) {
			if(x1>puntos[0] || (x2>puntos[0])) {
				System.out.println("Los puntos de la figura se salen del dominio");
				return;
			}
			if(!borde) {
				if((xp==x1 && yp==y1)||(xp==x2 && yp==y2) ) {
					borde=true;
					x1=figura[(i+4)%n];
					y1=figura[(i+5)%n];
					x2=figura[(i+6)%n];
					y2=figura[(i+7)%n];
					i+=2;//Porque se avanza el doble
				}
				else if((x1<xp && x2<xp)||(y1<yp && y2<yp)||(yp<y1 && yp<y2)||(x1>x2&&xp==x1&&yp!=y1)||(x1<x2&&xp==x2&&yp!=y2)) {//Es imposible que interseque. Se avanza en 1 (punto)
					x1=figura[(i+2)%n];//Actual punto x2
					y1=figura[(i+3)%n];//Actual putno y2
					x2=figura[(i+4)%n];
					y2=figura[(i+5)%n];
				}
				else {
					if(((x2>x1 && xp==x1)||(x2<x1 && xp==x2)) && (yp!=y1 && yp!=y2)) {
						c++;
						x1=figura[(i+2)%n];//Actual punto x2
						y1=figura[(i+3)%n];//Actual putno y2
						x2=figura[(i+4)%n];
						y2=figura[(i+5)%n];
					}
					else {
						double a=x2>x1?(double)(y2-y1)/(double)(x2-x1):(double)(y1-y2)/(double)(x1-x2);
						double b=x2>x1?(double)(yp-y1)/(double)(xp-x1):(double)(yp-y2)/(double)(xp-x2);
						pDif=(a<0&&b<0)?Math.abs(a)-Math.abs(b):a-b;//La diferencia entre las pendientes
						if(pDif==0) {//Esta en la frontera
							if(y1==yp && y2==yp) {//Solo se da si la primera recta es una horizontal y no se debe contar el ultimo valor. 
								if((figura[n-1]>y1 && figura[(i+5)%n]<y1)||(figura[n-1]<y1 && figura[(i+5)%n]>y1)) {
									c++;
								}
								x1=figura[(i+4)%n];
								y1=figura[(i+5)%n];
								x2=figura[(i+6)%n];
								y2=figura[(i+7)%n];
								i+=2;
								empezoHorizontal=true;
							}
							else { 
								borde=true;
								x1=figura[(i+4)%n];
								y1=figura[(i+5)%n];
								x2=figura[(i+6)%n];
								y2=figura[(i+7)%n];
							}

						}
						else if(pDif<0 || (a>0 && b<0) ||(a<0&&b>0)||b==0) {
							if(y2==yp) {//Esquina o linea horizontal
								if(y2==figura[(i+5)%n]) { //Linea horizontal. Se avanza en 3
									if((y1>y2 && figura[(i+7)%n]<y2)||(y1<y2 && figura[(i+7)%n]>y2)) {
										c++;
									}
									x1=figura[(i+6)%n];
									y1=figura[(i+7)%n];
									x2=figura[(i+8)%n];
									y2=figura[(i+9)%n];
									i+=4;
								}
								else if((y2<figura[(i+5)%n] && y2<y1)||(y2>figura[(i+5)%n] && y2>y1)) {//La esquina se abre hacia arriba o hacia abajo. Se avanza en 2
									x1=figura[(i+4)%n];
									y1=figura[(i+5)%n];
									x2=figura[(i+6)%n];
									y2=figura[(i+7)%n];
									i+=2;
								}
								else{//la esquina se abre hacia izquierda o derecha. Se avanza en 2
									x1=figura[(i+4)%n];
									y1=figura[(i+5)%n];
									x2=figura[(i+6)%n];
									y2=figura[(i+7)%n];
									c++;
									i+=2;
								}
							}
							else {
								if(i==0) {//Empieza por esquina
									if((y1>y2 && y1<figura[n-1])||(y1<y2 && y1>figura[n-1])) {//abre horizontalmente
										c++;//Interseca la recta
										x1=figura[(i+2)%n];//Actual punto x2
										y1=figura[(i+3)%n];//Actual putno y2
										x2=figura[(i+4)%n];
										y2=figura[(i+5)%n];
										empezoHorizontal=true;
									}
									else {
										x1=figura[(i+2)%n];//Actual punto x2
										y1=figura[(i+3)%n];//Actual putno y2
										x2=figura[(i+4)%n];
										y2=figura[(i+5)%n];
									}
								}
								else {
									c++;//Interseca la recta
									x1=figura[(i+2)%n];//Actual punto x2
									y1=figura[(i+3)%n];//Actual putno y2
									x2=figura[(i+4)%n];
									y2=figura[(i+5)%n];
								}
							}
						}
					}
				}
			}
			else {//Avanzan el doble porque solo tiene que verificar que esten en el dominio
				x1=figura[(i+4)%n];
				y1=figura[(i+5)%n];
				x2=figura[(i+6)%n];
				y2=figura[(i+7)%n];
				i+=2;
			}
		}
		if(empezoHorizontal) {//Ya se tuvo que haber contado el caso pero se volvio a contar al final del ciclo
			c--;
		}
		if(borde) {
			System.out.println(0);
		}
		else if(c%2==0) {
			System.out.println(-1);
		}
		else {
			System.out.println(1);
		}

	}



	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Entrada");
		boolean h=false;
		ArrayList<int[]> datos=new ArrayList<int[]>();
		while(!h) {
			String[] p=sc.nextLine().split(" ");
			int[] q=new int[p.length];
			boolean last=true;
			for (int i = 0; i < p.length; i++) {
				int v=Integer.parseInt(p[i]);	
				last=v==0 && last;
				q[i]=v;
			}
			h=last && q.length==4;
			datos.add(q);
		}

		if(datos.size()%2==0) {
			System.out.println("No se termino bien la secuencia con un numero par de entradas mas la linea que no se procesa");
		}
		else {
			System.out.println();
			System.out.println("Salida");
			int i=0;
			while(i<datos.size()-1) {
				solucionC(datos.get(i), datos.get(i+1));
				i+=2;
			}
		}

	}

}