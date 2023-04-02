package prog3.util;
import prog3.listaenteros.*;

public class UtilitariosLista {

	public static void main(String[] args) {
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		lista.agregarFinal(4);
		lista.agregarFinal(2);
		lista.agregarFinal(0);
		lista.agregarFinal(89);
		lista.agregarFinal(53);
		lista.agregarFinal(23);
		lista.agregarFinal(10);
		ListaDeEnterosEnlazada newList= mergeSort(lista);
		System.out.println(newList.toString());
		
	}

	
	public static ListaDeEnterosEnlazada mergeSort(ListaDeEnterosEnlazada list) {
		if (list.tamanio() <= 1) {
			return list;
		}
		
		int mid = list.tamanio() / 2;
		
		ListaDeEnterosEnlazada izq = new ListaDeEnterosEnlazada();
		izq.comenzar();
		for (int i = 0; i < mid; i++) {
			izq.agregarFinal(list.elemento(i));
		}
		ListaDeEnterosEnlazada der = new ListaDeEnterosEnlazada();
		der.comenzar();
		for (int i = mid; i < list.tamanio(); i++) {
			der.agregarFinal(list.elemento(i));
		}
		
		ListaDeEnterosEnlazada left = mergeSort(izq);
		ListaDeEnterosEnlazada right = mergeSort(der);
		
		return left.combinarOrdenado(right);
		
	}
}