import java.io.DataInputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
public class Client {
public static void main(String[] args) throws Exception {
DatagramSocket socket = null;
DataInputStream userInput;

String input;
final int PORT = 8080;
try {
socket = new DatagramSocket();
userInput = new DataInputStream(System.in);
System.out.println("Enter message : ");
input = " ";
while(input != "Exit"){
input = userInput.readLine();
DatagramPacket datagramPacket = new
DatagramPacket(input.getBytes(), input.length(),

InetAddress.getByName("localhost"), PORT);

socket.send(datagramPacket);
}
socket.close();
} catch (Exception e) {
System.out.println("Could not start client");
}
}
}
