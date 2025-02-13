package JavaCourse;

public class ProvaFrazioneCustom {

	public static void main(String[] args) {

		FrazioneCustom fc1 = new FrazioneCustom(1, 2);
		FrazioneCustom fc2 = new FrazioneCustom(2, 3);

		FrazioneCustom molt = fc1.per(fc2);
		
		System.out.println(molt.toString());
		System.out.println(fc1.equals(fc2)); //false anche se hanno lo steso nume den - devono puntare alla stessa zona di memoria (true se fc1= fc2)
		/*************************************************/
		Object fc1 = new FrazioneCustom(1, 2);
		Object fc2 = new FrazioneCustom(2, 3);
		System.out.println(fc1.equals(fc2)); //
		
		
	}

}
