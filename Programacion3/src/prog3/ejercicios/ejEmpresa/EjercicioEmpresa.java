package prog3.ejercicios.ejEmpresa;

import prog3.arbolgeneral.ArbolGeneral;
import prog3.listagenerica.ListaGenerica;
import prog3.util.*;

public class EjercicioEmpresa {
	private ArbolGeneral<Empleado> empleados;
	
	int empleadosPorCategoria(int categoria){
		this.empleados.getHijos().tamanio();
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		ArbolGeneral<Empleado> arbolAux;
		cola.encolar(this.empleados);
		cola.encolar(null);
		int cant = 0;
		int nivel = 0;
		while(!cola.esVacia()) {
			arbolAux = cola.desencolar();
			if (arbolAux != null) {
				if (nivel == categoria) {
					cant++;                  //Cuenta la cantidad de Empleados en nivel
				}
				if (arbolAux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Empleado>> hijos = arbolAux.getHijos();
					hijos.comenzar();
					while(!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			}
			
			else {
				if (!cola.esVacia()) {
					nivel++;
					cola.encolar(null);
				}
			}
		}
		return cant;
	}
	
	int categoriaConMasEmpleados() {
		
	}
	
	int cantidadTotalDeEmpleados() {
		
	}
}
