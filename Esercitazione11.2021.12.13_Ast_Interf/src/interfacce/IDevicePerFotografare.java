package interfacce;

public interface IDevicePerFotografare extends IDevice{
	
	 Foto scattaFoto();
	 boolean salvaFoto(Foto f) throws NoSpaceException;

}
