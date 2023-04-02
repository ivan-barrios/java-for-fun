package figuras;

public class Rectangulo extends Figura {
	private double ancho;
	private double largo;
	public Rectangulo() {
		super();
	}
	public Rectangulo(double ancho, double largo) {
		super();
		this.ancho = ancho;
		this.largo = largo;
	}
	public Rectangulo(double ancho, double largo, String color, boolean relleno) {
		super(color, relleno);
		this.ancho = ancho;
		this.largo = largo;
	}
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	public double getLargo() {
		return largo;
	}
	public void setLargo(double largo) {
		this.largo = largo;
	}
	@Override
	public double getArea() {
		return ancho * largo;
	}
	@Override
	public double getPerimetro() {
		return ancho * 2 + largo * 2;
	}
	@Override
	public String toString() {
		return super.toString() + " Ancho: " + ancho + " Largo: " + largo;
	}
	
}
