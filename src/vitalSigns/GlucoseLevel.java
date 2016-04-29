package vitalSigns;

/**
 * The <em>GlucoseLevel</em> class is used to represent a glucose sensor.
 * 
 * @author Jonathan McMeans (mcmeans.4@wright.edu)
 */
public class GlucoseLevel {

	/**
	 * The <em>actualGlucoseLevel</em> variable used to represent the patient's
	 * glucose level.
	 */
	private int actualGlucoseLevel;
	/**
	 * The <em>normalRange</em> array used to represent the range of normal
	 * glucose levels for this sensor.
	 */
	private int[] normalRange = new int[2];
	/**
	 * The <em>status</em> variable used to represent if the sensor reads that
	 * the glucose level is too low, normal, or too high.
	 */
	private String status;

	/**
	 * Simulate a glucose level sensor. This creates a glucose level in the
	 * range of [35, 150] with a normal range of [75, 110].
	 */
	public GlucoseLevel() {
		// (low range, high range, low normal, high normal)
		this(35, 150, 75, 110);
	}

	/**
	 * Simulate a glucose level sensor. This creates a glucose level of
	 * <em>glucoseLevel</em> with a normal range of [75, 110].
	 * 
	 * @param glucoseLevel
	 *            The glucose level a sensor would read
	 */
	public GlucoseLevel(int glucoseLevel) {
		// set normal range
		this.normalRange[0] = 75;
		this.normalRange[1] = 110;
		this.actualGlucoseLevel = glucoseLevel;
		// check if the input glucose level is normal
		isNormal();
	}

	/**
	 * Simulate a glucose level sensor by passing in minimum and maximum values
	 * for a random number generator to create a random number in the range of
	 * [min, max].<br>
	 * Note that this includes both min and max as possible values.
	 * 
	 * @param actualMinimum
	 *            A simulated glucose level minimum (outside normalRange)
	 * @param actualMaximum
	 *            A simulated glucose level maximum (outside normalRange)
	 * @param normalRangeMinimum
	 *            The minimum value of the normal range
	 * @param normalRangeMaximum
	 *            The maximum value of the normal range
	 */
	public GlucoseLevel(int actualMinimum, int actualMaximum, int normalRangeMinimum, int normalRangeMaximum) {
		// set normal range
		this.normalRange[0] = normalRangeMinimum;
		this.normalRange[1] = normalRangeMaximum;
		/*
		 * generate random number in range [actualMinimum, actualMaximum] the
		 * number is generated using the standard formula for ranges, that is
		 * (rand * (max - min)) + min uses Math.random(), which returns double,
		 * so cast to int after all calculations
		 */
		this.actualGlucoseLevel = (int) ((Math.random() * (actualMaximum - actualMinimum)) + actualMinimum);
		// check if the simulated glucoseLevel is normal
		isNormal();
	}

	/**
	 * This method will determine if the <em>actualGlucoseLevel</em> is inside
	 * the <em>normalRange</em> or if the <em>actualGlucoseLevel</em> is too
	 * high or low. There is no return; instead, this method sets the status
	 * value to either "low", "normal", or "high"
	 */
	private void isNormal() {
		// is actualGlucoseLevel in normal range?
		if (this.actualGlucoseLevel >= this.normalRange[0] && this.actualGlucoseLevel <= this.normalRange[1]) {
			setStatus("normal");
			// is actualGlucoseLevel too low?
		} else if (this.actualGlucoseLevel < this.normalRange[0]) {
			setStatus("low");
			// is actualGlucoseLevel too high?
		} else if (this.actualGlucoseLevel > this.normalRange[1]) {
			setStatus("high");
		}
	}

	/**
	 * Setter for <em>actualGlucoseLevel</em>
	 * 
	 * @param actualGlucoseLevel
	 *            The reading of the glucose level sensor
	 */
	public void setActualGlucoseLevel(int actualGlucoseLevel) {
		this.actualGlucoseLevel = actualGlucoseLevel;
	}

	/**
	 * Getter for <em>actualGlucoseLevel</em>
	 * 
	 * @return <em>actualGlucoseLevel</em> the reading of the glucose level
	 *         sensor
	 */
	public int getActualGlucoseLevel() {
		return actualGlucoseLevel;
	}

	/**
	 * Setter for <em>normalRange</em> by float array
	 * 
	 * @param normalRange
	 *            The range of normal glucose levels for this sensor
	 */
	public void setNormalRange(int[] normalRange) {
		this.normalRange = normalRange;
	}

	/**
	 * Setter for <em>normalRange</em> by int values
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
	 * @return <em>normalRange</em> the range of normal glucose levels for this
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
