package prog3.grafos.ej6;
import prog3.grafos.*;
import prog3.listagenerica.*;

public class Mapa {
	Grafo<String> mapaCiudades;
	
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		// Hago mi vector de marcas para saber si ya visite o no un vertice
		boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()];
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		ListaGenerica<String> lista = new ListaGenericaEnlazada<String>();
		ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();
		boolean okCiudad1 = false;
		int i = -1; //Posicion de ciudad1
		while (!listaVertices.fin() && !okCiudad1) { //Mientras no encuentre ciudad1 y no se termine la lista
			Vertice<String> v = listaVertices.proximo();
			if(v.dato() == ciudad1) {
				okCiudad1 = true;
				i = v.posicion();
				lista.agregarFinal(v.dato()); //Agrego como primer dato de lista ciudad1
			}
		}
		//Encontre ciudad1? --> Recorro para encontrar ciudad2 (Camino)
		if (i != -1) {
			devolverCamino(i, marca, lista, camino, ciudad2);
		}
		return camino;
	}
	private void devolverCamino(int i, boolean[] marca, ListaGenerica<String> lista, ListaGenerica<String> camino, String ciudad2) {
		marca[i] = true; // Pongo la marca en el vector
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i); // Agarro vertice actual
		if (v.dato() == ciudad2) {
			clonarLista(lista, camino);
		}
		if (camino.esVacia()) {
			ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(v); // Agarro los adyacentes a mi vertice actual
			adyacentes.comenzar(); // Para recorrerlo
			while (!adyacentes.fin() && camino.esVacia()) {
				int j = adyacentes.proximo().verticeDestino().posicion();
				if (!marca[j]) {
					lista.agregarFinal(adyacentes.proximo().verticeDestino().dato()); //Agrego el dato
					devolverCamino(j, marca, lista, camino, ciudad2);
					//Si existe camino, en este punto ya va a estar copiado en camino, entonces puedo borrar
					//Esto borra toda la lista cuando haga backtracking.
					lista.eliminarEn(lista.tamanio());
				}
			}
		}
	}
	
	
	
	
	ListaGenerica<String> devolverCaminoExceptuando (String ciudad1, String ciudad2,ListaGenerica<String> ciudades){
		//do
	}
	
	ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
		//do
	}
	
	ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		//do
	}
	
	ListaGenerica<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
		//do
	}
	
	
	private void clonarLista (ListaGenerica<String> lis,ListaGenerica<String> camino) {
		lis.comenzar();
		while(!lis.fin()) {
			camino.agregarFinal(lis.proximo());
		}
	}
	
}
