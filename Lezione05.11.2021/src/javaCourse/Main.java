package javaCourse;

public class Main {

	public static void main(String[] args) {

		FrazioneCustom2 fc1 = new FrazioneCustom2(-2, -5);
		FrazioneCustom2 fc2 = new FrazioneCustom2(32, 128);
		FrazioneCustom2 fc3 = new FrazioneCustom2(32, 0);
		try {
			System.out.println(fc1.toString());
			System.out.println(fc2.toString());
			System.out.println(fc1.isMaggiore(fc2));
		} catch (FrazioneCustomException e) {
			System.err.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.err.println(e.getMessage());
		}
		// try.catch
		// i catch vanno in ordine di gerarchia-es: ArithmeticException -> Exception

	}

}
