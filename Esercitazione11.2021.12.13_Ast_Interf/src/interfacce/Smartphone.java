package interfacce;

import java.util.Arrays;

public class Smartphone implements IDevicePerTelefonare, IDevicePerFotografare {

	private Foto[] galleria;

	public Smartphone(int maxFoto) {
		galleria = new Foto[maxFoto];

	}

	@Override
	public void start() {
		System.out.println("ciao");
	}

	@Override
	public void stop() {
		System.out.println("ciao");
	}

	@Override
	public Foto scattaFoto() {
		Foto f = new Foto(String.valueOf(System.currentTimeMillis()));
		System.out.println(f);
		return f;
	}

	@Override
	public boolean salvaFoto(Foto f) throws NoSpaceException {

		for (int i = 0; i < galleria.length; i++) {
			if (galleria[i] == null) {
				galleria[i] = f;
				return true;
			}
		}

		throw new NoSpaceException();

	}

	@Override
	public boolean chiama(long numero) {
		if (numero > 0)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "Smartphone [galleria=" + Arrays.toString(galleria) + "]";
	}
	


}
