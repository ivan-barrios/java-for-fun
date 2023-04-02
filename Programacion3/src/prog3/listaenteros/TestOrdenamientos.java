package prog3.listaenteros;

public class TestOrdenamientos {

	public static void main(String[] args) {
		ListaDeEnterosEnlazada lista1 = new ListaDeEnterosEnlazada();
		lista1.agregarFinal(1);
		lista1.agregarFinal(3);
		lista1.agregarFinal(5);
		lista1.agregarFinal(7);
		lista1.agregarFinal(9);
		ListaDeEnterosEnlazada lista2 = new ListaDeEnterosEnlazada();
		lista2.agregarFinal(0);
		lista2.agregarFinal(2);
		lista2.agregarFinal(4);
		lista2.agregarFinal(6);
		lista2.agregarFinal(8);
		lista2.agregarFinal(10);
		lista2.agregarFinal(12);
		lista2.agregarFinal(14);
		ListaDeEnterosEnlazada ordenada = lista1.combinarOrdenado(lista2);
		System.out.println(ordenada.toString());
	}

}
