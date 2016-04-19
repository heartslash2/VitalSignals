package vitalSigns;

public class BloodOxygen {

	private int actualBloodOxygen;
	private int[] validRange = new int[2];
	private String status;

	public BloodOxygen() {
		this(80, 100, 94, 98);
	}
	
	public BloodOxygen(int bloodOxygen) {
		this.validRange[0] = 94;
		this.validRange[1] = 98;
		this.actualBloodOxygen = bloodOxygen;
		isValid();
	}

	public BloodOxygen(int actualMinimum, int actualMaximum, int validRangeMinimum, int validRangeMaximum) {
		// set valid range
		this.validRange[0] = validRangeMinimum;
		this.validRange[1] = validRangeMaximum;
		/*
		 * generate random number in range [actualMinimum, actualMaximum] the
		 * number is generated using the standard formula for ranges, that is
		 * (rand * (max - min)) + min uses Math.random(), which returns double,
		 * so cast to float after all calculations
		 */
		this.actualBloodOxygen = (int) ((Math.random() * (actualMaximum - actualMinimum)) + actualMinimum);
		// set status based on validity
		isValid();
	}

	/**
	 * This method will determine if the <em>actualHeartRate</em> is inside the
	 * <em>validRange</em> or if the <em>actualHeartRate</em> is too high or
	 * low. There is no return; instead, this method sets the status value to
	 * either "low", "normal", or "high"
	 */
	private void isValid() {
		// is actualHeartRate in valid range?
		if (this.actualBloodOxygen >= this.validRange[0] && this.actualBloodOxygen <= this.validRange[1]) {
			setStatus("normal");
			// is actualHeartRate too low?
		} else if (this.actualBloodOxygen < this.validRange[0]) {
			setStatus("low");
			// is actualHeartRate too high?
		} else if (this.actualBloodOxygen > this.validRange[1]) {
			setStatus("high");
		}
	}

	public void setActualBloodOxygen(int actualBloodOxygen) {
		this.actualBloodOxygen = actualBloodOxygen;
	}

	public int getActualBloodOxygen() {
		return actualBloodOxygen;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

}
