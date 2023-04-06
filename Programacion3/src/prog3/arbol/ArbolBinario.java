package prog3.arbol;

import prog3.listagenerica.*;
import prog3.util.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	
	//Hecho mirando el powerpoint
	public boolean esLleno() {
		//Inicializo todo para poder entrar al while
		ArbolBinario<T> arbol = null;  //Arbol que va a ir metiendo subarboles a la cola
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();  //La cola
		boolean lleno = true;  //Variable para verificar si es lleno o no
		cola.encolar(this);    //Encolo Raiz
		int cantNodos = 0;	   //Cantidad de nodos en nivel
		cola.encolar(null);    //Porque es el primer nivel, ya no hay mas elementos
		int nivel = 0;
		while (!cola.esVacia() && lleno) {
			arbol = cola.desencolar();    //Ararro subarbol
			if (arbol != null) {
				if (!arbol.getHijoIzquierdo().esVacio()) {  //Me aseguro de que 
					cola.encolar(arbol.getHijoIzquierdo()); //el hijo no es hoja
					cantNodos++;							
				}								        
				if (!arbol.getHijoDerecho().esVacio()) {	
					cola.encolar(arbol.getHijoDerecho());
					cantNodos++;
				}
			} else if (!cola.esVacia()) {             //No le falta ningun hijo?
				if (cantNodos == Math.pow(2, ++nivel)) {  //Hasta ahora es lleno?
					cola.encolar(null);
					cantNodos = 0;   //Reinicio variable
				}
				else lleno = false;
			}
			return lleno;	
		}
	}

	 boolean esCompleto() {
		return false;
		//Logica para solucion: Podemos crear una listaEnlazada, agregando
		//cada hoja del arbol, y luego preguntar si alguno de los nodos en
		//posiciones impares es null (Algun hijo izquierdo vacio) y ahi fijarnos
		//si los siguientes nodos son null. Para que sea completo, estos
		//ultimos nodos, deben ser null. En caso contrario, el árbol no es completo
	}

	
	// imprime el arbol en preorden  
	public void printPreorden() {
		System.out.println(this.dato);
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPreorden();
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPreorden();
		}
	}

	// imprime el arbol en postorden
	public void printInorden() {
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printInorden();
		}
		System.out.println(this.dato);
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printInorden();
		}
	}
	
	// imprime el arbol en postorden
	public void printPostorden() {
		if(this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPostorden();
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPostorden();
		}
		System.out.println(this.dato);
	}


	public void recorridoPorNiveles() {
		
	}

	

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaGenericaEnlazada<T>();
		this.fronteraRecursive(l);
		return l;
	}
	public void fronteraRecursive(ListaGenerica<T> l){
		if (!(this.tieneHijoIzquierdo() && this.tieneHijoDerecho())) {
			l.agregarFinal(this.dato);
		}
		if (this.tieneHijoIzquierdo()) {
			this.fronteraRecursive(l);
		}
		if (this.tieneHijoDerecho()) {
			this.fronteraRecursive(l);
		}
	}

	
	
	
	public int contarHojas() {
		int contador = 0;
		contador = this.contarHojasRecursivo();
		return contador;
	}
	private int contarHojasRecursivo() {
		int contador = 0;
		if (!(this.tieneHijoIzquierdo() && this.tieneHijoDerecho())) {
			return 1;
		}
		
		if (this.tieneHijoIzquierdo()) {
			contador = this.getHijoIzquierdo().contarHojasRecursivo();
		}
		if (this.tieneHijoDerecho()) {
			contador += this.getHijoDerecho().contarHojasRecursivo();
		}
		return contador;
	}

	

}
