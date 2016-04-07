package vitalSigns;

public class BloodPressure {
	
	private float bloodPressure;

	public BloodPressure() {
		RandomVitalGenerator vitals = new RandomVitalGenerator();
		this.bloodPressure = vitals.getVitals();
	}
	
	public void setBloodPressure(float bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	
	public float getBloodPressure() {
		return bloodPressure;
	}
	
}
