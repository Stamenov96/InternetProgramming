package org.elsys.internetprogramming.samplejava;

public class SampleJava {


	public static void main(String[] args) {

		int a;
		int b=2;
		a=7;
		
		String str1="abc";
		String str2="abcd";
		String str3="abc";
		
		
		for(int i=0;i<a;i++){
			if (i%2==0 & i!=0){
				System.out.print(i + "chetno");
				System.out.print(" B"+b+" ");
			}
		}
		System.out.print("\n");
		System.out.print(str1==str2);
		System.out.print("\n");
		System.out.print(str1.equals(str2));
		System.out.print("\n");
		System.out.print(str1==str3);
		System.out.print("\n");
		System.out.print(str1.equals(str3));
	
		Footballteam Levski = new Footballteam();
		
		Levski.setCountry("Bulgaria");
		Levski.setName("PFK Levski Sofia");
		Levski.setYear(1914);
		Levski.setTrophies(26);
		Levski.howold();
		
		System.out.print("My favourite team form "+Levski.getCountry()+" e "+Levski.getName()
				+".It is established in "+Levski.getYear()+" and it is a champion of the country "
				+Levski.getTrophies()+" times.");
		
		
	
	}	
}
