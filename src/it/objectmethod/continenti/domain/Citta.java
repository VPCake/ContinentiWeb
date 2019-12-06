package it.objectmethod.continenti.domain;

public class Citta {
	private int Id;
	private String name;
	private String countryCode;
	private int population;

	public int getId() {
		return Id;
	}

	public void setId(int iD) {
		Id = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

}
