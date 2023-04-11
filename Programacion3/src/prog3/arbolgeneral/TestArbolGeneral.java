package prog3.arbolgeneral;

import prog3.listagenerica.*;

public class TestArbolGeneral {

	public static void main(String[] args) {
		ListaGenerica<ArbolGeneral<Integer>> l = new ListaGenericaEnlazada<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> a2 = new ArbolGeneral<Integer>(76);
		ArbolGeneral<Integer> a3 = new ArbolGeneral<Integer>(98);
		ArbolGeneral<Integer> a4 = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> a5 = new ArbolGeneral<Integer>(42);
		
		ListaGenerica<ArbolGeneral<Integer>> a6ChildList = new ListaGenericaEnlazada<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> a6Child1 = new ArbolGeneral<Integer>(125);
		ArbolGeneral<Integer> a6Child2 = new ArbolGeneral<Integer>(13);
		ArbolGeneral<Integer> a6Child3 = new ArbolGeneral<Integer>(77);
		ArbolGeneral<Integer> a6Child4 = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> a6Child5 = new ArbolGeneral<Integer>(51);
		ArbolGeneral<Integer> a6Child6 = new ArbolGeneral<Integer>(52);
		ArbolGeneral<Integer> a6Child7 = new ArbolGeneral<Integer>(11);
		ArbolGeneral<Integer> a6Child8 = new ArbolGeneral<Integer>(99);
		ArbolGeneral<Integer> a6Child9 = new ArbolGeneral<Integer>(98);
		ArbolGeneral<Integer> a6Child10 = new ArbolGeneral<Integer>(97);
		ArbolGeneral<Integer> a6Child11 = new ArbolGeneral<Integer>(96);
		ArbolGeneral<Integer> a6Child12 = new ArbolGeneral<Integer>(89);
		ArbolGeneral<Integer> a6Child13 = new ArbolGeneral<Integer>(22);
		
		a6ChildList.agregarFinal(a6Child1);
		a6ChildList.agregarFinal(a6Child2);
		a6ChildList.agregarFinal(a6Child3);
		a6ChildList.agregarFinal(a6Child4);
		a6ChildList.agregarFinal(a6Child5);
		a6ChildList.agregarFinal(a6Child6);
		a6ChildList.agregarFinal(a6Child7);
		a6ChildList.agregarFinal(a6Child8);
		a6ChildList.agregarFinal(a6Child9);
		a6ChildList.agregarFinal(a6Child10);
		a6ChildList.agregarFinal(a6Child11);
		a6ChildList.agregarFinal(a6Child12);
		a6ChildList.agregarFinal(a6Child13);
		
		ArbolGeneral<Integer> a6 = new ArbolGeneral<Integer>(3, a6ChildList);
		ArbolGeneral<Integer> a7 = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> a8 = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> a9 = new ArbolGeneral<Integer>(28);
		ArbolGeneral<Integer> a10 = new ArbolGeneral<Integer>(0);
		l.agregarFinal(a1);
		l.agregarFinal(a2);
		l.agregarFinal(a3);
		l.agregarFinal(a4);
		l.agregarFinal(a5);
		l.agregarFinal(a6);
		l.agregarFinal(a7);
		l.agregarFinal(a8);
		l.agregarFinal(a9);
		l.agregarFinal(a10);
		
		
		ArbolGeneral<Integer> arbol = new ArbolGeneral<Integer>(10, l);
		
		
		System.out.println(arbol.altura());
		
	}

}
