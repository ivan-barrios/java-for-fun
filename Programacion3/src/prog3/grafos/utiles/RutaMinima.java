package prog3.grafos.utiles;

import prog3.listagenerica.*;

public class RutaMinima {
	private ListaGenerica<String> caminoMasCorto;
	private boolean unicoBoleto;
	private int metros;

	public RutaMinima(boolean unicoBoleto) {
		super();
		ListaGenerica<String> caminoMasCorto = new ListaGenericaEnlazada<String>();
		this.caminoMasCorto = caminoMasCorto;
		this.unicoBoleto = unicoBoleto;
		this.metros = 0;
	}

	public ListaGenerica<String> getCaminoMasCorto() {
		return caminoMasCorto;
	}

	public void setCaminoMasCorto(ListaGenerica<String> caminoMasCorto) {
		this.caminoMasCorto = caminoMasCorto;
	}

	public boolean isUnicoBoleto() {
		return unicoBoleto;
	}

	public void setUnicoBoleto(boolean unicoBoleto) {
		this.unicoBoleto = unicoBoleto;
	}
	
	public int getMetros() {
		return metros;
	}
	
	public void setMetros(int metros) {
		this.metros = metros;
	}

}
