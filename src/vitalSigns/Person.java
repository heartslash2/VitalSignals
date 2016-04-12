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
	
}
