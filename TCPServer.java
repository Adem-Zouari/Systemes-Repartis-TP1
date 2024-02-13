import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
       
            serverSocket = new ServerSocket(1903);

            while (true) {
                System.out.println("Server is running and waiting for a client...");
        
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client is connected");
       
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = inFromClient.readLine();

                System.out.println("Received from client: " + clientMessage);

                outToClient.println("Message received by server: " + clientMessage);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}