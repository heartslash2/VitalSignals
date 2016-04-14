package vitalSigns;

public class BodyTemperature {

	private float actualBodyTemperature;
	
	public BodyTemperature() {
		this.actualBodyTemperature = (float)Math.random()*10;
	}
	
	public void setActualBodyTemperature(float actualBodyTemperature) {
		this.actualBodyTemperature = actualBodyTemperature;
	}
	
	public float getActualBodyTemperature() {
		return actualBodyTemperature;
	}
	
}
