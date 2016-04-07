package vitalSigns;

public class BloodOxygen {

	private float bloodOxygen;
	
	BloodOxygen() {
		RandomVitalGenerator vitals = new RandomVitalGenerator();
		this.bloodOxygen = vitals.getVitals();
	}
	
	public void setBloodOxygen(float bloodOxygen) {
		this.bloodOxygen = bloodOxygen;
	}
	
	public float getBloodOxygen() {
		return bloodOxygen;
	}
}
