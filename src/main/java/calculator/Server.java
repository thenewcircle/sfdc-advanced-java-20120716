package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10000);
			try {
				while (true) {
					Socket client = server.accept();
					try {
						BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
						try {
							System.out.println(in.readLine());
						} finally {
							in.close();
						}
					} finally {
						client.close();
					}
				}
			} finally {
				server.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
