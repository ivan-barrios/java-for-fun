package prog3.grafos.utiles;

import prog3.grafos.*;
import prog3.listagenerica.*;

public class GuiaDeTurismo {
	public ListaGenerica<String> caminoConMenorNrodeViajes(Grafo<String> grafo, String origen, String destino) {
		Vertice<String> vInicio = null;
		Vertice<String> vFinal = null;
		boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
		MejorViaje camino = new MejorViaje();
		if (grafo != null && !grafo.esVacio()) {
			ListaGenerica<Vertice<String>> listaVertices = grafo.listaDeVertices();
			listaVertices.comenzar();
			while (!listaVertices.fin()) {
				Vertice<String> vAux = listaVertices.proximo();
				if (vAux.dato().equals(origen)) {
					vInicio = vAux;
				}
				if (vAux.dato().equals(destino)) {
					vFinal = vAux;
				}
			}
			ListaGenerica<String> caminoActual = new ListaGenericaEnlazada<String>();
			if (vInicio != null && vFinal != null) {
				int maxPasajeros = 99999999;
				dfsCaminoConMenorNrodeViajes(grafo, vInicio, vFinal, caminoActual, visitados, camino, maxPasajeros,
						99999999);
			}
		}
		System.out.println("Maximo: " + camino.getMaxPasajeros());
		return camino.getCamino();
	}

	private void dfsCaminoConMenorNrodeViajes(Grafo<String> grafo, Vertice<String> vAct, Vertice<String> vDestino,
			ListaGenerica<String> caminoActual, boolean[] visitados, MejorViaje camino, int maxPasajeros,
			int pesoArista) {
		caminoActual.agregarFinal(vAct.dato());
		visitados[vAct.posicion()] = true;
		if (pesoArista < maxPasajeros) { // Actualizo la maxima cantidad de pasajeros
			maxPasajeros = pesoArista;
		}
		if (vAct == vDestino) {
			if (camino.getMaxPasajeros() < maxPasajeros) {
				ListaGenerica<String> l = new ListaGenericaEnlazada<String>();
				copiarLista(l, caminoActual);
				camino.setCamino(l);
				camino.setMaxPasajeros(maxPasajeros);
			}
		} else {
			ListaGenerica<Arista<String>> lAdy = grafo.listaDeAdyacentes(vAct);
			lAdy.comenzar();
			while (!lAdy.fin()) {
				Arista<String> arista = lAdy.proximo();
				Vertice<String> vAux = arista.verticeDestino();
				if (!visitados[vAux.posicion()]) {
					dfsCaminoConMenorNrodeViajes(grafo, vAux, vDestino, caminoActual, visitados, camino, maxPasajeros,
							arista.peso());
				}
			}
		}
		visitados[vAct.posicion()] = false;
		caminoActual.eliminarEn(caminoActual.tamanio() - 1);
	}

	// Revisar copiar lista
	private void copiarLista(ListaGenerica<String> camino, ListaGenerica<String> caminoActual) {
		caminoActual.comenzar();
		while (!caminoActual.fin()) {
			camino.agregarFinal(caminoActual.proximo());
		}
	}

}
