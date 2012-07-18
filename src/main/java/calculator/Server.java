package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
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
							ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
							try {
								out.writeObject(Calculator.parse(in.readLine()));
								out.flush();
							} finally {
								out.close();
							}
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
