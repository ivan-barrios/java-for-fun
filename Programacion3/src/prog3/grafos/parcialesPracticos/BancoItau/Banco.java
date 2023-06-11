package prog3.grafos.parcialesPracticos.BancoItau;

import prog3.grafos.*;
import prog3.listagenerica.*;
import prog3.util.*;

public class Banco {

	public ListaGenerica<Persona> jubiladosAEntregarSueldo(Grafo<Persona> grafo, Persona empleado, int distanciaMax) {
		ListaGenerica<Persona> listado = new ListaGenericaEnlazada<Persona>();
		if (!grafo.esVacio()) {
			Vertice<Persona> vInicial = null;
			ListaGenerica<Vertice<Persona>> vertices = grafo.listaDeVertices();
			vertices.comenzar();
			while (!vertices.fin()) {
				Vertice<Persona> vAux = vertices.proximo();
				if (vAux.dato().equals(empleado)) {
					vInicial = vAux;
				}
			}
			if (vInicial != null) {
				boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
				bfs(grafo, visitados, vInicial, listado, distanciaMax);
			}
		}
		return listado;
	}

	private void bfs(Grafo<Persona> grafo, boolean[] visitados, Vertice<Persona> vInicial,
			ListaGenerica<Persona> listado, int distanciaMax) {
		Cola<Vertice<Persona>> q = new Cola<Vertice<Persona>>();
		q.encolar(vInicial);
		q.encolar(null);
		visitados[vInicial.posicion()] = true;
		int distanciaAct = 0;
		while (!q.esVacia() && listado.tamanio() <= 40) {
			Vertice<Persona> vAct = q.desencolar();
			if (vAct != null) {
				if (vAct.dato().isJubilado() && distanciaAct <= distanciaMax) {
					listado.agregarFinal(vAct.dato());
				}
				ListaGenerica<Arista<Persona>> ady = grafo.listaDeAdyacentes(vAct);
				ady.comenzar();
				while (!ady.fin()) {
					Vertice<Persona> vSig = ady.proximo().verticeDestino();
					if (!visitados[vSig.posicion()]) {
						visitados[vSig.posicion()] = true;
						q.encolar(vSig);
					}
				}
			} else {
				if (!q.esVacia()) {
					q.encolar(null);
					distanciaAct++;
				}
			}
		}
	}
}
