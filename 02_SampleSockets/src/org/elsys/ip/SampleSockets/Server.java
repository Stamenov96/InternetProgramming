package org.elsys.ip.SampleSockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
	public static final int SERVER_PORT = 44022;

	private class ClientHandler extends Thread {
		private final Socket clientSocket;

		public ClientHandler(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {
			try {
				handleClient(clientSocket);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		private void handleClient(final Socket clientSocket) throws IOException, ParseException {

				final InputStream inputStream = clientSocket.getInputStream();
				final OutputStream outputStream = clientSocket.getOutputStream();
				
				final InputStreamReader inputStreamReader =
					new InputStreamReader(inputStream);
				final BufferedReader in = new BufferedReader(inputStreamReader);
				
				final PrintWriter out = new PrintWriter(outputStream);
				
				final String readLine = in.readLine();
				final Date dateLine = new SimpleDateFormat("yyyy-MMM-dd").parse(readLine);
				
				final Date date = new Date();
				final long diff=dateLine.getTime()-date.getTime();				
				final long count=diff/1000/60/60/24;
				
				out.println("Count : "+count);
				
				out.flush();
				
				clientSocket.close();
			}
	}

	private boolean started;

	public static void main(String[] args) throws IOException {
		new Server().run();
	}

	public void run() throws IOException {
		started = true;

		final ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

		while (started) {
			final Socket clientSocket = serverSocket.accept();

			new ClientHandler(clientSocket).start();
		}
		serverSocket.close();
	}

}
