package vitalSigns;

/**
 * The <em>BloodOxygen</em> class is used to represent a blood oxygen sensor.
 * This measures the blood oxygen as percentage.
 * 
 * @author Jonathan McMeans (mcmeans.4@wright.edu)
 */
public class BloodOxygen {

	/**
	 * The <em>actualBloodOxygen</em> variable used to represent the patient's
	 * blood oxygen.
	 */
	private int actualBloodOxygen;
	/**
	 * The <em>normalRange</em> array used to represent the range of normal
	 * blood oxygen for this sensor.
	 */
	private int[] normalRange = new int[2];
	/**
	 * The <em>status</em> variable used to represent if the sensor reads that
	 * the blood oxygen is too low, normal, or too high.
	 */
	private String status;

	/**
	 * Simulate a blood oxygen sensor. This creates a blood oxygen level in the
	 * range of [80, 100] with a normal range of [94, 98].
	 */
	public BloodOxygen() {
		// (low range, high range, low normal, high normal)
		this(80, 100, 94, 98);
	}

	/**
	 * Simulate a blood oxygen sensor. This creates a blood oxygen level of
	 * <em>bloodOxygen</em> with a normal range of [94, 98].
	 * 
	 * @param bloodOxygen
	 *            The blood oxygen level a sensor would read
	 */
	public BloodOxygen(int bloodOxygen) {
		// set normal range
		this.normalRange[0] = 94;
		this.normalRange[1] = 98;
		this.actualBloodOxygen = bloodOxygen;
		// check if the input blood oxygen is normal
		isNormal();
	}

	/**
	 * Simulate a blood oxygen sensor by passing in minimum and maximum values
	 * for a random number generator to create a random number in the range of
	 * [min, max].<br>
	 * Note that this includes both min and max as possible values.
	 * 
	 * @param actualMinimum
	 *            A simulated blood oxygen level minimum (outside normalRange)
	 * @param actualMaximum
	 *            A simulated blood oxygen level maximum (outside normalRange)
	 * @param normalRangeMinimum
	 *            The minimum value of the normal range
	 * @param normalRangeMaximum
	 *            The maximum value of the normal range
	 */
	public BloodOxygen(int actualMinimum, int actualMaximum, int normalRangeMinimum, int normalRangeMaximum) {
		// set normal range
		this.normalRange[0] = normalRangeMinimum;
		this.normalRange[1] = normalRangeMaximum;
		/*
		 * generate random number in range [actualMinimum, actualMaximum] the
		 * number is generated using the standard formula for ranges, that is
		 * (rand * (max - min)) + min uses Math.random(), which returns double,
		 * so cast to int after all calculations
		 */
		this.actualBloodOxygen = (int) ((Math.random() * (actualMaximum - actualMinimum)) + actualMinimum);
		// check if the simulated bloodOxygen is normal
		isNormal();
	}

	/**
	 * This method will determine if the <em>actualBloodOxygen</em> is inside
	 * the <em>normalRange</em> or if the <em>actualBloodOxygen</em> is too high
	 * or low. There is no return; instead, this method sets the status value to
	 * either "low", "normal", or "high"
	 */
	private void isNormal() {
		// is actualBloodOxygen in normal range?
		if (this.actualBloodOxygen >= this.normalRange[0] && this.actualBloodOxygen <= this.normalRange[1]) {
			setStatus("normal");
			// is actualBloodOxygen too low?
		} else if (this.actualBloodOxygen < this.normalRange[0]) {
			setStatus("low");
			// is actualBloodOxygen too high?
		} else if (this.actualBloodOxygen > this.normalRange[1]) {
			setStatus("high");
		}
	}

	/**
	 * Setter for <em>actualBloodOxygen</em>
	 * 
	 * @param actualBloodOxygen
	 *            The reading of the blood oxygen level sensor
	 */
	public void setActualBloodOxygen(int actualBloodOxygen) {
		this.actualBloodOxygen = actualBloodOxygen;
	}

	/**
	 * Getter for <em>actualBloodOxygen</em>
	 * 
	 * @return <em>actualBloodOxygen</em> the reading of the blood oxygen level
	 *         sensor
	 */
	public int getActualBloodOxygen() {
		return actualBloodOxygen;
	}

	/**
	 * Setter for <em>normalRange</em> by float array
	 * 
	 * @param normalRange
	 *            The range of normal blood oxygen levels for this sensor
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
	 * @return <em>normalRange</em> the range of normal blood oxygen levels for
	 *         this sensor
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
