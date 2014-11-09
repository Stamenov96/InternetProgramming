package org.elsys.ip.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HttpGetExample {

	private static final String HTTP_METHOD_GET = "GET";
	private static final int HTTP_PORT = 80;
	private static final String PROTOCOL_VERSION = "HTTP/1.1";
	private static final Object LOCATION_TAG = "location";

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		

	      /*Scanner in = new Scanner(System.in);
	      System.out.println("Enter a HOST:");
	      final String inputhost = in.nextLine();
	      System.out.println("Enter a PATH:");
	      final String inputpath = in.nextLine();
	      */
			final String inputhost = "google.bg";
			final String inputpath = "/index.html";
	      
	      requests(inputhost,inputpath);
		
	}
	public static void requests(final String host,final String path) throws UnknownHostException, IOException{
		
		final HttpGetExample example = new HttpGetExample();
		final CharacterHttpResponse response = example.createRequest(host, HTTP_METHOD_GET, path);

		// System.out.println(new String(response.getStatusLine()));
		final String StatusLine = new String(response.getStatusLine());
		System.out.println(StatusLine);

		final String[] splitted = StatusLine.split(" ", 3);
		// System.out.println("jkashgdukhasd"+splitted[1]+"uashdouisa");
		// splitted[1] = 301

		for (HttpHeader next : response.getHeaders()) {
			// System.out.println("AHHAHAHAAHHA"+next+"UJHSAUHUSADHUIOA");
			if (splitted[1].equalsIgnoreCase("301")) {
				//System.out.println("HOST "+host+" PATH "+path);
				// System.out.println("IT WORKS");
				if (next.getName().toLowerCase().equals(LOCATION_TAG)){
					//System.out.println(next.getName() + next.getValue());
					URL loc = new URL(next.getValue());
					final String getHost = loc.getHost();
					final String getPath = loc.getPath();
					//System.out.println(getHost);
					//System.out.println(getPath);
					
					//System.out.println();
					
					requests(getHost, getPath);
					//System.out.println("host = " + loc.getHost());
			        //System.out.println("port = " + loc.getPort());
			        //System.out.println("path = " + loc.getPath());
					
					
				}
				
			}
			System.out.printf("%s: %s\n", next.getName(), next.getValue());
		}
		System.out.println(new String(response.getBody()));
		// or using for
		// for (char next : response.getBody()) {
		// System.out.print(next);
		// }
	}

	public CharacterHttpResponse createRequest(String host, String method,
			String path) throws UnknownHostException, IOException {
		final Socket clientSocket = new Socket(host, HTTP_PORT);
		try {
			final InputStream inputStream = clientSocket.getInputStream();
			final OutputStream outputStream = clientSocket.getOutputStream();

			final InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream);
			final BufferedReader in = new BufferedReader(inputStreamReader);
			final PrintWriter out = new PrintWriter(outputStream);

			writeRequest(out, host, method, path);
			out.flush();

			return parseResponse(in);
		} finally {
			// we should ALWAYS close sockets!
			clientSocket.close();
		}

	}

	private CharacterHttpResponse parseResponse(BufferedReader in)
			throws IOException {
		final CharacterHttpResponse result = new CharacterHttpResponse();

		// reading status line
		result.setStatusLine(in.readLine());

		// reading headers until new line - this is marker for end of headers
		String next;
		while (!(next = in.readLine()).equals("")) {
			// System.out.println("HAHAHHAHAHAH"+next+"HAHAHAHHA");
			result.getHeaders().add(HttpHeader.createFromHeaderLine(next));
		}

		// TODO chunked transfer-encoding is not supported!

		// reading body - we already know how many bytes the body is
		// (from the content-length header line)
		in.read(result.getBody());
		return result;
	}

	private void writeRequest(PrintWriter out, String host, String method,
			String path) {
		out.printf("%s %s %s\n", method, path, PROTOCOL_VERSION);
		out.printf("Host: %s\n", host);
		// System.out.println("METHOD PATH PROTOCOLVER HOST "+method+" "+path+" "+PROTOCOL_VERSION+" "+host);
		out.printf("\n");
	}

}
