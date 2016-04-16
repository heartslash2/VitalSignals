package vitalSigns;

public class BodyTemperature {

	private float actualBodyTemperature;
	private float[] validRange = new float[2];
	private String status;
	
	public BodyTemperature() {
		// https://www.nlm.nih.gov/medlineplus/ency/article/001982.htm
		this(97, 99, 91, 105);
	}
	
	public BodyTemperature(float actualMinimum, float actualMaximum,
			float validRangeMinimum, float validRangeMaximum) {
		this.validRange[0] = validRangeMinimum;
		this.validRange[1] = validRangeMaximum;
		this.actualBodyTemperature = (float)((Math.random() * (actualMaximum - actualMinimum)) + actualMinimum);
		isValid();
	}
	
	private void isValid() {
		// is actualGlucoseLevel in valid range?
		if (this.actualBodyTemperature > this.validRange[0]
				&& this.actualBodyTemperature < this.validRange[1]) {
			setStatus("normal");
			// is actualGlucoseLevel too low?
		} else if (this.actualBodyTemperature < this.validRange[0]) {
			setStatus("low");
			// is actualGlucoseLevel too high?
		} else if (this.actualBodyTemperature > this.validRange[1]) {
			setStatus("high");
		}
	}
	
	public void setActualBodyTemperature(float actualBodyTemperature) {
		this.actualBodyTemperature = actualBodyTemperature;
	}
	
	public float getActualBodyTemperature() {
		return actualBodyTemperature;
	}
	
	/**
	 * Setter for <em>validRange</em> by float array
	 * @param validRange The range of valid heart-rates for this sensor
	 */
	public void setValidRange(float[] validRange) {
		this.validRange = validRange;
	}
	
	/**
	 * Setter for <em>validRange</em> by float values
	 * @param minimumValidRange The minimum number of the validRange
	 * @param maximumValidRange The maximum number of the validRange
	 */
	public void setValidRange(float minimumValidRange, float maximumValidRange) {
		this.validRange[0] = minimumValidRange;
		this.validRange[1] = maximumValidRange;
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
	
	
}
