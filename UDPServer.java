import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket serverSocket =null;
        try {

            serverSocket = new DatagramSocket(1903);
            
            byte[] receiveData = new byte[1024];
            
            while (true) {

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                System.out.println("UDP server is waiting...");

                serverSocket.receive(receivePacket);
                

                String sentence = new String(receivePacket.getData());
                System.out.println("Received: " + sentence);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}