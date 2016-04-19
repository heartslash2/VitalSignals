package vitalSigns;

public class GlucoseLevel {

	private int actualGlucoseLevel;
	private int[] validRange = new int[2];
	private String status;

	public GlucoseLevel() {
		// http://www.webmd.com/diabetes/guide/normal-blood-sugar-levels-chart-adults
		this(35, 150, 75, 110);
	}
	
	public GlucoseLevel(int glucoseLevel) {
		this.validRange[0] = 75;
		this.validRange[1] = 110;
		this.actualGlucoseLevel = glucoseLevel;
		isValid();
	}

	public GlucoseLevel(int actualMinimum, int actualMaximum, int validRangeMinimum, int validRangeMaximum) {
		this.validRange[0] = validRangeMinimum;
		this.validRange[1] = validRangeMaximum;
		this.actualGlucoseLevel = (int) ((Math.random() * (actualMaximum - actualMinimum)) + actualMinimum);
		isValid();
	}

	private void isValid() {
		// is actualGlucoseLevel in valid range?
		if (this.actualGlucoseLevel >= this.validRange[0] && this.actualGlucoseLevel <= this.validRange[1]) {
			setStatus("normal");
			// is actualGlucoseLevel too low?
		} else if (this.actualGlucoseLevel < this.validRange[0]) {
			setStatus("low");
			// is actualGlucoseLevel too high?
		} else if (this.actualGlucoseLevel > this.validRange[1]) {
			setStatus("high");
		}
	}

	public void setActualGlucoseLevel(int actualGlucoseLevel) {
		this.actualGlucoseLevel = actualGlucoseLevel;
	}

	public int getActualGlucoseLevel() {
		return actualGlucoseLevel;
	}

	/**
	 * Setter for <em>validRange</em> by float array
	 * 
	 * @param validRange
	 *            The range of valid heart-rates for this sensor
	 */
	public void setValidRange(int[] validRange) {
		this.validRange = validRange;
	}

	/**
	 * Setter for <em>validRange</em> by float values
	 * 
	 * @param minimumValidRange
	 *            The minimum number of the validRange
	 * @param maximumValidRange
	 *            The maximum number of the validRange
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
