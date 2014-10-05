package org.elsys.ip.SampleSockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private static final String SERVER = "localhost";
	private final String request;

	public Client(String request) {
		 this.request = request;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter date: ");
		
		final InputStream input = System.in;
		final InputStreamReader inputStreamReader = new InputStreamReader(input);
		final BufferedReader reader = new BufferedReader(inputStreamReader);
		
		final String request = reader.readLine();
		
		final Client client = new Client(request);
		final String response = client.send();
		
		System.out.println("Response from server: "+response);
	}

	private String send() throws UnknownHostException, IOException {
		final Socket clientSocket = new Socket(SERVER, Server.SERVER_PORT);

		final InputStream inputStream = clientSocket .getInputStream();
		final OutputStream outputStream = clientSocket.getOutputStream();
		
		final InputStreamReader inputStreamReader =
			new InputStreamReader(inputStream);
		final BufferedReader in = new BufferedReader(inputStreamReader);
		
		final PrintWriter out = new PrintWriter(outputStream);
		
		out.println(request);

		out.flush();
		
		final String result = in.readLine();
		
		
		clientSocket.close();
		
		return result;
	}

}
