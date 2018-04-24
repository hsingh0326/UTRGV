import java.io.*; 
import java.net.*;
public class Client
{
 public static void main(String[] args) throws IOException
 {
	
	 	String serverName = "129.113.119.221";
	 	int port = 9090;
	 try
	 {
	 System.out.println("Connecting to " + serverName + " on port " + port);
	 Socket client = new Socket(serverName, port);
	 System.out.println("Just connected to " + client.getRemoteSocketAddress());
	 DataOutputStream out = new DataOutputStream(client.getOutputStream()); // message to server
	 out.writeUTF("Hello from Jeet client " + client.getLocalSocketAddress());
	 DataInputStream in = new DataInputStream(client.getInputStream()); // message from server
	 System.out.println("Server says " + in.readUTF());
	 client.close();
	 }catch(IOException e)
	 {
	 e.printStackTrace();
	 }
	 }
} 
