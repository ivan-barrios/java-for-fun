package prog3.grafos.parcialesPracticos.parcial2Drive;

import prog3.grafos.*;
import prog3.listagenerica.*;

public class Parcial {

	public ListaGenerica<String> resolver(Grafo<String> ciudades, String origen, String destino,
			ListaGenerica<String> pasandoPor) {
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		if (!ciudades.esVacio() && ciudades != null) {
			Vertice<String> vInicio = null;
			Vertice<String> vFinal = null;
			boolean[] visitados = new boolean[ciudades.listaDeVertices().tamanio()];
			ListaGenerica<String> caminoAct = new ListaGenericaEnlazada<String>();
			ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
			vertices.comenzar();
			while (!vertices.fin()) {
				Vertice<String> vAux = vertices.proximo();
				if (vAux.dato().equals(origen))
					vInicio = vAux;
				if (vAux.dato().equals(destino))
					vFinal = vAux;
			}
			if (vInicio != null && vFinal != null) {
				dfs(ciudades, visitados, camino, caminoAct, vInicio, vFinal, pasandoPor);
			}
		}
		return camino;
	}

	private void dfs(Grafo<String> ciudades, boolean[] visitados, ListaGenerica<String> camino,
			ListaGenerica<String> caminoAct, Vertice<String> vInicio, Vertice<String> vFinal,
			ListaGenerica<String> pasandoPor) {
		visitados[vInicio.posicion()] = true;
		caminoAct.agregarFinal(vInicio.dato());
		if (vInicio == vFinal)
			copiarLista(caminoAct, camino);
		else {
			ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(vInicio);
			ady.comenzar();
			while (!ady.fin()) {
				Vertice<String> vAux = ady.proximo().verticeDestino();
				if (!visitados[vAux.posicion()] && pasandoPor.incluye(vAux.dato())) {
					dfs(ciudades, visitados, camino, caminoAct, vAux, vFinal, pasandoPor);
				}
			}
		}
	}

	private void copiarLista(ListaGenerica<String> caminoAct, ListaGenerica<String> camino) {
		while (!camino.esVacia())
			camino.eliminarEn(0);
		caminoAct.comenzar();
		while (!caminoAct.fin()) {
			camino.agregarFinal(caminoAct.proximo());
		}
	}
}
