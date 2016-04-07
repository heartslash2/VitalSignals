package vitalSigns;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BodyTemperature {

	private float bodyTemperature;
	
	public BodyTemperature() {
		this.bodyTemperature = (float)Math.random()*10;
	}
	
	public void setBodyTemperature(float bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}
	
	public float getBodyTemperature() {
		return bodyTemperature;
	}
	
	/**
	 * Hello there
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.000");
		df.setRoundingMode(RoundingMode.DOWN);
		return df.format(this.bodyTemperature);
	}
	
}
