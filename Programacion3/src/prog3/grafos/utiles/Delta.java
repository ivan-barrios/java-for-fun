package prog3.grafos.utiles;

import prog3.grafos.*;
import prog3.listagenerica.*;

public class Delta {

	public Delta() {

	}

	public int maxIslasDistintas(Grafo<String> grafo) {
		int max = 0;
		if (!grafo.esVacio()) {
			boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
			Vertice<String> muellePrincipal = grafo.listaDeVertices().elemento(0);
			visitados[0] = true;
			// Agarro a los adyacentes del muelle principal
			ListaGenerica<Arista<String>> listaRamas = grafo.listaDeAdyacentes(muellePrincipal);
			listaRamas.comenzar();
			// Recorro todas las islas adyacentes a muelle principal
			// y voy actualizando por cada rama el maximo
			while (!listaRamas.fin()) {
				int num = 1;
				num += dfsMaxIslasDistintas(grafo, visitados, listaRamas.proximo().verticeDestino());
				if (num > max)
					max = num;
			}
		}
		return max;
	}

	public int dfsMaxIslasDistintas(Grafo<String> grafo, boolean[] visitados, Vertice<String> vActual) {
		int cant = 1;
		visitados[vActual.posicion()] = true;
		ListaGenerica<Arista<String>> listaAdy = grafo.listaDeAdyacentes(vActual);
		listaAdy.comenzar();
		while (!listaAdy.fin()) {
			Vertice<String> vAux = listaAdy.proximo().verticeDestino();
			if (!visitados[vAux.posicion()]) {
				cant += dfsMaxIslasDistintas(grafo, visitados, vAux);
			}
		}
		return cant;
	}

	public RutaMinima caminoMasCorto(Grafo<String> grafo, String islaO, String islaD) {
		RutaMinima ruta = new RutaMinima(true);
		int cantBoletos = 1;
		Vertice<String> vInicial = null;
		Vertice<String> vFinal = null;
		boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
		if ((grafo != null) && (!grafo.esVacio())) {
			ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
			vertices.comenzar();
			while (!vertices.fin()) {
				Vertice<String> vAux = vertices.proximo();
				if (vAux.dato().equals(islaO)) {
					vInicial = vAux;
					if (vInicial.dato().equals(vertices.elemento(0).dato()))
						cantBoletos = 0; // Si arranca en muelle principal lo pongo en 0
					// Porque suma uno apenas arranque.
				}
				if (vAux.dato().equals(islaD)) {
					vFinal = vAux;

				}
			}
			ListaGenerica<String> caminoActual = new ListaGenericaEnlazada<String>();
			if (vInicial != null && vFinal != null) {
				dfsCaminoMasCorto(grafo, visitados, vInicial, vFinal, ruta, caminoActual, cantBoletos, 0);
			}
		}
		return ruta;
	}

	private void dfsCaminoMasCorto(Grafo<String> grafo, boolean[] visitados, Vertice<String> vAct,
			Vertice<String> vFinal, RutaMinima ruta, ListaGenerica<String> caminoActual, int cantBoletos, int dist) {
		caminoActual.agregarFinal(vAct.dato());
		visitados[vAct.posicion()] = true;
		if (vAct.posicion() == 0) {
			cantBoletos++; // Sumo cada vez que este en muelle principal (Inicializado en 0 por si arranca
							// ahi)
			if (cantBoletos > 1) {
				ruta.setUnicoBoleto(false);
			}
		}
		if (vAct == vFinal) {
			if ((ruta.getCaminoMasCorto().esVacia()) || (ruta.getMetros() > dist)) {
				ListaGenerica<String> cpy = new ListaGenericaEnlazada<String>();
				copiarLista(caminoActual, cpy);
				ruta.setCaminoMasCorto(cpy);
				ruta.setMetros(dist);
			}
		} else {
			ListaGenerica<Arista<String>> listaAdy = grafo.listaDeAdyacentes(vAct);
			listaAdy.comenzar();
			while (!listaAdy.fin()) {
				Arista<String> arista = listaAdy.proximo();
				Vertice<String> vAux = arista.verticeDestino();
				if (!visitados[vAux.posicion()]) {
					dfsCaminoMasCorto(grafo, visitados, vAux, vFinal, ruta, caminoActual, cantBoletos,
							dist + arista.peso());
				}
			}
			caminoActual.eliminarEn(caminoActual.tamanio() - 1);
			visitados[vAct.posicion()] = false;
		}

	}

	private void copiarLista(ListaGenerica<String> caminoActual, ListaGenerica<String> camino) {
		while (!camino.esVacia())
			camino.eliminarEn(0);
		caminoActual.comenzar();
		while (!caminoActual.fin())
			camino.agregarFinal(caminoActual.proximo());
	}

}
