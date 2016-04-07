package vitalSigns;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BloodPressure {
	
	private float bloodPressure;

	public BloodPressure() {
		this.bloodPressure = (float)Math.random()*10;
	}
	
	public void setBloodPressure(float bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	
	public float getBloodPressure() {
		return bloodPressure;
	}
	
	/**
	 * Hello there
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.000");
		df.setRoundingMode(RoundingMode.DOWN);
		return df.format(this.bloodPressure);
	}
	
}
