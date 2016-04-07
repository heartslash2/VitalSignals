package vitalSigns;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * The <em>actualHeartRate</em> class is used to represent a heart-rate sensor. 
 * @author Jonathan McMeans (mcmeans.4@wright.edu)
 *
 */
public class HeartRate {
	
	/** The <em>actualHeartRate</em> variable used to represent the patient's heart-rate.
	 */
	private float actualHeartRate;
	private float[] validRange = new float[2];
	
	/**
	 * Simulate a heart-rate sensor by passing in minimum and maximum values for
	 * a random number generator to create a random number in the range [min,max].<br>
	 * Note that this includes both min and max as possible values.
	 * @param min <em>float</em> The minimum the heart-rate should be
	 * @param max <em>float</em> The maximum the heart-rate should be
	 */
	public HeartRate(float min, float max) {
		this.actualHeartRate = (float)((Math.random() * (max - min)) + min);
		isValid();
	}
	
	private void isValid() {
		if (this.actualHeartRate > this.validRange[0] 
				&& this.actualHeartRate < this.validRange[1]) {
			// something happens
		}
	}
	
	public void setActualHeartRate(float actualHeartRate) {
		this.actualHeartRate = actualHeartRate;
	}
	
	public float getActualHeartRate() {
		return actualHeartRate;
	}
	
	public void setValidRange(float[] validRange) {
		this.validRange = validRange;
	}
	
	public float[] getValidRange() {
		return validRange;
	}
	
	/**
	 * Hello there
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.000");
		df.setRoundingMode(RoundingMode.DOWN);
		return df.format(this.actualHeartRate);
	}

}
