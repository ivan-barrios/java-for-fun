package prog3.listaenteros;

public class ListaDeEnterosEnlazadaTestBasico {

	public static void main(String[] args) {
		ListaDeEnteros lista = new ListaDeEnterosEnlazada();
		lista.agregarFinal(5);
		lista.agregarFinal(9);
		lista.agregarFinal(2);
		lista.agregarFinal(6);
		imprimirReves(lista);
		
	}
	
	public static void imprimirReves(ListaDeEnteros lista) {
		lista.comenzar();
		imprimirInverso(lista);
	}

	public static void imprimirInverso(ListaDeEnteros lista) {
		while(!lista.fin()) {
			int aux = lista.proximo();
			imprimirInverso(lista);
			System.out.println(aux);
		}
	}
	
	
}
