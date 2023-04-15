package prog3.ejercicios.ejRedAguaPotable;

import prog3.arbolgeneral.*;
import prog3.listagenerica.*;

public class RedDeAguaPotable {

	public static void main(String[] args) {
		ArbolGeneral<Double> a = new ArbolGeneral<Double>(1.0);

		//configuracion: 
		a.agregarHijo(new ArbolGeneral<Double>(2.0));
		a.agregarHijo(new ArbolGeneral<Double>(3.0));
		a.agregarHijo(new ArbolGeneral<Double>(4.0));
		a.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Double>(5.0));
		a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Double>(6.0));
		a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Double>(7.0));
		a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Double>(8.0));
		a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Double>(9.0));
		System.out.println("minCaudal: " + minCaudal(a, 2000));
	}

	public static double minCaudal(ArbolGeneral<Double> a, double n) {
		if (a.esHoja())
			return n;
		ListaGenerica<ArbolGeneral<Double>> l = a.getHijos();
		double min = Double.MAX_VALUE;
		l.comenzar();
		double aux = n / l.tamanio();
		while (!l.fin()) {
			double actual = minCaudal(l.proximo(), aux);
			if (actual < min)
				min = actual;
		}
		return min;
	}

}
