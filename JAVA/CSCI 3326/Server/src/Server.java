import java.io.*;
import java.net.*;
public class Server {
 public static void main(String[] args) throws IOException {
 ServerSocket ss = new ServerSocket(9090);
 ss.setSoTimeout(100000);
 while(true)
 {
 try
 {
 System.out.println("Waiting for client on port " +ss.getLocalPort() + "...");
 Socket server = ss.accept();
 System.out.println("Just connected to " + server.getRemoteSocketAddress());
 DataInputStream in = new DataInputStream(server.getInputStream()); // message from client
 System.out.println(in.readUTF());
 DataOutputStream out = new DataOutputStream(server.getOutputStream()); // message to client
 out.writeUTF("Thank you for connecting to Dr. Kim’s server " + server.getLocalSocketAddress() +". Goodbye!");
 server.close();
 }
 catch(SocketTimeoutException s)
 { System.out.println("Socket timed out!"); break; }
 catch(IOException e)
 { e.printStackTrace(); break; }
 }
 ss.close();
 }
} 