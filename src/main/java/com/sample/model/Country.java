package com.sample.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Country {
	
	@Id 
    @Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="country_name")
    private String countryName;
    @Column(name="capital")
    private String countryCapital;

    public Country() {
    }
    public Country(int id, String countryName, String countryCapital) {
        this.id = id;
        this.countryName = countryName;
        this.countryCapital = countryCapital;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }
    @Override
	public String toString() {
		return "Country{" + "id=" + id + ", countryName='" + countryName + '\'' + ", countryCapital='" + countryCapital
				+ '\'' + '}';
	}
}

