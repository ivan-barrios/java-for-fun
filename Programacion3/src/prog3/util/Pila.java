package prog3.util;
import prog3.listagenerica.*;

public class Pila<T> {
	ListaGenericaEnlazada<T> datos;
	
	public Pila() {
		ListaGenericaEnlazada<T> lista = new ListaGenericaEnlazada<T>();
		this.datos = lista;
	}
	
	public void apilar(T elem) {
		this.datos.agregarFinal(elem);
	}
	
	public T desapilar() {
		T dato = this.datos.elemento(this.datos.tamanio());
		this.datos.eliminarEn(this.datos.tamanio() - 1);
		return dato;
	}
	
	public T tope() {
		return this.datos.elemento(this.datos.tamanio() - 1);
	}
	
	public boolean esVacia() {
		return this.datos.esVacia();
	}
}
