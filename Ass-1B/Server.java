import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class Server {
public static void main(String args[]) throws Exception {
DatagramSocket datagramSocket;
final int PORT = 8080;
System.out.println("Opening server socket ...");
try {
datagramSocket = new DatagramSocket(PORT);
System.out.println("Server socket listening on port " + PORT);
byte[] buf = new byte[1024];
DatagramPacket dp = new DatagramPacket(buf, 1024);
datagramSocket.receive(dp);
String str = new String(dp.getData(), 0, dp.getLength());
System.out.println("Line: " + str);
datagramSocket.close();
}
catch (Exception e){
System.out.println("Server encountered error");
}
}
}
