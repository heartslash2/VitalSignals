package vitalSigns;

public class GlucoseLevel {

	private float glucoseLevel;
	
	public GlucoseLevel() {
		this.glucoseLevel = (float)Math.random()*10;
	}
	
	public void setGlucoseLevel(float glucoseLevel) {
		this.glucoseLevel = glucoseLevel;
	}
	
	public float getGlucoseLevel() {
		return glucoseLevel;
	}
	
}
