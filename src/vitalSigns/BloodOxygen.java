package vitalSigns;

public class BloodOxygen {

	private float bloodOxygen;
	
	BloodOxygen() {
		this.bloodOxygen = (float)Math.random()*10;
	}
	
	public void setBloodOxygen(float bloodOxygen) {
		this.bloodOxygen = bloodOxygen;
	}
	
	public float getBloodOxygen() {
		return bloodOxygen;
	}
	
}
