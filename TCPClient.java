import java.io.*;
import java.net.*;

public class TCPClient{
    public static void main(String[] args) {
        Socket clientSocket = null;
        try {

            clientSocket = new Socket("localhost", 1903);

            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            outToServer.println("Hello, Server!");

            String serverResponse = inFromServer.readLine();

            System.out.println("Server response: " + serverResponse);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (clientSocket != null) {
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
