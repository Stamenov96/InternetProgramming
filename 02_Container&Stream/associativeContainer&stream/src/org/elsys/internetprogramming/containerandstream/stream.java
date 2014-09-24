package org.elsys.internetprogramming.containerandstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class stream {

	
	public static void main(String[] args) throws IOException {
	
		final String line = getLine();
		System.out.printf(line.toUpperCase());
	}
	
	private static String getLine() throws IOException {
		final InputStream input = System.in;
		final InputStreamReader inputStreamReader = new InputStreamReader(input);
		final BufferedReader reader = new BufferedReader(inputStreamReader);
		
		return reader.readLine();
	}

	

}
