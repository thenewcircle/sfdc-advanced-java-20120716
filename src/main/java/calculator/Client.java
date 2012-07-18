package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				String expression = in.readLine();
				Socket server = new Socket(InetAddress.getLocalHost(), 10000);
				try {
					PrintStream out = new PrintStream(server.getOutputStream());
					try {
						out.println(expression);
						out.flush();
					} finally {
						out.close();
					}
				} finally {
					server.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
