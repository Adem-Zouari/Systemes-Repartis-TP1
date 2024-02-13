import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket clientSocket =null;
        try {
 
            clientSocket = new DatagramSocket();
            
            String message = "Hello, Server!";
            byte[] sendData = message.getBytes();
            
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getLocalHost(), 1903);
            
            clientSocket.send(sendPacket);
            
            System.out.println("Message sent to server: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) {
                clientSocket.close();
            }
        }
    }
}