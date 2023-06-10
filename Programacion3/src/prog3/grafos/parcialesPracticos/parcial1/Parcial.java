package prog3.grafos.parcialesPracticos.parcial1;

import prog3.grafos.*;
import prog3.listagenerica.*;

public class Parcial {
	public int resolver(Grafo<Ciudad> ciudades, String origen, String destino, int maxControles) {
		Vertice<Ciudad> vInicial = null;
		Vertice<Ciudad> vFinal = null;
		boolean[] visitados = new boolean[ciudades.listaDeVertices().tamanio()];
		MaxTT max = new MaxTT(0);
		if (!ciudades.esVacio() && ciudades != null) {
			ListaGenerica<Vertice<Ciudad>> vertices = ciudades.listaDeVertices();
			vertices.comenzar();
			while (!vertices.fin()) {
				Vertice<Ciudad> vAux = vertices.proximo();
				if (vAux.dato().getNombre().equals(origen))
					vInicial = vAux;
				if (vAux.dato().getNombre().equals(destino))
					vFinal = vAux;
			}

			if (vInicial != null && vFinal != null)
				dfs(ciudades, vInicial, vFinal, visitados, maxControles, max, vInicial.dato().getLimiteDias());
		}
		return max.getMax();
	}

	private void dfs(Grafo<Ciudad> ciudades, Vertice<Ciudad> vAct, Vertice<Ciudad> vFinal, boolean[] visitados,
			int maxControles, MaxTT max, int dias) {
		visitados[vAct.posicion()] = true;
		if (vAct == vFinal) {
			if (max.getMax() < dias) {
				max.setMax(dias);
			}
		} else {
			ListaGenerica<Arista<Ciudad>> adyacentes = ciudades.listaDeAdyacentes(vAct);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				Arista<Ciudad> arista = adyacentes.proximo();
				Vertice<Ciudad> vAux = arista.verticeDestino();
				if (!visitados[vAux.posicion()] && (arista.peso() <= maxControles)) {
					dfs(ciudades, vAux, vFinal, visitados, maxControles, max, dias + vAux.dato().getLimiteDias());
				}
			}
		}
		visitados[vAct.posicion()] = false;
	}

}
