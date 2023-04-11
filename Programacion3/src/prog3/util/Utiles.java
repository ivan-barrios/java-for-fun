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

		ListaGenericaEnlazada<Integer> l = new ListaGenericaEnlazada<Integer>();
		l = trayectoriaPesada(arbolito);
		System.out.println(l.toString());

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
			} else {

				if (sumaNivel > sumaMax) {
					sumaMax = sumaNivel;
				}
				sumaNivel = 0; // RESET
				if (!cola.esVacia()) {
					cola.encolar(null); // Termina nivel
				}
			}
		}

		return sumaMax;
	}

	private static ListaGenericaEnlazada<Integer> trayectoriaPesada(ArbolBinario<Integer> arbol) {
		ListaGenericaEnlazada<Integer> l = new ListaGenericaEnlazada<Integer>(); // declaro variable y la inicializo
		int suma = 0;
		int nivel = 0;
		trayectoriaPesadaRecursivo(arbol, l, suma, nivel);
		return l;
	}

	private static void trayectoriaPesadaRecursivo(ArbolBinario<Integer> arbol, ListaGenericaEnlazada<Integer> l,
			int suma, int nivel) {

		// necesito recorrer hasta que encuentre una hoja (nodo que no tiene ningun
		// hijo)
		if (arbol == null) {
			return; // que vuelva
		} else {
			if (arbol.esHoja()) {
				suma += (arbol.getDato() * nivel); // sumo el ultimo elemento * nivel

				l.agregarFinal(suma); // agrego el valor de la suma de los nodos a la lista

			} else {
				// es un hijo
				suma += (arbol.getDato() * nivel); // sumo el dato con el nivel en el que estoy
				nivel++; // cada vez que sumo un elemento estoy en un nivel mas ya que sumo
							// verticalemnete
				trayectoriaPesadaRecursivo(arbol.getHijoIzquierdo(), l, suma, nivel);
				trayectoriaPesadaRecursivo(arbol.getHijoDerecho(), l, suma, nivel);

			}
		}

	}
}
