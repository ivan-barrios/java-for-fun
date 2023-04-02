package figuras;

public class Cuadrado extends Rectangulo {
	public Cuadrado() {super();}
	public Cuadrado(double lado) {
		super(lado, lado);
	}
	public Cuadrado(double lado, String color, boolean relleno) {
		super(lado, lado, color, relleno);
	}
	public double getLado() {
		return super.getLargo();
	}
	public void setLado(double lado) {
		super.setAncho(lado);
		super.setLargo(lado);
	}
	public void setAncho(double ancho) {
		super.setAncho(ancho);
	}
	public void setLargo(double largo) {
		super.setLargo(largo);
	}
	public String toString() {
		return super.toString();
	}
}
