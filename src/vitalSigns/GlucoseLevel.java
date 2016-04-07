package vitalSigns;

public class GlucoseLevel {

	private float glucoseLevel;
	
	public GlucoseLevel() {
		RandomVitalGenerator vitals = new RandomVitalGenerator();
		this.glucoseLevel = vitals.getVitals();
	}
	
	public void setGlucoseLevel(float glucoseLevel) {
		this.glucoseLevel = glucoseLevel;
	}
	
	public float getGlucoseLevel() {
		return glucoseLevel;
	}
	
}
