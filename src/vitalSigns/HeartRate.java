package vitalSigns;

public class HeartRate {
	
	private float heartRate;
	
	public HeartRate() {
		RandomVitalGenerator vitals = new RandomVitalGenerator();
		this.heartRate = vitals.getVitals();
	}
	
	/**
	 * Simulate a heart-rate sensor by passing in minimum and maximum values for
	 * a random number generator to create a random number in the range [min,max].<br>
	 * Note that this includes both min and max as possible values.
	 * @param min <em>float</em> The minimum the heart-rate should be
	 * @param max <em>float</em> The maximum the heart-rate should be
	 */
	public HeartRate(float min, float max) {
		RandomVitalGenerator vitals = new RandomVitalGenerator(min, max);
		this.heartRate = vitals.getVitals();
	}
	
	public void setHeartRate(float heartRate) {
		this.heartRate = heartRate;
	}
	
	public float getHeartRate() {
		return heartRate;
	}

}
