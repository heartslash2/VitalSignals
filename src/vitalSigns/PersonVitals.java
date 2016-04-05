package vitalSigns;

public class PersonVitals {
	private int bloodOxygenMin;
	private int bloodOxygenMax;
	private int bloodPressureMin;
	private int bloodPressureMax;
	private int heartRateMin;
	private int heartRateMax;
//	private int ;
	
	public PersonVitals() {
		this(95, 100, 1, 1, 1, 1);
	}

	public PersonVitals(
			int bloodOxygenMin, 
			int bloodOxygenMax,
			int bloodPressureMin, 
			int bloodPressureMax, 
			int heartRateMin,
			int heartRateMax) {
		this.bloodOxygenMin = bloodOxygenMin;
		this.bloodOxygenMax = bloodOxygenMax;
		this.bloodPressureMin = bloodPressureMin;
		this.bloodPressureMax = bloodPressureMax;
		this.heartRateMin = heartRateMin;
		this.heartRateMax = heartRateMax;
	}

	public int getBloodOxygenMin() {
		return bloodOxygenMin;
	}

	public void setBloodOxygenMin(int bloodOxygenMin) {
		this.bloodOxygenMin = bloodOxygenMin;
	}

	public int getBloodOxygenMax() {
		return bloodOxygenMax;
	}

	public void setBloodOxygenMax(int bloodOxygenMax) {
		this.bloodOxygenMax = bloodOxygenMax;
	}

	public int getBloodPressureMin() {
		return bloodPressureMin;
	}

	public void setBloodPressureMin(int bloodPressureMin) {
		this.bloodPressureMin = bloodPressureMin;
	}

	public int getBloodPressureMax() {
		return bloodPressureMax;
	}

	public void setBloodPressureMax(int bloodPressureMax) {
		this.bloodPressureMax = bloodPressureMax;
	}

	public int getHeartRateMin() {
		return heartRateMin;
	}

	public void setHeartRateMin(int heartRateMin) {
		this.heartRateMin = heartRateMin;
	}

	public int getHeartRateMax() {
		return heartRateMax;
	}

	public void setHeartRateMax(int heartRateMax) {
		this.heartRateMax = heartRateMax;
	}
}
