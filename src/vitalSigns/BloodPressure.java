package vitalSigns;

/**
 * The <em>BloodPressure</em> class is used to represent a blood pressure
 * sensor.
 * 
 * @author Jonathan McMeans (mcmeans.4@wright.edu)
 */
public class BloodPressure {

	/**
	 * The <em>actualBloodPressure</em> variable used to represent the patient's
	 * blood pressure. This is an int array of size 2, where the first int is
	 * the top of the patient's blood pressure (systolic) and the second int is
	 * the bottom of the patient's blood pressure (diastolic).
	 */
	private int[] actualBloodPressure = new int[2];
	/**
	 * The <em>normalRange</em> array used to represent the range of normal
	 * blood pressure for this sensor. This uses a double array to keep track of
	 * ranges for top (systolic) and bottom (diastolic) values. Set to be a 2x2
	 * array, where the first array (ie [0][x]) is the systolic ranges and the
	 * second array (ie [1][x]) is the diastolic ranges.
	 */
	private int[][] normalRange = new int[2][2];
	/**
	 * The <em>status</em> variable used to represent if the sensor reads that
	 * the blood pressure is too low, normal, or too high.
	 */
	private String status;

	/**
	 * Simulate a blood pressure sensor. This creates a blood pressure in the
	 * range of 75/40 to 160/100 with a normal range of 105/60 to 130/80.
	 */
	public BloodPressure() {
		// (low systolic range, high systolic range, low diastolic range, high
		// diastolic range, low systolic normal, high systolic normal, low
		// diastolic normal, high diastolic normal)
		this(75, 160, 40, 100, 105, 130, 60, 80);
	}

	/**
	 * Simulate a blood pressure sensor. This creates a blood pressure of
	 * <em>systolic</em>/<em>diastolic</em> with normal range of 105/60 to
	 * 130/80.
	 * 
	 * @param systolic
	 *            The top of the blood pressure
	 * @param diastolic
	 *            The bottom of the blood pressure
	 */
	public BloodPressure(int systolic, int diastolic) {
		// set normal range
		this.normalRange[0][0] = 105;
		this.normalRange[0][1] = 130;
		this.normalRange[1][0] = 60;
		this.normalRange[1][1] = 80;
		this.actualBloodPressure[0] = systolic;
		this.actualBloodPressure[1] = diastolic;
		// check if the inpute blood pressure is normal
		isNormal();
	}

	/**
	 * Simulate a blood pressure sensor by passing in minimum and maximum values
	 * for a random number generator to create a random number in the range of
	 * [min, max].<br>
	 * Note that this includes both min and max as possible values.
	 * 
	 * @param actualSystolicMinimum
	 *            The low range for the random number generator top number
	 * @param actualSystolicMaximum
	 *            The high range for the random number generator top number
	 * @param actualDiastolicMinimum
	 *            The low range for the random number generator bottom number
	 * @param actualDiastolicMaximum
	 *            The high range for the random number geneartor bottom number
	 * @param normalRangeSystolicMinimum
	 *            The low normal top number
	 * @param normalRangeSystolicMaximum
	 *            The high normal top number
	 * @param normalRangeDiastolicMinimum
	 *            The low normal bottom number
	 * @param normalRangeDiastolicMaximum
	 *            The high normal bottom number
	 */
	public BloodPressure(int actualSystolicMinimum, int actualSystolicMaximum, int actualDiastolicMinimum,
			int actualDiastolicMaximum, int normalRangeSystolicMinimum, int normalRangeSystolicMaximum,
			int normalRangeDiastolicMinimum, int normalRangeDiastolicMaximum) {
		// set normal range
		int[] rangeMinimum = { normalRangeSystolicMinimum, normalRangeDiastolicMinimum };
		this.normalRange[0] = rangeMinimum;
		int[] rangeMaximum = { normalRangeSystolicMaximum, normalRangeDiastolicMaximum };
		this.normalRange[1] = rangeMaximum;
		this.actualBloodPressure[0] = (int) ((Math.random() * (actualSystolicMaximum - actualSystolicMinimum))
				+ actualSystolicMinimum);
		this.actualBloodPressure[1] = (int) ((Math.random() * (actualDiastolicMaximum - actualDiastolicMinimum))
				+ actualDiastolicMinimum);
		// check if simulated bloodPressure is in normal range
		isNormal();
	}

	/**
	 * This method will determine if the <em>actualBloodPressure</em> is inside
	 * the <em>normalRange</em> or if the <em>actualBloodPressure</em> is too
	 * high or low. There is no return; instead, this method sets the status
	 * value to "x/y", where x is one of "normal", "low", or "high" and y is
	 * also one of "normal", "low", or "high".
	 */
	private void isNormal() {
		// is systolic normal?
		if (actualBloodPressure[0] >= normalRange[0][0] && actualBloodPressure[0] <= normalRange[1][0]) {
			setStatus("normal/");
			// is systolic low?
		} else if (actualBloodPressure[0] < normalRange[0][0]) {
			setStatus("low/");
			// is systolic high?
		} else if (actualBloodPressure[0] > normalRange[1][0]) {
			setStatus("high/");
		}
		// is diastolic normal?
		if (actualBloodPressure[1] >= normalRange[0][1] && actualBloodPressure[1] <= normalRange[1][1]) {
			setStatus(getStatus() + "normal");
			// is diastolic low?
		} else if (actualBloodPressure[1] < normalRange[0][1]) {
			setStatus(getStatus() + "low");
			// is diastolic high?
		} else if (actualBloodPressure[1] > normalRange[1][1]) {
			setStatus(getStatus() + "high");
		}
	}

	/**
	 * Setter for <em>actualBloodPressure</em>
	 * 
	 * @param bloodPressure
	 *            The reading of the blood pressure sensor
	 */
	public void setActualBloodPressure(int[] bloodPressure) {
		this.actualBloodPressure = bloodPressure;
	}

	/**
	 * Getter for <em>actualBloodPressure</em>
	 * 
	 * @return <em>actualBloodPressure</em> the reading of the blood pressure
	 *         sensor
	 */
	public int[] getActualBloodPressure() {
		return actualBloodPressure;
	}

	/**
	 * Setter for <em>status</em>
	 * 
	 * @param status
	 *            the health status normal/low/high
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Getter for <em>status</em>
	 * 
	 * @return <em>status</em> the health status normal/low/high
	 */
	public String getStatus() {
		return status;
	}

}
