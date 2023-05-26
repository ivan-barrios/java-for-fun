package prog3.grafos.utiles;

import prog3.listagenerica.*;
import prog3.grafos.*;
import prog3.util.*;

public class Recorridos<T> {

	public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo) {
		// Hago mi vector de marcas para saber si ya visite o no un vertice
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		ListaGenerica<Vertice<T>> lista = new ListaGenericaEnlazada<Vertice<T>>();
		for (int i = 0; i <= marca.length; i++) { // Aca me aseguro de que no va a quedar ninguno sin marcar
			if (!marca[i]) {
				this.dfs(i, grafo, marca, lista);
			}
		}
		return lista;
	}

	private void dfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<Vertice<T>> lista) {
		marca[i] = true; // Pongo la marca en el vector
		Vertice<T> v = grafo.listaDeVertices().elemento(i); // Agarro vertice actual
		lista.agregarFinal(v);
		ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(v); // Agarro los adyacentes a mi vertice actual
		adyacentes.comenzar(); // Para recorrerlo
		while (!adyacentes.fin()) {
			int j = adyacentes.proximo().verticeDestino().posicion();
			if (!marca[j]) {
				dfs(j, grafo, marca, lista);
			}
		}
	}

	public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo) {
		// Hago mi vector de marcas para saber si ya visite o no un vertice
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		ListaGenerica<Vertice<T>> lista = new ListaGenericaEnlazada<Vertice<T>>();
		for (int i = 0; i < marca.length; i++) {
			if (!marca[i])
				this.bfs(i, grafo, marca, lista);
		}
		return lista;
	}
	
	private void bfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<Vertice<T>> lista) {
		ListaGenerica<Arista<T>> ady = null; //Lista de adyacentes
		Cola<Vertice<T>> q = new Cola<Vertice<T>>(); //Cola de vertices para recorrido
		q.encolar(grafo.listaDeVertices().elemento(i)); //Encolo el actual
		marca[i] = true; //Marco como visitado
		while (!q.esVacia()) {
			Vertice<T> v = q.desencolar(); //Desencolo vertice
			lista.agregarFinal(v); //Se procesa
			ady = grafo.listaDeAdyacentes(v); //Agarro sus adyacentes
			ady.comenzar();
			while(!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.verticeDestino().posicion();
				if(!marca[j]) {
					Vertice<T> w = arista.verticeDestino();
					marca[j] = true;
					q.encolar(w);
				}
			}
		}
		
	}

}
