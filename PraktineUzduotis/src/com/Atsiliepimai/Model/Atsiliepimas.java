package com.Atsiliepimai.Model;

public class Atsiliepimas {
	private int id ;
	private String vardas;
	private String miestas; 
	private String pastas;
	private String atsiliepimas;
	
	public Atsiliepimas() {
	}

	public Atsiliepimas(int id, String miestas, String vardas, String pastas, String atsiliepimas) {
		this.id = id;
		this.vardas = vardas;
		this.miestas = miestas;
		this.pastas = pastas;
		this.atsiliepimas = atsiliepimas;
	}
	
	public Atsiliepimas(String miestas, String vardas, String pastas, String atsiliepimas) {
		this.vardas = vardas;
		this.miestas = miestas;
		this.pastas = pastas;
		this.atsiliepimas = atsiliepimas;
	}
	
	public int getId() {
		return id;
	}

	public String getMiestas() {
		return miestas;
	}

	public void setMiestas(String miestas) {
		this.miestas = miestas;
	}

	public String getVardas() {
		return vardas;
	}

	public void setVardas(String vardas) {
		this.vardas = vardas;
	}

	public String getPastas() {
		return pastas;
	}

	public void setPastas(String pastas) {
		this.pastas = pastas;
	}

	public String getAtsiliepimas() {
		return atsiliepimas;
	}

	public void setAtsiliepimas(String atsiliepimas) {
		this.atsiliepimas = atsiliepimas;
	}
}
