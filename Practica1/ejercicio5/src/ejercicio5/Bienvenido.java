package ejercicio5;

import java.util.Scanner;

public class Bienvenido {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa tu nombre y apellido");
		String nombre = sc.nextLine();
		System.out.println("Hola " + nombre + "!");

	}
}
