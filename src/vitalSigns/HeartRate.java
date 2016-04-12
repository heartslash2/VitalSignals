package vitalSigns;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * The <em>actualHeartRate</em> class is used to represent a heart-rate sensor. 
 * @author Jonathan McMeans (mcmeans.4@wright.edu)
 *
 */
public class HeartRate {
	
	/** 
	 * The <em>actualHeartRate</em> variable used to represent the patient's heart-rate.
	 */
	private float actualHeartRate;
	/**
	 * The <em>validRange</em> array used to represent the range of valid heart rates for
	 * this sensor.
	 */
	private float[] validRange = new float[2];
	/**
	 * The <em>status</em> variable used to represent if the sensor reads that the heart-rate
	 * is too low, normal, or too high.
	 */
	private String status;
	
	/**
	 * Simulate a heart-rate sensor for a general 20 year old. This just calls the constructor
	 * using two floats, 100f and 170f, as demonstrated by 
	 * http://www.heart.org/HEARTORG/HealthyLiving/PhysicalActivity/FitnessBasics/Target-Heart-Rates_UCM_434341_Article.jsp#.Vw1s6_nBzGc<br>
	 * This range is 50% to 85% heart-rate, which is considered normal. The simulation will go
	 * to 100%, so a 15% range is used on both sides to allow for theoretical readings. Thus,
	 * 70f will be the absolute minimum reading and 200f will be the absolute maximum reading.
	 */
	public HeartRate() {
		this(70f, 200f, 100f, 170f);
	}
	
	/**
	 * Simulate a heart-rate sensor by passing in minimum and maximum values for
	 * a random number generator to create a random number in the range [min,max].<br>
	 * Note that this includes both min and max as possible values.
	 * @param actualMinimum <em>float</em> A simulated heart-rate minimum (outside validRange)
	 * @param actualMaximum <em>float</em> A simulated heart-rate maximum (outside validRange)
	 * @param validRangeMinimum <em>float</em> The minimum value of the valid range
	 * @param validRangeMaximum <em>float</em> The maximum value of the valid range
	 */
	public HeartRate(float actualMinimum, 
					 float actualMaximum, 
					 float validRangeMinimum,
					 float validRangeMaximum) {
		// set valid range
		this.validRange[0] = validRangeMinimum;
		this.validRange[1] = validRangeMaximum;
		/* generate random number in range [actualMinimum, actualMaximum]
		 * the number is generated using the standard formula for ranges, that is
		 * (rand * (max - min)) + min
		 * uses Math.random(), which returns double, so cast to float after all calculations
		 */
		this.actualHeartRate = (float)((Math.random() * (actualMaximum - actualMinimum)) + actualMinimum);
		// set status based on validity
		isValid();
	}
	
	/**
	 * This method will determine if the <em>actualHeartRate</em> is inside the <em>validRange</em> 
	 * or if the <em>actualHeartRate</em> is too high or low. There is no return; instead, this
	 * method sets the status value to either "low", "normal", or "high"
	 */
	private void isValid() {
		// is actualHeartRate in valid range?
		if (this.actualHeartRate > this.validRange[0] 
				&& this.actualHeartRate < this.validRange[1]) {
			setStatus("normal");
		// is actualHeartRate too low?
		} else if (this.actualHeartRate < this.validRange[0]) {
			setStatus("low");
		// is actualHeartRate too high?
		} else if (this.actualHeartRate > this.validRange[1]) {
			setStatus("high");
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
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	/**
	 * Return the status of the heart-rate as well as the actual heart-rate, truncated to 3
	 * decimal places
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.000");
		df.setRoundingMode(RoundingMode.DOWN);
		String heartRate = df.format(this.actualHeartRate);
		return this.status + " " + heartRate;
	}

}
