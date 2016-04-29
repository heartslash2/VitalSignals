package vitalSigns;

/**
 * The <em>BodyTemperature</em> class is used to represent a temperature sensor.
 * 
 * @author Jonathan McMeans (mcmeans.4@wright.edu)
 */
public class BodyTemperature {

	/**
	 * The <em>actualBodyTemperature</em> variable used to represent the
	 * patient's body temperature.
	 */
	private float actualBodyTemperature;
	/**
	 * The <em>normalRange</em> array used to represent the range of normal body
	 * temperatures for this sensor.
	 */
	private float[] normalRange = new float[2];
	/**
	 * The <em>status</em> variable used to represent if the sensor reads that
	 * the body temperature is too low, normal, or too high.
	 */
	private String status;

	/**
	 * Simulate a body temperature sensor. This creates a body temperature in
	 * the range of [91, 104] with a normal range of [97, 99].
	 */
	public BodyTemperature() {
		// (low range, high range, low normal, high normal)
		this(91, 104, 97, 99);
	}

	/**
	 * Simulate a body temperature sensor. This creates a body temperature of
	 * <em>temperature</em> with a normal range of [97, 99].
	 * 
	 * @param temperature
	 *            The body temperature a sensor would read
	 */
	public BodyTemperature(float temperature) {
		this.normalRange[0] = 97;
		this.normalRange[1] = 99;
		this.actualBodyTemperature = temperature;
		isNormal();
	}

	/**
	 * Simulate a body temperature sensor by passing in minimum and maximum
	 * values for a random number generator to create a random number in the
	 * range of [min, max].<br>
	 * Note that this includes both min and max as possible values.
	 * 
	 * @param actualMinimum
	 *            A simulated body temperature minimum (outside normalRange)
	 * @param actualMaximum
	 *            A simulated body temperature maximum (outside normalRange)
	 * @param normalRangeMinimum
	 *            The minimum value of the normal range
	 * @param normalRangeMaximum
	 *            The maximum value of the normal range
	 */
	public BodyTemperature(float actualMinimum, float actualMaximum, float normalRangeMinimum,
			float normalRangeMaximum) {
		// set normal range
		this.normalRange[0] = normalRangeMinimum;
		this.normalRange[1] = normalRangeMaximum;
		/*
		 * generate random number in range [actualMinimum, actualMaximum] the
		 * number is generated using the standard formula for ranges, that is
		 * (rand * (max - min)) + min uses Math.random(), which returns double,
		 * so cast to float after all calculations
		 */
		this.actualBodyTemperature = (float) ((Math.random() * (actualMaximum - actualMinimum)) + actualMinimum);
		// check if the simulated glucoseLevel is normal
		isNormal();
	}

	/**
	 * This method will determine if the <em>actualBodyTemperature</em> is
	 * inside the <em>normalRange</em> or if the <em>actualBodyTemperature</em>
	 * is too high or low. There is no return; instead, this method sets the
	 * status value to either "low", "normal", or "high"
	 */
	private void isNormal() {
		// is actualGlucoseLevel in normal range?
		if (this.actualBodyTemperature >= this.normalRange[0] && this.actualBodyTemperature <= this.normalRange[1]) {
			setStatus("normal");
			// is actualGlucoseLevel too low?
		} else if (this.actualBodyTemperature < this.normalRange[0]) {
			setStatus("low");
			// is actualGlucoseLevel too high?
		} else if (this.actualBodyTemperature > this.normalRange[1]) {
			setStatus("high");
		}
	}

	/**
	 * Setter for <em>actualBodyTemperature</em>
	 * 
	 * @param actualBodyTemperature
	 *            The reading of the body temperature sensor
	 */
	public void setActualBodyTemperature(float actualBodyTemperature) {
		this.actualBodyTemperature = actualBodyTemperature;
	}

	/**
	 * Getter for <em>actualBodyTemperature</em>
	 * 
	 * @return <em>actualBodyTemperature</em> the reading of the body
	 *         temperature sensor
	 */
	public float getActualBodyTemperature() {
		return actualBodyTemperature;
	}

	/**
	 * Setter for <em>normalRange</em> by float array
	 * 
	 * @param normalRange
	 *            The range of normal heart-rates for this sensor
	 */
	public void setNormalRange(float[] normalRange) {
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
	public void setNormalRange(float minimumNormalRange, float maximumNormalRange) {
		this.normalRange[0] = minimumNormalRange;
		this.normalRange[1] = maximumNormalRange;
	}

	/**
	 * Getter for <em>normalRange</em>
	 * 
	 * @return <em>normalRange</em> the range of normal body temperatures for
	 *         this sensor
	 */
	public float[] getNormalRange() {
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
