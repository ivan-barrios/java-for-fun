package prog3.listagenerica;

public class TestListaGenerica {

	public static void main(String[] args) {
		ListaGenericaEnlazada<Integer> lista = new ListaGenericaEnlazada<Integer>();
		lista.agregarFinal(1);
		lista.agregarFinal(2);
		lista.agregarFinal(3);
		lista.agregarFinal(4);
		lista.agregarFinal(5);
		System.out.println(lista.invertir());
	}

}
