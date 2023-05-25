package animales.prog3.info;

public class TestAnimal3 {
	public static void main(String[] args) {
		Gato gato1 = new Gato();
		gato1.saludo(); //Miau!
		Perro perro1 = new Perro();
		perro1.saludo(); //Guau!
		PerroGrande perroGrande1 = new PerroGrande();
		perroGrande1.saludo(); //Guauuuuu!
		Animal animal1 = new Gato();
		animal1.saludo(); //Miau!
		Animal animal2 = new Perro();
		animal2.saludo(); //Guau!
		Animal animal3 = new PerroGrande();
		animal3.saludo();  //Guauuuu!
		Perro perro2 = perro1;
		PerroGrande perroGrande2 = perroGrande1;
		Perro perro3 = perro1;
		Gato gato2 = gato1;
		perro2.saludo(perro3);
		perro3.saludo(perro2);
		perro2.saludo(perroGrande2);
		perroGrande2.saludo(perro2);
		perroGrande2.saludo(perroGrande1);
	}
}
