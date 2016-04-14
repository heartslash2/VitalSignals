package vitalSigns;

public class BloodPressure {
	
	private float bloodPressure;

	public BloodPressure() {
		this.bloodPressure = (float)Math.random()*10;
	}
	
	public void setBloodPressure(float bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	
	public float getBloodPressure() {
		return bloodPressure;
	}
	
}
