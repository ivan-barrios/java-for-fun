package prog3.grafos.utiles;

import prog3.listagenerica.*;

public class MejorViaje {
	ListaGenerica<String> camino;
	int maxPasajeros; // Mayor cantidad de gente que se puede llevar d una.

	public MejorViaje() {
		super();
		this.camino = new ListaGenericaEnlazada<String>();
		this.maxPasajeros = 0;
	}

	public MejorViaje(ListaGenerica<String> camino, int maxPasajeros) {
		super();
		this.camino = camino;
		this.maxPasajeros = maxPasajeros;
	}

	public ListaGenerica<String> getCamino() {
		return camino;
	}

	public void setCamino(ListaGenerica<String> camino) {
		this.camino = camino;
	}

	public int getMaxPasajeros() {
		return maxPasajeros;
	}

	public void setMaxPasajeros(int maxPasajeros) {
		this.maxPasajeros = maxPasajeros;
	}

}
