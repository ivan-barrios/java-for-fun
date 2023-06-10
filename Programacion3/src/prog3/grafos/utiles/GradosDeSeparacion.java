package prog3.grafos.utiles;

import prog3.grafos.*;
import prog3.listagenerica.*;
import prog3.util.*;

public class GradosDeSeparacion {
	public int maximoGradoDeSeparacion(Grafo<String> grafo) {
		int gradoMax = -99;
		if (!grafo.esVacio() && grafo != null) {
			ListaGenerica<Vertice<String>> listaVertices = grafo.listaDeVertices();
			listaVertices.comenzar();
			while (!listaVertices.fin()) {
				boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
				Vertice<String> vAct = listaVertices.proximo();
				if (!visitados[vAct.posicion()]) {
					int grado = bfsMGS(grafo, visitados, vAct);
					if (grado > gradoMax)
						gradoMax = grado;
				}
			}
		}

		return gradoMax;
	}

	private int bfsMGS(Grafo<String> grafo, boolean[] visitados, Vertice<String> vIni) {
		int grado = 0;
		Cola<Vertice<String>> cola = new Cola<Vertice<String>>();
		cola.encolar(vIni);
		cola.encolar(null); // Encolo null para saber cuando termine de procesar una separacion
		visitados[vIni.posicion()] = true;
		while (!cola.esVacia()) {
			Vertice<String> vAct = cola.desencolar();
			if (vAct != null) {
				ListaGenerica<Arista<String>> lAdy = grafo.listaDeAdyacentes(vAct);
				lAdy.comenzar();
				while (!lAdy.fin()) {
					Vertice<String> vSig = lAdy.proximo().verticeDestino();
					if (!visitados[vSig.posicion()]) {
						visitados[vSig.posicion()] = true;
						cola.encolar(vSig);
					}
				}
			} else {
				if (!cola.esVacia()) {
					grado++;
					cola.encolar(null); //Termine de procesar una red
				}
			}

		}
		return grado;
	}

}
