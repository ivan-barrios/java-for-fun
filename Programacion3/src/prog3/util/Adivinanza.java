package prog3.util;

import prog3.arbol.ArbolBinario;
import prog3.listagenerica.*;

public class Adivinanza {

	public static void main(String[] args) {

		ArbolBinario<String> arbolBinarioA;
		arbolBinarioA = new ArbolBinario<String>("¿Tiene cuatro patas?");
		
		//hijo izquierdo
		ArbolBinario<String> hijoIzquierdo = new ArbolBinario<String>("¿Se mueve?");
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<String>("¿Ladra?"));

		ArbolBinario<String> nodoLadra = hijoIzquierdo.getHijoIzquierdo(); 
		nodoLadra.agregarHijoIzquierdo(new ArbolBinario<String>("ES UN PERRO")); 
		nodoLadra.agregarHijoDerecho(new ArbolBinario<String>("ES UN GATOO"));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<String>("ES UNA MESA"));
		
		// creo el hijo derecho
		ArbolBinario<String> hijoDerecho = new ArbolBinario<String>("¿Tiene alguna pata?");
		hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<String>("JAJAJAJA?"));
		hijoDerecho.agregarHijoDerecho(new ArbolBinario<String>("Jujujju?"));
		
		ArbolBinario<String> pruebaDer = hijoDerecho.getHijoDerecho();
		pruebaDer.agregarHijoIzquierdo(new ArbolBinario<String>("FIIUUUU?")); 
		pruebaDer.agregarHijoDerecho(new ArbolBinario<String>("DERECHA?"));
		
		ArbolBinario<String> pruebaIzq = pruebaDer.getHijoIzquierdo();
		pruebaIzq.agregarHijoIzquierdo(new ArbolBinario<String>("FIOOOOOO"));
		
		// los agrego a la raiz
		arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdo);
		arbolBinarioA.agregarHijoDerecho(hijoDerecho);

		ListaGenericaEnlazada<String> l = new ListaGenericaEnlazada<String>();
		l = secuenciaConMasPreguntas(arbolBinarioA);
		System.out.println(l.toString());

	}

	public static ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> a) {
		if (a == null)
			return (new ListaGenericaEnlazada<String>());
		ListaGenericaEnlazada<String> listaIzq = new ListaGenericaEnlazada<String>();
		ListaGenericaEnlazada<String> listaDer = new ListaGenericaEnlazada<String>();

		listaIzq = secuenciaConMasPreguntas(a.getHijoIzquierdo());
		listaDer = secuenciaConMasPreguntas(a.getHijoDerecho());
		
		if (listaIzq.tamanio() > listaDer.tamanio()) {
			listaIzq.agregarInicio(a.getDato());
			if (!a.esHoja())
				listaIzq.agregarEn("SI", 1);
			return listaIzq;
		} else if (listaDer.tamanio() > listaIzq.tamanio()) {
			listaDer.agregarInicio(a.getDato());
			if (!a.esHoja())
				listaDer.agregarEn("NO", 1);
			return listaDer;
		} else {
			// Retorno alguna de las dos
			listaIzq.agregarInicio(a.getDato());
			if (!a.esHoja())
				listaIzq.agregarEn("SI", 1);
			return listaIzq;
		}
	}

	public static ListaGenericaEnlazada<String> secuenciaConMasPreguntasV2(ArbolBinario<String> a) {

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
				// Retorno las dos
				listaIzq.agregarInicio(a.getDato());
				listaIzq.agregarInicio(a.getDato());
				return listaIzq;
			}
		}
	}

}
