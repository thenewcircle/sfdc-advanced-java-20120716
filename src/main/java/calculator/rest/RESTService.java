package calculator.rest;

import java.io.Closeable;
import java.io.IOException;

import com.sun.jersey.simple.container.SimpleServerFactory;

public class RESTService {

	public static void main(String[] args) {
		try {
			Closeable server = SimpleServerFactory.create("http://localhost:8080");
			System.in.read();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
