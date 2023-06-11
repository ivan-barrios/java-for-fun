package prog3.grafos.parcialesPracticos.BancoItau;

public class Persona {
	private boolean jubilado;
	private String nombre;
	private String domicilio;

	public Persona(boolean esJubilado, String nombre, String domicilio) {
		super();
		this.jubilado = esJubilado;
		this.nombre = nombre;
		this.domicilio = domicilio;
	}

	public boolean isJubilado() {
		return jubilado;
	}

	public void setEsJubilado(boolean jubilado) {
		this.jubilado = jubilado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

}
