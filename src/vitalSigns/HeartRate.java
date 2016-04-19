package vitalSigns;


/**
 * The <em>actualHeartRate</em> class is used to represent a heart-rate sensor. 
 * @author Jonathan McMeans (mcmeans.4@wright.edu)
 *
 */
public class HeartRate {
	
	/** 
	 * The <em>actualHeartRate</em> variable used to represent the patient's heart-rate.
	 */
	private int actualHeartRate;
	/**
	 * The <em>validRange</em> array used to represent the range of valid heart rates for
	 * this sensor.
	 */
	private int[] validRange = new int[2];
	/**
	 * The <em>status</em> variable used to represent if the sensor reads that the heart-rate
	 * is too low, normal, or too high.
	 */
	private String status;
	
	/**
	 * Simulate a heart-rate sensor for a general 20 year old. This just calls the constructor
	 * using two floats, 100 and 170, as demonstrated by 
	 * http://www.heart.org/HEARTORG/HealthyLiving/PhysicalActivity/FitnessBasics/Target-Heart-Rates_UCM_434341_Article.jsp#.Vw1s6_nBzGc<br>
	 * This range is 50% to 85% heart-rate, which is considered normal. The simulation will go
	 * to 100%, so a 15% range is used on both sides to allow for theoretical readings. Thus,
	 * 70 will be the absolute minimum reading and 200 will be the absolute maximum reading.
	 */
	public HeartRate() {
		this(70, 200, 100, 170);
	}
	
	/**
	 * Simulate a heart-rate sensor by passing in minimum and maximum values for
	 * a random number generator to create a random number in the range [min,max].<br>
	 * Note that this includes both min and max as possible values.
	 * @param actualMinimum A simulated heart-rate minimum (outside validRange)
	 * @param actualMaximum A simulated heart-rate maximum (outside validRange)
	 * @param validRangeMinimum The minimum value of the valid range
	 * @param validRangeMaximum The maximum value of the valid range
	 */
	public HeartRate(int actualMinimum, 
					 int actualMaximum, 
					 int validRangeMinimum,
					 int validRangeMaximum) {
		// set valid range
		this.validRange[0] = validRangeMinimum;
		this.validRange[1] = validRangeMaximum;
		/* generate random number in range [actualMinimum, actualMaximum]
		 * the number is generated using the standard formula for ranges, that is
		 * (rand * (max - min)) + min
		 * uses Math.random(), which returns double, so cast to float after all calculations
		 */
		this.actualHeartRate = (int)((Math.random() * (actualMaximum - actualMinimum)) + actualMinimum);
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
		if (this.actualHeartRate >= this.validRange[0] 
				&& this.actualHeartRate <= this.validRange[1]) {
			setStatus("normal");
		// is actualHeartRate too low?
		} else if (this.actualHeartRate < this.validRange[0]) {
			setStatus("low");
		// is actualHeartRate too high?
		} else if (this.actualHeartRate > this.validRange[1]) {
			setStatus("high");
		}
	}
	
	/**
	 * Setter for <em>actualHeartRate</em>
	 * @param actualHeartRate The reading of the heart-rate sensor
	 */
	public void setActualHeartRate(int actualHeartRate) {
		this.actualHeartRate = actualHeartRate;
	}
	
	/**
	 * Getter for <em>actualHeartRate</em>
	 * @return <em>actualHeartRate</em> the reading of the heart-rate sensor
	 */
	public int getActualHeartRate() {
		return actualHeartRate;
	}
	
	/**
	 * Setter for <em>validRange</em> by float array
	 * @param validRange The range of valid heart-rates for this sensor
	 */
	public void setValidRange(int[] validRange) {
		this.validRange = validRange;
	}
	
	/**
	 * Setter for <em>validRange</em> by float values
	 * @param minimumValidRange The minimum number of the validRange
	 * @param maximumValidRange The maximum number of the validRange
	 */
	public void setValidRange(int minimumValidRange, int maximumValidRange) {
		this.validRange[0] = minimumValidRange;
		this.validRange[1] = maximumValidRange;
	}
	
	public int[] getValidRange() {
		return validRange;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}	

}
