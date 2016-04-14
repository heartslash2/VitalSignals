package vitalSigns;

public class BodyTemperature {

	private float bodyTemperature;
	
	public BodyTemperature() {
		this.bodyTemperature = (float)Math.random()*10;
	}
	
	public void setBodyTemperature(float bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}
	
	public float getBodyTemperature() {
		return bodyTemperature;
	}
	
}
