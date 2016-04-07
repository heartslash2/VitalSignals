package vitalSigns;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class GlucoseLevel {

	private float glucoseLevel;
	
	public GlucoseLevel() {
		this.glucoseLevel = (float)Math.random()*10;
	}
	
	public void setGlucoseLevel(float glucoseLevel) {
		this.glucoseLevel = glucoseLevel;
	}
	
	public float getGlucoseLevel() {
		return glucoseLevel;
	}
	
	/**
	 * Hello there
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.000");
		df.setRoundingMode(RoundingMode.DOWN);
		return df.format(this.glucoseLevel);
	}
	
}
