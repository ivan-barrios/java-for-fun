package prog3.grafos.ej6;

import prog3.grafos.*;
import prog3.listagenerica.*;

public class Mapa {
	Grafo<String> mapaCiudades;

	public Mapa(Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}

	/*---------------------------- DEVOLVER CAMINO---------------------------- */
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		// Hago mi vector de marcas para saber si ya visite o no un vertice
		boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()];
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		ListaGenerica<String> lista = new ListaGenericaEnlazada<String>();
		ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();
		boolean okCiudad1 = false;
		int i = -1; // Posicion de ciudad1
		while (!listaVertices.fin() && !okCiudad1) { // Mientras no encuentre ciudad1 y no se termine la lista
			Vertice<String> v = listaVertices.proximo();
			if (v.dato() == ciudad1) {
				okCiudad1 = true;
				i = v.posicion();
				lista.agregarFinal(v.dato()); // Agrego como primer dato de lista ciudad1
			}
		}
		// Encontre ciudad1? --> Recorro para encontrar ciudad2 (Camino)
		if (i != -1) {
			devolverCamino(i, marca, lista, camino, ciudad2);
		}
		return camino;
	}

	private void devolverCamino(int i, boolean[] marca, ListaGenerica<String> lista, ListaGenerica<String> camino,
			String ciudad2) {
		marca[i] = true; // Pongo la marca en el vector
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i); // Agarro vertice actual
		if (v.dato() == ciudad2) {
			clonarLista(lista, camino);
		}
		if (camino.esVacia()) {
			ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(v); // Agarro los adyacentes
																								// a mi vertice actual
			adyacentes.comenzar(); // Para recorrerlo
			while (!adyacentes.fin() && camino.esVacia()) {
				Vertice<String> destino = adyacentes.proximo().verticeDestino(); // Esto me soluciona el problema de
																					// avanzar dos veces
				int j = destino.posicion();
				if (!marca[j]) {
					lista.agregarFinal(destino.dato()); // Agrego el dato
					devolverCamino(j, marca, lista, camino, ciudad2);
					// Si existe camino, en este punto ya va a estar copiado en camino, entonces
					// puedo borrar
					// Esto borra toda la lista cuando haga backtracking.
					lista.eliminarEn(lista.tamanio());
				}
			}
		}
	}
	/*---------------------------- DEVOLVER CAMINO---------------------------- */

	/*---------------------------- DEVOLVER CAMINO EXCEPTUANDO---------------------------- */
	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,
			ListaGenerica<String> ciudades) {
		// Hago mi vector de marcas para saber si ya visite o no un vertice
		boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()];
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		ListaGenerica<String> lista = new ListaGenericaEnlazada<String>();
		ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();
		boolean okCiudad1 = false;
		int i = -1; // Posicion de ciudad1
		listaVertices.comenzar();
		while (!(listaVertices.fin()) && !(okCiudad1)) { // Mientras no encuentre ciudad1 y no se termine la lista
			Vertice<String> v = listaVertices.proximo();
			if (v.dato() == ciudad1) {
				okCiudad1 = true;
				i = v.posicion();
				lista.agregarFinal(v.dato()); // Agrego como primer dato de lista ciudad1
			}
		}
		// Encontre ciudad1? --> Recorro para encontrar ciudad2 (Camino)
		if (okCiudad1) {
			devolverCaminoExceptuando(i, marca, lista, camino, ciudad2, ciudades);
		}
		return camino;
	}

	private void devolverCaminoExceptuando(int i, boolean[] marca, ListaGenerica<String> lista,
			ListaGenerica<String> camino, String ciudad2, ListaGenerica<String> ciudades) {
		marca[i] = true; // Pongo la marca en el vector
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i); // Agarro vertice actual
		if (v.dato() == ciudad2) {
			clonarLista(lista, camino);
		}
		if (camino.esVacia()) {
			ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(v); // Agarro los adyacentes
																								// a mi vertice actual
			adyacentes.comenzar(); // Para recorrerlo
			while (!adyacentes.fin() && camino.esVacia()) {
				Vertice<String> destino = adyacentes.proximo().verticeDestino();
				int j = destino.posicion();
				if (!marca[j] && (!ciudades.incluye(destino.dato()))) {
					lista.agregarFinal(destino.dato()); // Agrego el dato
					devolverCaminoExceptuando(j, marca, lista, camino, ciudad2, ciudades);
					// Si existe camino, en este punto ya va a estar copiado en camino, entonces
					// puedo borrar
					// Esto borra toda la lista cuando haga backtracking. Sino, busca camino
					// alternativo
					lista.eliminarEn(lista.tamanio());
				}
			}
		}
	}
	/*---------------------------- DEVOLVER CAMINO EXCEPTUANDO---------------------------- */

	/*---------------------------- DEVOLVER CAMINO MINIMO---------------------------- */
	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
		// Hago mi vector de marcas para saber si ya visite o no un vertice
		boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()];
		ListaGenerica<String> lista = new ListaGenericaEnlazada<String>();
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		MinimaDistancia min = new MinimaDistancia(99999); // Objeto que contiene minimo
		ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();
		listaVertices.comenzar();
		boolean okCiudad1 = false;
		int i = -1; // Posicion de ciudad1
		while (!listaVertices.fin() && !okCiudad1) { // Mientras no encuentre ciudad1 y no se termine la lista
			Vertice<String> v = listaVertices.proximo();
			if (v.dato().equals(ciudad1)) {
				okCiudad1 = true;
				i = v.posicion();
			}
		}
		// Encontre ciudad1? --> Recorro para encontrar ciudad2 (Camino)
		if (i != -1) {
			caminoMasCorto(i, marca, lista, camino, ciudad2);
		}
		return camino;
	}

	private void caminoMasCorto(int i, boolean[] marca, ListaGenerica<String> lista, ListaGenerica<String> camino,
			String ciudad2) {
		marca[i] = true; // Pongo la marca en el vector
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i); // Agarro vertice actual
		lista.agregarFinal(v.dato());
		if (v.dato().equals(ciudad2)) {
			if ((lista.tamanio() < camino.tamanio()) || camino.tamanio() == 0) {
				clonarLista(lista, camino);
			}
		} else {
			ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(v); // Agarro los adyacentes
																								// a mi vertice actual
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				int j = adyacentes.proximo().verticeDestino().posicion();
				if (!marca[j]) {
					caminoMasCorto(j, marca, lista, camino, ciudad2);
					lista.eliminarEn(lista.tamanio() - 1);
					marca[j] = false; // Desmarco porque puede haber un camino mas corto que pase por aca
				}
			}
		}
	}
	/*---------------------------- DEVOLVER CAMINO MINIMO---------------------------- */

	/*---------------------------- DEVOLVER CAMINO SIN CARGAR---------------------------- */
	// Supongo que tengo la cantidad de nafta en el peso del arista, no?
	public ListaGenerica<String> caminoSinCargar(String ciudad1, String ciudad2, int tanqueAuto) {
		boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()];
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		ListaGenerica<String> lista = new ListaGenericaEnlazada<String>();
		ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();
		listaVertices.comenzar();
		boolean okCiudad1 = false;
		int i = -1; // Posicion de ciudad1
		while (!listaVertices.fin() && !okCiudad1) { // Mientras no encuentre ciudad1 y no se termine la lista
			Vertice<String> v = listaVertices.proximo();
			if (v.dato().equals(ciudad1)) {
				okCiudad1 = true;
				i = v.posicion();
			}
		}
		// Encontre ciudad1? --> Recorro para encontrar ciudad2 (Camino)
		if (i != -1) {
			caminoSinCargar(i, marca, lista, camino, ciudad2, tanqueAuto);
		}
		return camino;
	}

	private void caminoSinCargar(int i, boolean[] marca, ListaGenerica<String> lista, ListaGenerica<String> camino,
			String ciudad2, int tanqueAuto) {
		marca[i] = true; // Pongo la marca en el vector
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i); // Agarro vertice actual
		lista.agregarFinal(v.dato());
		if (v.dato().equals(ciudad2)) {
			System.out.println("das");
			if (tanqueAuto > 0) {
				clonarLista(lista, camino);
			}
		}
		else {
			ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(v);
			adyacentes.comenzar(); // Para recorrerlo
			while (!adyacentes.fin()) {
				Arista<String> arista = adyacentes.proximo();
				int j = arista.verticeDestino().posicion();
				if (!marca[j]) {
					if ((tanqueAuto - arista.peso()) > 0) {
						// Si agrego en esta linea o agrego al principio de la funcion es lo mismo no?
						caminoSinCargar(j, marca, lista, camino, ciudad2, tanqueAuto - arista.peso());
						lista.eliminarEn(lista.tamanio() - 1);
						marca[i] = false;
					}
				}
			}
		}
	}
	/*---------------------------- DEVOLVER CAMINO SIN CARGAR---------------------------- */

	/*---------------------------- DEVOLVER CAMINO CON MENOR CARGA---------------------------- */
	public ListaGenerica<String> caminoMenorCarga(String ciudad1, String ciudad2, int tanqueAuto) {
		Integer min = 99999; // HACER OBJETO
		boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaGenerica<String> lista = new ListaGenericaEnlazada<String>();
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		if (tanqueAuto != 0) {
			ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
			listaVertices.comenzar();
			Vertice<String> v;
			boolean ok = false;
			int i = -1;
			while ((!listaVertices.fin()) && (!ok)) {
				v = listaVertices.proximo();
				if (v.dato() == ciudad1) {
					ok = true;
					i = v.posicion();
					lista.agregarFinal(v.dato());
				}
			}
			if (i != -1) {
				int carga = tanqueAuto;
				int cantParadas = 0;
				caminoMenorCarga(i, lista, camino, marca, ciudad2, tanqueAuto, carga, cantParadas, min);
			}
		}
		return camino;

	}

	private void caminoMenorCarga(int i, ListaGenerica<String> lista, ListaGenerica<String> camino, boolean[] marca,
			String ciudad2, int tanqueAuto, int carga, int cantParadas, Integer min) {
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		if (v.dato() == ciudad2) {
			if (cantParadas < min) {
				clonarLista(lista, camino);
				min = cantParadas;
			}
		} else {
			marca[i] = true;
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().posicion();
				if (!marca[j]) {
					boolean cargo = false;
					if (tanqueAuto < arista.peso()) { // Cargo si es necesario
						cargo = true;
						tanqueAuto += carga - tanqueAuto;
						cantParadas++;
					}
					tanqueAuto -= arista.peso();
					if (tanqueAuto >= 0) {
						lista.agregarFinal(arista.verticeDestino().dato());
						caminoMenorCarga(j, lista, camino, marca, ciudad2, tanqueAuto, carga, cantParadas, min);
						lista.eliminarEn(lista.tamanio());
					}
					tanqueAuto += arista.peso();
					if (cargo) { // Si cargó y ya procesó, descargo lo que cargó para seguir mirando otros
									// caminos
						tanqueAuto -= arista.peso();
						cantParadas--;
					}
				}
			}
		}

	}
	/*---------------------------- DEVOLVER CAMINO CON MENOR CARGA---------------------------- */

	private void clonarLista(ListaGenerica<String> lis, ListaGenerica<String> camino) {
		while (!camino.esVacia())
			camino.eliminarEn(0);
		lis.comenzar();
		while (!lis.fin())
			camino.agregarFinal(lis.proximo());
	}

}
