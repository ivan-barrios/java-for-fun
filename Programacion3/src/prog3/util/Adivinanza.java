package prog3.util;

import prog3.arbol.ArbolBinario;
import prog3.listagenerica.*;

public class Adivinanza {

	public static void main(String[] args) {

		ArbolBinario<String> arbolBinarioA;
		arbolBinarioA = new ArbolBinario<String>("¿Tiene cuatro patas?");
		ArbolBinario<String> hijoIzquierdo = new ArbolBinario<String>("¿Se mueve?"); // hijo izq de la raiz
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<String>("¿Ladra?")); // hijo izq de "SE MUEVE"

		ArbolBinario<String> nodoLadra = hijoIzquierdo.getHijoIzquierdo(); // asigno el ladra a un nodo accesible
		nodoLadra.agregarHijoIzquierdo(new ArbolBinario<String>("ES UN PERRO")); // le creo un hijo izquierdo en la
																					// misma linea que lo agrego
		nodoLadra.agregarHijoDerecho(new ArbolBinario<String>("ES UN GATOO"));

		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<String>("ES UNA MESA"));
		// creo el hijo derecho
		ArbolBinario<String> hijoDerecho = new ArbolBinario<String>("¿Tiene alguna pata?");
		hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<String>("HOOOOLAAAA"));
		hijoDerecho.agregarHijoDerecho(new ArbolBinario<String>("CHAU"));
		// los agrego a la raiz
		arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdo);
		arbolBinarioA.agregarHijoDerecho(hijoDerecho);
		
		ListaGenericaEnlazada<String> l = new ListaGenericaEnlazada<String>();
		l = secuenciaConMasPreguntas(arbolBinarioA);
		System.out.println(l.toString());

	}

	public static ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> a) {

		ListaGenericaEnlazada<String> l = new ListaGenericaEnlazada<String>();
		ListaGenericaEnlazada<String> listaIzq = new ListaGenericaEnlazada<String>();
		ListaGenericaEnlazada<String> listaDer = new ListaGenericaEnlazada<String>();

		if (a == null)
			return l;
		else {
			listaIzq = secuenciaConMasPreguntas(a.getHijoIzquierdo());
			listaDer = secuenciaConMasPreguntas(a.getHijoDerecho());

			if (listaIzq.tamanio() > listaDer.tamanio()) {
				listaIzq.agregarInicio(a.getDato());
				return listaIzq;
			} else if (listaDer.tamanio() > listaIzq.tamanio()) {
				listaDer.agregarInicio(a.getDato());
				return listaDer;
			} else {
				// Retorno alguna de las dos
				listaIzq.agregarInicio(a.getDato());
				return listaIzq;
			}
		}
	}
	
	
	
	public static ListaGenericaEnlazada<String>[] secuenciaConMasPreguntasV2(ArbolBinario<String> a) {

		ListaGenericaEnlazada<String> [] l = new ListaGenericaEnlazada[2];
		ListaGenericaEnlazada<String> listaIzq = new ListaGenericaEnlazada<String>();
		ListaGenericaEnlazada<String> listaDer = new ListaGenericaEnlazada<String>();

		if (a == null)
			return l;
		else {
			listaIzq = secuenciaConMasPreguntas(a.getHijoIzquierdo());
			listaDer = secuenciaConMasPreguntas(a.getHijoDerecho());

			if (listaIzq.tamanio() > listaDer.tamanio()) {
				listaIzq.agregarInicio(a.getDato());
				return listaIzq;
			} else if (listaDer.tamanio() > listaIzq.tamanio()) {
				listaDer.agregarInicio(a.getDato());
				return listaDer;
			} else {
				// Retorno alguna de las dos
				listaIzq.agregarInicio(a.getDato());
				return listaIzq;
			}
		}
	}
	
	
	
}
