package figuras;

public class Circulo extends Figura {
	private double radio;
	
	public Circulo() {super();}
	public Circulo (double radio) {
		this.radio = radio;
	}
	public Circulo(double radio, String color, boolean relleno) {
		super(color, relleno);
		this.radio = radio;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	@Override
	public double getArea() {
		return radio * radio * Math.PI;
	}
	@Override
	public double getPerimetro() {
		return radio * Math.PI * 2;
	}
	@Override
	public String toString() {
		return super.toString() + " Radio: " + radio;
	}
	
}
