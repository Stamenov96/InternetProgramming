package org.elsys.internetprogramming.samplejava;

public class Footballteam {
	
	String country;
	String name;
	int year;
	int trophies;
	
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTrophies() {
		return trophies;
	}
	public void setTrophies(int trophies) {
		this.trophies = trophies;
	}
	void howold(){
		System.out.print("\n"+(2014-year)+" godini\n");
	}
	
}
