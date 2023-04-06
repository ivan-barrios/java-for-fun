package prog3.util;
import prog3.listagenerica.*;

public class Cola<T> {
	
	ListaGenericaEnlazada<T> cola;
	
	public Cola() {
		ListaGenericaEnlazada<T> lista = new ListaGenericaEnlazada<T>();
		this.cola = lista;
	}
	
	public void encolar(T elem) {
		this.cola.agregarInicio(elem);
	}
	
	public T desencolar() {
		T dato = this.cola.elemento(this.cola.tamanio() - 1);
		this.cola.eliminarEn(this.cola.tamanio() - 1);
		return dato;
	}
	
	public T tope() {
		return this.cola.elemento(0);
	}
	
	public boolean esVacia() {
		return this.cola.esVacia();
	}
	
}
