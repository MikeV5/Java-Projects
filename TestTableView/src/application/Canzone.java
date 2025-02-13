package application;

public class Canzone {
	
	String nomeCanzone;
	String nomeAutore;
	String dataCanzone;
	

	public Canzone(String nomeCanzone, String nomeAutore, String dataCanzone) {
		super();
		this.nomeCanzone = nomeCanzone;
		this.nomeAutore = nomeAutore;
		this.dataCanzone = dataCanzone;
	}
	
	public Canzone(String nomeCanzone) {
		this.nomeCanzone = nomeCanzone;
	}

	public String getNomeAutore() {
		return nomeAutore;
	}

	public void setNomeAutore(String nomeAutore) {
		this.nomeAutore = nomeAutore;
	}

	public String getDataCanzone() {
		return dataCanzone;
	}

	public void setDataCanzone(String dataCanzone) {
		this.dataCanzone = dataCanzone;
	}

	public String getNomeCanzone() {
		return nomeCanzone;
	}

	public void setNomeCanzone(String nomeCanzone) {
		this.nomeCanzone = nomeCanzone;
	}

}
