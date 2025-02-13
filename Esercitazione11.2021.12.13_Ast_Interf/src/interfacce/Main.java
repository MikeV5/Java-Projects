package interfacce;

public class Main {

	public static void main(String[] args) {

		IDevice dev = new Smartphone(3);
		try {
			Foto f = ((IDevicePerFotografare) dev).scattaFoto();
			((IDevicePerFotografare) dev).salvaFoto(f);
		} catch (NoSpaceException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(dev.toString());	}

}
