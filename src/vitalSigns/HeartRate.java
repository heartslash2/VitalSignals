package vitalSigns;

/**
 * The <em>HeartRate</em> class is used to represent a heart-rate sensor.
 * 
 * @author Jonathan McMeans (mcmeans.4@wright.edu)
 *
 */
public class HeartRate {

	/**
	 * The <em>actualHeartRate</em> variable used to represent the patient's
	 * heart-rate.
	 */
	private int actualHeartRate;
	/**
	 * The <em>normalRange</em> array used to represent the range of normal
	 * heart rates for this sensor.
	 */
	private int[] normalRange = new int[2];
	/**
	 * The <em>status</em> variable used to represent if the sensor reads that
	 * the heart-rate is too low, normal, or too high.
	 */
	private String status;

	/**
	 * Simulate a heart-rate sensor. This creates a heart-rate within the range
	 * [30, 120] with a normal range of [65, 85].
	 */
	public HeartRate() {
		// (low range, high range, low normal, high normal)
		this(30, 120, 65, 85);
	}

	/**
	 * Simulate a heart-rate sensor. This creates a heart rate of
	 * <em>heartRate</em> with a normal range of [65, 85].
	 * 
	 * @param heartRate
	 *            The heart-rate that a sensor would read.
	 */
	public HeartRate(int heartRate) {
		// set normal range
		this.normalRange[0] = 65;
		this.normalRange[1] = 85;
		this.actualHeartRate = heartRate;
		// check if the input heartRate is normal
		isNormal();
	}

	/**
	 * Simulate a heart-rate sensor by passing in minimum and maximum values for
	 * a random number generator to create a random number in the range [min,
	 * max].<br>
	 * Note that this includes both min and max as possible values.
	 * 
	 * @param actualMinimum
	 *            A simulated heart-rate minimum (outside normalRange)
	 * @param actualMaximum
	 *            A simulated heart-rate maximum (outside normalRange)
	 * @param normalRangeMinimum
	 *            The minimum value of the normal range
	 * @param normalRangeMaximum
	 *            The maximum value of the normal range
	 */
	public HeartRate(int actualMinimum, int actualMaximum, int normalRangeMinimum, int normalRangeMaximum) {
		// set normal range
		this.normalRange[0] = normalRangeMinimum;
		this.normalRange[1] = normalRangeMaximum;
		/*
		 * generate random number in range [actualMinimum, actualMaximum] the
		 * number is generated using the standard formula for ranges, that is
		 * (rand * (max - min)) + min uses Math.random(), which returns double,
		 * so cast to int after all calculations
		 */
		this.actualHeartRate = (int) ((Math.random() * (actualMaximum - actualMinimum)) + actualMinimum);
		// check if the simulated heartRate is normal
		isNormal();
	}

	/**
	 * This method will determine if the <em>actualHeartRate</em> is inside the
	 * <em>normalRange</em> or if the <em>actualHeartRate</em> is too high or
	 * low. There is no return; instead, this method sets the status value to
	 * either "low", "normal", or "high"
	 */
	private void isNormal() {
		// is actualHeartRate in normal range?
		if (this.actualHeartRate >= this.normalRange[0] && this.actualHeartRate <= this.normalRange[1]) {
			setStatus("normal");
			// is actualHeartRate too low?
		} else if (this.actualHeartRate < this.normalRange[0]) {
			setStatus("low");
			// is actualHeartRate too high?
		} else if (this.actualHeartRate > this.normalRange[1]) {
			setStatus("high");
		}
	}

	/**
	 * Setter for <em>actualHeartRate</em>
	 * 
	 * @param actualHeartRate
	 *            The reading of the heart-rate sensor
	 */
	public void setActualHeartRate(int actualHeartRate) {
		this.actualHeartRate = actualHeartRate;
	}

	/**
	 * Getter for <em>actualHeartRate</em>
	 * 
	 * @return <em>actualHeartRate</em> the reading of the heart-rate sensor
	 */
	public int getActualHeartRate() {
		return actualHeartRate;
	}

	/**
	 * Setter for <em>normalRange</em> by float array
	 * 
	 * @param normalRange
	 *            The range of normal heart-rates for this sensor
	 */
	public void setNormalRange(int[] normalRange) {
		this.normalRange = normalRange;
	}

	/**
	 * Setter for <em>normalRange</em> by float values
	 * 
	 * @param minimumNormalRange
	 *            The minimum number of the normalRange
	 * @param maximumNormalRange
	 *            The maximum number of the normalRange
	 */
	public void setNormalRange(int minimumNormalRange, int maximumNormalRange) {
		this.normalRange[0] = minimumNormalRange;
		this.normalRange[1] = maximumNormalRange;
	}

	/**
	 * Getter for <em>normalRange</em>
	 * 
	 * @return <em>normalRange</em> the range of normal heart-rates for this
	 *         sensor
	 */
	public int[] getNormalRange() {
		return normalRange;
	}

	/**
	 * Setter for <em>status</em>
	 * 
	 * @param status
	 *            the health status normal/low/high
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Getter for <em>status</em>
	 * 
	 * @return <em>status</em> the health status normal/low/high
	 */
	public String getStatus() {
		return status;
	}

}
