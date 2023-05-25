package figuras;

public class TestDeFigurasGeometricas {
	public static void main(String[] args) {
		Figura[] arregloFiguras = new Figura[3];
		
		arregloFiguras[0] = new Circulo(3, "verde", true);
		arregloFiguras[1] = new Rectangulo(3, 4, "rojo", false);
		arregloFiguras[2] = new Cuadrado(2, "violeta", true);
		
		for (Figura i : arregloFiguras) {
			System.out.println(i.toString());
		}
	}
}
