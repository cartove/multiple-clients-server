import java.io.*;
import java.net.*;

public class Client {
	public String hostName = "";
	public int portNumber = 0;
	private Socket echoSocket;
	private PrintWriter out;

	public Client(String hostname, int port) throws IOException {
		this.hostName = hostname;
		this.portNumber = port;
		this.echoSocket = new Socket(hostName, portNumber);
		this.out = new PrintWriter(echoSocket.getOutputStream(), true);
	}

	public void send(String message) {
		out.println(message);
	}

	public void close() {
		out.close();
	}
}
