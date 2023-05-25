package src;


public class Tablet extends Mobile {
	private int pulgadas;
	

	public Tablet() {
		super();
	}

	public int getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}
	
	public boolean equals(Object o) {
		boolean result = false;
		if ((o != null) && (o instanceof Tablet)) {
			Tablet t = (Tablet)o;
			if (t.getPulgadas() == this.getPulgadas()) result = true;
			System.out.println(t.getMarca());
		}
		
		return result;
	}
	
	public String toString() {
		return this.getMarca() +  " " + this.getSistemaOperativo() + " " + this.getCosto() + " " + super.getModelo() + " " + this.getPulgadas();
	}
	
	
}
