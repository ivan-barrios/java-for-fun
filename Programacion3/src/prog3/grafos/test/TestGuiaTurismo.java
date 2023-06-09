package prog3.grafos.test;

import prog3.grafos.*;
import prog3.grafos.utiles.*;
import prog3.listagenerica.*;

public class TestGuiaTurismo {

	public static void main(String[] args) {
		Vertice<String> v1 = new VerticeImplListAdy<String>("1");
		Vertice<String> v2 = new VerticeImplListAdy<String>("2");
		Vertice<String> v3 = new VerticeImplListAdy<String>("3");
		Vertice<String> v4 = new VerticeImplListAdy<String>("4");
		Vertice<String> v5 = new VerticeImplListAdy<String>("5");
		Vertice<String> v6 = new VerticeImplListAdy<String>("6");
		Vertice<String> v7 = new VerticeImplListAdy<String>("7");

		Grafo<String> grafo = new GrafoImplListAdy<String>();
		grafo.agregarVertice(v1);
		grafo.agregarVertice(v2);
		grafo.agregarVertice(v3);
		grafo.agregarVertice(v4);
		grafo.agregarVertice(v5);
		grafo.agregarVertice(v6);
		grafo.agregarVertice(v7);

		grafo.conectar(v1, v2, 30);
		grafo.conectar(v2, v1, 30);

		grafo.conectar(v1, v3, 15);
		grafo.conectar(v3, v1, 15);

		grafo.conectar(v1, v4, 10);
		grafo.conectar(v4, v1, 10);

		grafo.conectar(v2, v4, 25);
		grafo.conectar(v4, v2, 25);

		grafo.conectar(v2, v5, 60);
		grafo.conectar(v5, v2, 60);

		grafo.conectar(v4, v3, 40);
		grafo.conectar(v3, v4, 40);

		grafo.conectar(v4, v7, 35);
		grafo.conectar(v7, v4, 35);

		grafo.conectar(v3, v6, 20);
		grafo.conectar(v6, v3, 20);

		grafo.conectar(v5, v7, 20);
		grafo.conectar(v7, v5, 20);

		grafo.conectar(v6, v7, 30);
		grafo.conectar(v7, v6, 30);

		GuiaDeTurismo guia = new GuiaDeTurismo();
		System.out.println("Camino: ");

		ListaGenerica<String> l = new ListaGenericaEnlazada<String>();

		l = guia.caminoConMenorNrodeViajes(grafo, "1", "7");

		while (!l.fin()) {
			System.out.println(l.proximo());
		}

	}

}
