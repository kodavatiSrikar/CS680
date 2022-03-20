package edu.umb.cs680.hw02;

public final class Singleton {
	private static Singleton instance;
	public String token_owner;
	
	private Singleton(String value) {
		this.token_owner= value;
		
		
	}
	
	public static Singleton getInstance(String value) {
		if (instance == null) {
			instance=new Singleton(value);
			
		}
		return instance;
	}
	

		
		
	
	

}
