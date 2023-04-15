package prog3.ejercicios.ejEmpresa;

import prog3.arbolgeneral.ArbolGeneral;
import prog3.listagenerica.ListaGenerica;
import prog3.util.*;

public class Empresa {
	private ArbolGeneral<Empleado> empleados;
	
	//PREGUNTAR: Cada nivel representa una categoria?

	public Integer empleadosPorCategoria(int categoria) {
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		ArbolGeneral<Empleado> arbolAux;
		cola.encolar(this.empleados);
		cola.encolar(null);
		int cant = 0;
		while (!cola.esVacia()) {
			arbolAux = cola.desencolar();
			if (arbolAux != null) {
				if (arbolAux.getDato().getCategoria() == categoria) {
					cant++; // Cuenta la cantidad de Empleados de la categoria
				}
				if (arbolAux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Empleado>> hijos = arbolAux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			} else {
				if (!cola.esVacia()) {
					cola.encolar(null);   //Deberia estar arriba?
				}
			}
		}
		return cant;
	}

	//Por nivel o fijandome la categoria?
	public Integer categoriaConMasEmpleados() {
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		ArbolGeneral<Empleado> aux;
		cola.encolar(this.empleados);
		cola.encolar(null);
		int catMax = 0, nivel = 0, cant = 0, cantMax = 0;
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Empleado>> hijos = aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
					cola.encolar(null);
				}
				cant++;
			} else if (!cola.esVacia()) {
				if (cantMax < cant) {
					cantMax = cant;
					catMax = nivel;
				}
				nivel++;
				cant = 0;
				cola.encolar(null);
			}
		}
		return catMax;
	}

	public Integer cantidadTotalDeEmpleados() {
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		ArbolGeneral<Empleado> aux;
		cola.encolar(this.empleados);
		cola.encolar(null);
		int cant = 0;
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				cant++;
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Empleado>> hijos = aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
					cola.encolar(null);
				}
			}
		}
		return cant;
	}
	
	//Hay alguna forma de hacerlo recursivo??
	public void reemplazarPresidente() {
		//COMO HAGO ESTO
		
	}
	
}
