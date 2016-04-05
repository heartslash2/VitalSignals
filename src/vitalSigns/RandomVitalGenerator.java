package vitalSigns;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class RandomVitalGenerator {
	/** The variable <em>vitals</em> is used to represent a single vital signal.<br><br>
	 *  <em>Vitals</em> uses standard Java floating point numbers to represent the readings
	 */
	private float vitals;
	
	public RandomVitalGenerator() {
		this.vitals = (float)(Math.random()*10);
	}
	
	public RandomVitalGenerator(float min, float max) {
		// random float in range [min,max] is Random.nextFloat() * (max - min) + min
		Random random = new Random();
		this.vitals =  random.nextFloat() * (max - min) + min;
	}
	
	public float getVitals() {
		return vitals;
	}
	
	public void setVitals(int vitals) {
		this.vitals = vitals;
	}
	
	/**
	 * Hello there
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.000");
		df.setRoundingMode(RoundingMode.DOWN);
		return df.format(this.vitals);
	}
}
