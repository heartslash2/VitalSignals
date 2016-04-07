package vitalSigns;

public class BodyTemperature {

	private float bodyTemperature;
	
	public BodyTemperature() {
		RandomVitalGenerator vitals = new RandomVitalGenerator();
		this.bodyTemperature = vitals.getVitals();
	}
	
	public void setBodyTemperature(float bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}
	
	public float getBodyTemperature() {
		return bodyTemperature;
	}
	
}
