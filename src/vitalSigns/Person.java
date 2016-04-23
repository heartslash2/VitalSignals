package vitalSigns;

/**
 * Vital signs to represent a person.
 * 
 * @author Jonathan McMeans (mcmeans.4@wright.edu)
 *
 */
public class Person {

	/**
	 * The BloodOxygen sensor readings
	 */
	private BloodOxygen bloodOxygen;
	/**
	 * The BloodPressure sensor readings
	 */
	private BloodPressure bloodPressure;
	/**
	 * The BodyTemperature sensor readings
	 */
	private BodyTemperature bodyTemperature;
	/**
	 * The GlucoseLevel sensor readings
	 */
	private GlucoseLevel glucoseLevel;
	/**
	 * The HeartRate sensor readings
	 */
	private HeartRate heartRate;

	/**
	 * Create vital signs for a person. This creates random numbers for every
	 * sensor reading. Uses standard constructor for each sensor.
	 */
	public Person() {
		bloodOxygen = new BloodOxygen();
		bloodPressure = new BloodPressure();
		bodyTemperature = new BodyTemperature();
		glucoseLevel = new GlucoseLevel();
		heartRate = new HeartRate();
	}

	/**
	 * Create vital signs for a person, as per all parameters.
	 * 
	 * @param oxygen
	 *            The oxygen of the person
	 * @param systolic
	 *            The systolic of the person (top of blood pressure)
	 * @param diastolic
	 *            The diastolic of the person (bottom of blood pressure)
	 * @param temperature
	 *            The temperature of the person
	 * @param glucose
	 *            The glucose ov the person
	 * @param heartRate
	 *            The heart-rate of the person
	 */
	public Person(int oxygen, int systolic, int diastolic, float temperature, int glucose, int heartRate) {
		this.bloodOxygen = new BloodOxygen(oxygen);
		this.bloodPressure = new BloodPressure(systolic, diastolic);
		this.bodyTemperature = new BodyTemperature(temperature);
		this.glucoseLevel = new GlucoseLevel(glucose);
		this.heartRate = new HeartRate(heartRate);
	}

