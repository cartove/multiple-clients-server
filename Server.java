import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server  implements Runnable {
    
    private static Socket cSocket;
    private static ServerSocket serverSocket;
    private static BufferedReader in;

   
    public Server(Socket clientSocket) {
        Server.cSocket = clientSocket;
    }

    public static void main(String args[]) throws IOException {
        serverSocket = new ServerSocket(1412);
        System.out.println("Listening");
    
        while (true) {
            Socket sock = serverSocket.accept();
            System.out.println("Connected");
           
            new Thread(new Server(sock)).start();
        }
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(
                    cSocket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        String inputLine;
        try {
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
