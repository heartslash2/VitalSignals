package vitalSigns;

public class Person {

	private BloodOxygen bloodOxygen;
	private BloodPressure bloodPressure;
	private BodyTemperature bodyTemperature;
	private GlucoseLevel glucoseLevel;
	private HeartRate heartRate;

	public Person() {
		bloodOxygen = new BloodOxygen();
		bloodPressure = new BloodPressure();
		bodyTemperature = new BodyTemperature();
		glucoseLevel = new GlucoseLevel();
		heartRate = new HeartRate();
	}

	public Person(int oxygen, int systolic, int diastolic, float temperature, int glucose, int heartRate) {
		this.bloodOxygen = new BloodOxygen(oxygen);
		this.bloodPressure = new BloodPressure(systolic, diastolic);
		this.bodyTemperature = new BodyTemperature(temperature);
		this.glucoseLevel = new GlucoseLevel(glucose);
		this.heartRate = new HeartRate(heartRate);
	}

	public String checkHealth() {
		// to send to hospital
		String health = "";
		// health variables
		String bloodOxygenStatus = this.bloodOxygen.getStatus();
		String bloodPressureStatus = this.bloodPressure.getStatus();
		String bodyTemperatureStatus = this.bodyTemperature.getStatus();
		String glucoseLevelStatus = this.glucoseLevel.getStatus();
		String heartRateStatus = this.heartRate.getStatus();

		int oxygen = this.bloodOxygen.getActualBloodOxygen();
		int[] pressure = this.bloodPressure.getActualBloodPressure();
		float temperature = this.bodyTemperature.getActualBodyTemperature();
		int glucose = this.glucoseLevel.getActualGlucoseLevel();
		int heart = this.heartRate.getActualHeartRate();

		// check blood oxygen
		if (bloodOxygenStatus.equals("normal")) {
			health += "normal, ";
		} else if (bloodOxygenStatus.equals("low")) {
			if (oxygen < 0) {
				health += ("error, ");
			} else {
				health += ("low " + oxygen + ", ");
			}
		} else if (bloodOxygenStatus.equals("high")) {
			if (oxygen > 100) {
				health += ("error, ");
			} else {
				health += ("high " + oxygen + ", ");
			}
		}
		// check blood pressure
		if (bloodPressureStatus.equals("normal/normal")) {
			health += "normal, ";
		} else if (bloodPressureStatus.equals("normal/low")) {
			if (pressure[1] < 40) {
				health += ("error, ");
			} else {
				health += ("low " + pressure[0] + "/" + pressure[1] + ", ");
			}
		} else if (bloodPressureStatus.equals("normal/high")) {
			if (pressure[1] > 100) {
				health += ("error, ");
			} else {
				health += ("high " + pressure[0] + "/" + pressure[1] + ", ");
			}
		} else if (bloodPressureStatus.equals("low/normal")) {
			if (pressure[0] < 70) {
				health += ("error, ");
			} else {
				health += ("low " + pressure[0] + "/" + pressure[1] + ", ");
			}
		} else if (bloodPressureStatus.equals("low/low")) {
			if (pressure[0] < 70 || pressure[1] < 40) {
				health += ("error, ");
			} else {
				health += ("low " + pressure[0] + "/" + pressure[1] + ", ");
			}
		} else if (bloodPressureStatus.equals("low/high")) {
			if (pressure[0] < 70 || pressure[1] > 100) {
				health += ("error, ");
			} else {
				health += ("high " + pressure[0] + "/" + pressure[1] + ", ");
			}
		} else if (bloodPressureStatus.equals("high/normal")) {
			if (pressure[0] > 190) {
				health += ("error, ");
			} else {
				health += ("high " + pressure[0] + "/" + pressure[1] + ", ");
			}
		} else if (bloodPressureStatus.equals("high/low")) {
			if (pressure[0] > 190 || pressure[1] < 40) {
				health += ("error, ");
			} else {
				health += ("high " + pressure[0] + "/" + pressure[1] + ", ");
			}
		} else if (bloodPressureStatus.equals("high/high")) {
			if (pressure[0] > 190 || pressure[1] > 100) {
				health += ("error, ");
			} else {
				health += ("high " + pressure[0] + "/" + pressure[1] + ", ");
			}
		}
		// check body temperature
		if (bodyTemperatureStatus.equals("normal")) {
			health += "normal, ";
		} else if (bodyTemperatureStatus.equals("low")) {
			if (temperature < 0) {
				health += ("error, ");
			} else {
				health += ("low " + temperature + ", ");
			}
		} else if (bodyTemperatureStatus.equals("high")) {
			if (temperature > 105) {
				health += ("error, ");
			} else {
				health += ("high" + temperature + ", ");
			}
		}
		// check glucose level
		if (glucoseLevelStatus.equals("normal")) {
			health += "normal, ";
		} else if (glucoseLevelStatus.equals("low")) {
			if (glucose < 0) {
				health += ("error, ");
			} else {
				health += ("low " + glucose + ", ");
			}
		} else if (glucoseLevelStatus.equals("high")) {
			if (glucose > 200) {
				health += ("error, ");
			} else {
				health += ("high " + glucose + ", ");
			}
		}
		// check heart rate
		if (heartRateStatus.equals("normal")) {
			health += "normal";
		} else if (heartRateStatus.equals("low")) {
			if (heart < 0) {
				health += "error";
			} else {
				health += ("low " + heart + "");
			}
		} else if (heartRateStatus.equals("high")) {
			if (heart > 200) {
				health += "error";
			} else {
				health += ("high " + this.heartRate.getActualHeartRate() + "");
			}
		}

		return health;
	}

}
