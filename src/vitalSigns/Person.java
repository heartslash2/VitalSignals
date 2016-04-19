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

	public Person(int oxygen, int systolic, int diastolic, float temperature,
			int glucose, int heartRate) {
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
		// System.out.println(bloodPressureStatus);
		// check blood oxygen
		if (bloodOxygenStatus.equals("normal")) {
			health += "normal, ";
		} else if (bloodOxygenStatus.equals("low")) {
			health += ("low " + this.bloodOxygen.getActualBloodOxygen() + ", ");
		} else if (bloodOxygenStatus.equals("high")) {
			health += ("high " + this.bloodOxygen.getActualBloodOxygen() + ", ");
		}
		// check blood pressure
		if (bloodPressureStatus.equals("normal/normal")) {
			health += "normal, ";
		} else if (bloodPressureStatus.equals("normal/low")) {
			health += ("low " + this.bloodPressure.getActualBloodPressure()[0]
					+ "/" + this.bloodPressure.getActualBloodPressure()[1] + ", ");
		} else if (bloodPressureStatus.equals("normal/high")) {
			health += ("high " + this.bloodPressure.getActualBloodPressure()[0]
					+ "/" + this.bloodPressure.getActualBloodPressure()[1] + ", ");
		} else if (bloodPressureStatus.equals("low/normal")) {
			health += ("low " + this.bloodPressure.getActualBloodPressure()[0]
					+ "/" + this.bloodPressure.getActualBloodPressure()[1] + ", ");
		} else if (bloodPressureStatus.equals("low/low")) {
			health += ("low " + this.bloodPressure.getActualBloodPressure()[0]
					+ "/" + this.bloodPressure.getActualBloodPressure()[1] + ", ");
		} else if (bloodPressureStatus.equals("low/high")) {
			health += ("high " + this.bloodPressure.getActualBloodPressure()[0]
					+ "/" + this.bloodPressure.getActualBloodPressure()[1] + ", ");
		} else if (bloodPressureStatus.equals("high/normal")) {
			health += ("high " + this.bloodPressure.getActualBloodPressure()[0]
					+ "/" + this.bloodPressure.getActualBloodPressure()[1] + ", ");
		} else if (bloodPressureStatus.equals("high/low")) {
			health += ("high " + this.bloodPressure.getActualBloodPressure()[0]
					+ "/" + this.bloodPressure.getActualBloodPressure()[1] + ", ");
		} else if (bloodPressureStatus.equals("high/high")) {
			health += ("high " + this.bloodPressure.getActualBloodPressure()[0]
					+ "/" + this.bloodPressure.getActualBloodPressure()[1] + ", ");
		}
		// check body temperature
		if (bodyTemperatureStatus.equals("normal")) {
			health += "normal, ";
		} else if (bodyTemperatureStatus.equals("low")) {
			health += ("low " + this.bodyTemperature.getActualBodyTemperature() + ", ");
		} else if (bodyTemperatureStatus.equals("high")) {
			health += ("high" + this.bodyTemperature.getActualBodyTemperature() + ", ");
		}
		// check glucose level
		if (glucoseLevelStatus.equals("normal")) {
			health += "normal, ";
		} else if (glucoseLevelStatus.equals("low")) {
			health += ("low " + this.glucoseLevel.getActualGlucoseLevel() + ", ");
		} else if (glucoseLevelStatus.equals("high")) {
			health += ("high " + this.glucoseLevel.getActualGlucoseLevel() + ", ");
		}
		// check heart rate
		if (heartRateStatus.equals("normal")) {
			health += "normal$";
		} else if (heartRateStatus.equals("low")) {
			health += ("low " + this.heartRate.getActualHeartRate() + "$");
		} else if (heartRateStatus.equals("high")) {
			health += ("high " + this.heartRate.getActualHeartRate() + "$");
		}

		return health;
	}

}
