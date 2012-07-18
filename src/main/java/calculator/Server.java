package calculator;

import java.io.IOException;
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

						// OTHER STUFF

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
