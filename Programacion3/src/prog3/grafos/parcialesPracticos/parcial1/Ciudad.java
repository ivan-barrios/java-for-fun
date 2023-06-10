package prog3.grafos.parcialesPracticos.parcial1;

public class Ciudad {
	private String nombre;
	private int limiteDias;
	
	public Ciudad (String nombre, int limiteDias) {
		this.nombre = nombre;
		this.limiteDias = limiteDias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLimiteDias() {
		return limiteDias;
	}

	public void setLimiteDias(int limiteDias) {
		this.limiteDias = limiteDias;
	}

}