	/**
	 * Check the health of the person. Generate a single string to send to
	 * another service.
	 * 
	 * @return The vital signs as normal/low/high. If low or high, the number is
	 *         sent as well.
	 */
	public String checkHealth() {
		// to send to hospital
		String health = "";
		// health status variables
		String bloodOxygenStatus = this.bloodOxygen.getStatus();
		String bloodPressureStatus = this.bloodPressure.getStatus();
		String bodyTemperatureStatus = this.bodyTemperature.getStatus();
		String glucoseLevelStatus = this.glucoseLevel.getStatus();
		String heartRateStatus = this.heartRate.getStatus();
		// health value variables
		int oxygen = this.bloodOxygen.getActualBloodOxygen();
		int[] pressure = this.bloodPressure.getActualBloodPressure();
		float temperature = this.bodyTemperature.getActualBodyTemperature();
		int glucose = this.glucoseLevel.getActualGlucoseLevel();
		int heart = this.heartRate.getActualHeartRate();

		// check blood oxygen
		if (bloodOxygenStatus.equals("normal")) {
			// if blood oxygen is normal, report normal (no value)
			health += "normal, ";
		} else if (bloodOxygenStatus.equals("low")) {
			// if blood oxygen is low, check for error. if no error, report low
			// and value
			if (oxygen < 0) {
				health += ("error, ");
			} else {
				health += ("low " + oxygen + ", ");
			}
		} else if (bloodOxygenStatus.equals("high")) {
			// if blood oxygen is high, check for error. if no error, report
			// high and value
			if (oxygen > 100) {
				health += ("error, ");
			} else {
				health += ("high " + oxygen + ", ");
			}
		}
		// check blood pressure
		if (bloodPressureStatus.equals("normal/normal")) {
			// if blood pressure is normal, report normal (no value)
			health += "normal, ";
		} else if (bloodPressureStatus.equals("normal/low")) {
			// if diastolic is low, check for error. if no error, report
			// low and value
			if (pressure[1] < 40) {
				health += ("error, ");
			} else {
				health += ("low " + pressure[0] + "/" + pressure[1] + ", ");
			}
		} else if (bloodPressureStatus.equals("normal/high")) {
			// if diastolic is high, check for error. if no error, report high
			// and value
			if (pressure[1] > 100) {
				health += ("error, ");
			} else {
				health += ("high " + pressure[0] + "/" + pressure[1] + ", ");
			}
		} else if (bloodPressureStatus.equals("low/normal")) {
			// if systolic is low, check for error. if no error, report low and
			// value
			if (pressure[0] < 70) {
				health += ("error, ");
			} else {
				health += ("low " + pressure[0] + "/" + pressure[1] + ", ");
			}
		} else if (bloodPressureStatus.equals("low/low")) {
			// if systolic and diastolic are low, check for error. if no error,
			// report low and value
			if (pressure[0] < 70 || pressure[1] < 40) {
				health += ("error, ");
			} else {
				health += ("low " + pressure[0] + "/" + pressure[1] + ", ");
			}
		} else if (bloodPressureStatus.equals("low/high")) {
			// if systolic is low and diastolic is high, check for error. if no
			// error, report high and value
			if (pressure[0] < 70 || pressure[1] > 100) {
				health += ("error, ");
			} else {
				health += ("high " + pressure[0] + "/" + pressure[1] + ", ");
			}
		} else if (bloodPressureStatus.equals("high/normal")) {
			// if systolic is high, check for error. if no error, report high
			// and value
			if (pressure[0] > 190) {
				health += ("error, ");
			} else {
				health += ("high " + pressure[0] + "/" + pressure[1] + ", ");
			}
		} else if (bloodPressureStatus.equals("high/low")) {
			// if systolic is high and diastolic is low, check for error. if no
			// error, report high and value
			if (pressure[0] > 190 || pressure[1] < 40) {
				health += ("error, ");
			} else {
				health += ("high " + pressure[0] + "/" + pressure[1] + ", ");
			}
		} else if (bloodPressureStatus.equals("high/high")) {
			// if systolic and diastolic are high, check for error. if no error,
			// report high and value
			if (pressure[0] > 190 || pressure[1] > 100) {
				health += ("error, ");
			} else {
				health += ("high " + pressure[0] + "/" + pressure[1] + ", ");
			}
		}
		// check body temperature
		if (bodyTemperatureStatus.equals("normal")) {
			// if temperature is normal, report normal (no value)
			health += "normal, ";
		} else if (bodyTemperatureStatus.equals("low")) {
			// if temperature is low, check for error. if no error, report low
			// and value
			if (temperature < 0) {
				health += ("error, ");
			} else {
				health += ("low " + temperature + ", ");
			}
		} else if (bodyTemperatureStatus.equals("high")) {
			// if temperature is high, check for error. if no error, report high
			// and value
			if (temperature > 105) {
				health += ("error, ");
			} else {
				health += ("high" + temperature + ", ");
			}
		}
		// check glucose level
		if (glucoseLevelStatus.equals("normal")) {
			// if glucose is normal, report normal (no value)
			health += "normal, ";
		} else if (glucoseLevelStatus.equals("low")) {
			// if glucose is low, check for error. if no error, report low and
			// value
			if (glucose < 0) {
				health += ("error, ");
			} else {
				health += ("low " + glucose + ", ");
			}
		} else if (glucoseLevelStatus.equals("high")) {
			// if glucose is high, check for error. if no error, report high and
			// value
			if (glucose > 200) {
				health += ("error, ");
			} else {
				health += ("high " + glucose + ", ");
			}
		}
		// check heart rate
		if (heartRateStatus.equals("normal")) {
			// if heart-rate is normal, report normal (no value)
			health += "normal";
		} else if (heartRateStatus.equals("low")) {
			// if heart-rate is low, check for error. if no error, report low
			// and value
			if (heart < 0) {
				health += "error";
			} else {
				health += ("low " + heart);
			}
		} else if (heartRateStatus.equals("high")) {
			// if heart-rate is high, check for error. if no error, report high
			// and value
			if (heart > 200) {
				health += "error";
			} else {
				health += ("high " + heart);
			}
		}

		// return the full string of all health recordings
		return health;
	}

}
