package prog3.grafos.parcialesPracticos.parcial1Drive;

import prog3.grafos.*;
import prog3.listagenerica.*;

public class Parcial {

	public ListaGenerica<Ciudad> resolver(Grafo<Ciudad> ciudades, String origen, String destino) {
		Vertice<Ciudad> vInicio = null;
		Vertice<Ciudad> vFinal = null;
		boolean[] visitados = new boolean[ciudades.listaDeVertices().tamanio()];
		ListaGenerica<Ciudad> camino = new ListaGenericaEnlazada<Ciudad>();
		if (ciudades != null && !ciudades.esVacio()) {
			ListaGenerica<Vertice<Ciudad>> vertices = ciudades.listaDeVertices();
			vertices.comenzar();
			while (!vertices.fin()) {
				Vertice<Ciudad> vAux = vertices.proximo();
				if (vAux.dato().getNombre().equals(origen))
					vInicio = vAux;
				if (vAux.dato().getNombre().equals(destino))
					vFinal = vAux;
			}
			if (vInicio != null && vFinal != null) {
				ListaGenerica<Ciudad> caminoActual = new ListaGenericaEnlazada<Ciudad>();
				dfs(ciudades, visitados, vInicio, vFinal, caminoActual, camino);
			}
		}
		return camino;
	}

	private void dfs(Grafo<Ciudad> ciudades, boolean[] visitados, Vertice<Ciudad> vAct, Vertice<Ciudad> vFinal,
			ListaGenerica<Ciudad> caminoAct, ListaGenerica<Ciudad> camino) {
		visitados[vAct.posicion()] = true;
		caminoAct.agregarFinal(vAct.dato());
		if (vAct == vFinal)
			copiarLista(caminoAct, camino);
		else {
			ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(vAct);
			ady.comenzar();
			while (!ady.fin()) {
				Vertice<Ciudad> vAux = ady.proximo().verticeDestino();
				if (vAux.dato().getFase() != 1 && !visitados[vAux.posicion()]) {
					dfs(ciudades, visitados, vAux, vFinal, caminoAct, camino);
				}
			}
		}
		caminoAct.eliminarEn(caminoAct.tamanio() - 1);
		visitados[vAct.posicion()] = false;
	}

	private void copiarLista(ListaGenerica<Ciudad> cAct, ListaGenerica<Ciudad> c) {
		while (!c.esVacia())
			c.eliminarEn(0);
		cAct.comenzar();
		while (!cAct.fin())
			c.agregarFinal(cAct.proximo());
	}

}
