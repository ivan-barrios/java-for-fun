package prog3.util;

import prog3.arbol.ArbolBinario;
import prog3.listagenerica.*;

public class Utiles {

	public static void main(String[] args) {
		ArbolBinario<Integer> arbolito = new ArbolBinario<Integer>(7);

		// Hijos izq
		ArbolBinario<Integer> arbolitoIzq1 = new ArbolBinario<Integer>(1);
		arbolito.agregarHijoIzquierdo(arbolitoIzq1);
		ArbolBinario<Integer> arbolitoIzq2 = new ArbolBinario<Integer>(4);
		arbolitoIzq1.agregarHijoIzquierdo(arbolitoIzq2);

		// Hijos der
		ArbolBinario<Integer> arbolitoDer1 = new ArbolBinario<Integer>(3);
		arbolito.agregarHijoDerecho(arbolitoDer1);
		ArbolBinario<Integer> arbolitoDer2 = new ArbolBinario<Integer>(2);
		arbolitoDer1.agregarHijoIzquierdo(arbolitoDer2);
		ArbolBinario<Integer> arbolitoDer3 = new ArbolBinario<Integer>(1);
		arbolitoDer1.agregarHijoDerecho(arbolitoDer3);

		System.out.println(sumaMaximaHorizontal(arbolito));

	}

	public static int sumaMaximaVertical(ArbolBinario<Integer> arbol) {
		if (arbol == null)
			return 0;
		else {
			int sumaIzq = sumaMaximaVertical(arbol.getHijoIzquierdo());
			int sumaDer = sumaMaximaVertical(arbol.getHijoDerecho());
			if (sumaDer > sumaIzq) {
				return sumaDer + arbol.getDato();
			} else {
				return sumaIzq + arbol.getDato();
			}
		}

	}

	public static int sumaMaximaHorizontal(ArbolBinario<Integer> arbol) {
		int sumaMax = 0;
		int sumaNivel = 0;
		ArbolBinario<Integer> a = new ArbolBinario<Integer>();
		Cola<ArbolBinario<Integer>> cola = new Cola<ArbolBinario<Integer>>();
		cola.encolar(arbol);
		cola.encolar(null); // Termina primer nivel
		while (!cola.esVacia()) {
			a = cola.desencolar();
			if (a != null) {
				sumaNivel += a.getDato();
				if (a.tieneHijoIzquierdo()) {
					cola.encolar(a.getHijoIzquierdo());
				}
				if (a.tieneHijoDerecho()) {
					cola.encolar(a.getHijoDerecho());
				}
			} else if (!cola.esVacia()) {
				if (sumaNivel > sumaMax) {
					sumaMax = sumaNivel;
				}
				cola.encolar(null); //Termina nivel
				sumaNivel = 0; //RESET
			}
		}
		if (sumaNivel > sumaMax) sumaMax = sumaNivel;
		return sumaMax;
	}
	
	
	public static ListaGenericaEnlazada<Integer> trayectoriaPesada(ArbolBinario<Integer> a) {
		
	}
	
	
	
	
}
