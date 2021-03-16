import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
class UdpClient {
  public static void main(String[] args) {
  try {
    DatagramSocket datagramSocket = new DatagramSocket(1234);
    byte[] buffer;
    DatagramPacket datagramPacket;
    System.out.println("Messages Received");
    while (true) {
      buffer = new byte[65535];
      datagramPacket = new DatagramPacket(buffer, buffer.length);
      datagramSocket.receive(datagramPacket);
      String received = new String(buffer).trim();
      if (received.equalsIgnoreCase("exit")) {
        datagramSocket.close();
        break;
        }
      System.out.println(received);
      }
  }
  catch(IOException e){
    e.printStackTrace();
    }
  }
}

