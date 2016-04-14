package vitalSigns;

public class BloodPressure {

	private int[] actualBloodPressure;
	private int[][] validRange;
	private String status;

	public BloodPressure() {
		// http://www.bloodpressureuk.org/BloodPressureandyou/Thebasics/Bloodpressurechart
		this(70, 190, 40, 100, 90, 120, 60, 80);
	}

	public BloodPressure(int actualSystolicMinimum, int actualSystolicMaximum,
			int actualDiastolicMinimum, int actualDiastolicMaximum,
			int validRangeSystolicMinimum, int validRangeSystolicMaximum,
			int validRangeDiastolicMinimum, int validRangeDiastolicMaximum) {
		int[] rangeMinimum = { validRangeSystolicMinimum,
				validRangeDiastolicMinimum };
		this.validRange[0] = rangeMinimum;
		int[] rangeMaximum = { validRangeSystolicMaximum,
				validRangeDiastolicMaximum };
		this.validRange[1] = rangeMaximum;
		this.actualBloodPressure[0] = (int) ((Math.random() * 
				(actualSystolicMaximum - actualSystolicMinimum)) + actualSystolicMinimum);
		this.actualBloodPressure[1] = (int) ((Math.random() * 
				(actualDiastolicMaximum - actualDiastolicMinimum)) + actualDiastolicMinimum);
		isValid();
	}

	private void isValid() {
		if (actualBloodPressure[0] > validRange[0][0] && actualBloodPressure[0] < validRange[1][0]) {
			setStatus("normal/");
		} else if (actualBloodPressure[0] < validRange[0][0]) {
			setStatus("low/");
		} else if (actualBloodPressure[0] > validRange[1][0]) {
			setStatus("high/");
		}
		if (actualBloodPressure[1] > validRange[0][1] && actualBloodPressure[0] < validRange[1][1]) {
			setStatus(getStatus()+"normal");
		} else if (actualBloodPressure[1] < validRange[0][1]) {
			setStatus(getStatus()+"low");
		} else if (actualBloodPressure[1] > validRange[1][1]) {
			setStatus(getStatus()+"high");
		}
	}

	public void setActualBloodPressure(int[] bloodPressure) {
		this.actualBloodPressure = bloodPressure;
	}

	public int[] getActualBloodPressure() {
		return actualBloodPressure;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

}
