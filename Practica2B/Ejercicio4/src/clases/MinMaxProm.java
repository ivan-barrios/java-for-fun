package clases;

public class MinMaxProm {
	private int min;
	private int max;
	private float prom;
	


	public MinMaxProm(int min, int max, float prom) {
		this.min = min;
		this.max = max;
		this.prom = prom;
	}
	
	
	//GETTERS AND SETTERS
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public float getProm() {
		return prom;
	}
	public void setProm(float prom) {
		this.prom = prom;
	}
}
