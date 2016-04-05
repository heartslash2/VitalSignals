package vitalSigns;

public class VitalSigns {

	public static void main(String[] args) { // start main
		//System.out.println((int)(Math.random()*10));
		String[] vitals = new String[1000];
		for (int i = 0; i < 1000; i++) { // start random generator * 1000
			vitals[i] = Integer.valueOf(i).toString();
		} // end random generator * 1000
	} // end main

} // end class Vital_Signs
