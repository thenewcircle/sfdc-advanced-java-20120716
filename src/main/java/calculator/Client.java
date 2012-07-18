package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				String expression = stdin.readLine();
				Socket server = new Socket(InetAddress.getLocalHost(), 10000);
				try {
					PrintStream out = new PrintStream(server.getOutputStream());
					try {
						out.println(expression);
						out.flush();
						ObjectInputStream in = new ObjectInputStream(server.getInputStream());
						try {
							Expression expr = (Expression) in.readObject();
							System.out.println(expr + " = " + expr.value());
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} finally {
							in.close();
						}
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
