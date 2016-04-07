package vitalSigns;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class HeartRate {
	
	private float heartRate;
	
	/**
	 * Simulate a heart-rate sensor by creating a random number.<br>
	 * Note that this constructor should not be used unless a true random
	 * number is desired. The method simply calls Math.random() and multiplies
	 * that value by 10.
	 */
	public HeartRate() {
		this.heartRate = (float)Math.random()*10;
	}
	
	/**
	 * Simulate a heart-rate sensor by passing in minimum and maximum values for
	 * a random number generator to create a random number in the range [min,max].<br>
	 * Note that this includes both min and max as possible values.
	 * @param min <em>float</em> The minimum the heart-rate should be
	 * @param max <em>float</em> The maximum the heart-rate should be
	 */
	public HeartRate(float min, float max) {
		
	}
	
	public void setHeartRate(float heartRate) {
		this.heartRate = heartRate;
	}
	
	public float getHeartRate() {
		return heartRate;
	}
	
	/**
	 * Hello there
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.000");
		df.setRoundingMode(RoundingMode.DOWN);
		return df.format(this.heartRate);
	}

}
