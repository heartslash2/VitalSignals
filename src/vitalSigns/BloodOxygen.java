package vitalSigns;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BloodOxygen {

	private float bloodOxygen;
	
	BloodOxygen() {
		this.bloodOxygen = (float)Math.random()*10;
	}
	
	public void setBloodOxygen(float bloodOxygen) {
		this.bloodOxygen = bloodOxygen;
	}
	
	public float getBloodOxygen() {
		return bloodOxygen;
	}
	
	/**
	 * Hello there
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.000");
		df.setRoundingMode(RoundingMode.DOWN);
		return df.format(this.bloodOxygen);
	}
}
