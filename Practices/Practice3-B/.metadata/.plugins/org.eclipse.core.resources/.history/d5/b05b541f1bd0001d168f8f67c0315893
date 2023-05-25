package prog3.util;
import prog3.listagenerica.*;

public class Pila<T> {
	ListaGenericaEnlazada<T> datos;
	
	public Pila() {
		ListaGenericaEnlazada<T> lista = new ListaGenericaEnlazada<T>();
		this.datos = lista;
	}
	
	public void apilar(T elem) {
		this.datos.agregarInicio(elem);
	}
	
	public T desapilar() {
		T dato = this.datos.elemento(0);
		this.datos.eliminarEn(0);
		return dato;
	}
	
	public T tope() {
		return this.datos.elemento(0);
	}
	
	public boolean esVacia() {
		return this.datos.esVacia();
	}
}
