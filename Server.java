// CREATING A SERVER SIDE  SOCKET  NETWORK APPLICATION

import java.io.*;
import java.net.*;

public class Server implements Runnable
{
    
    ServerSocket serverSocket;
    PrintStream streamToClient;
    BufferedReader streamFromClient;
    Socket fromClient;
    
    
    static int count = 0001;
    Thread thread;
    
    public Server(){
        try {
            serverSocket = new ServerSocket(1001); //create a socket
        } catch(Exception e) {
            System.out.println(" Socket could not be created "+e);
        }
        thread = new Thread(this);
        
        thread.start();
    }
    
    public void run(){
        try {
            while(true){
                fromClient = serverSocket.accept();
                count++;
                
                System.out.println("client connection on "+count);
                
                streamFromClient=new BufferedReader
                (new InputStreamReader((fromClient.getInputStream()))); // create input stream for the socket
                
                streamToClient = new PrintStream(fromClient.getOutputStream()); // create output stream for the client
                
                String str= streamFromClient.readLine(); // read the message sent by the client
                    System.out.println("client connection name: "+str);
                    
                    streamToClient.println("Welcome: "+str);// message sent message to client
                    
                
            } //end of while loop
            
        } catch(Exception e) {
            System.out.println("Exception "+e);
            
            
        }
        finally{
            try {
                fromClient.close();
                
            } catch(Exception e1) {
                System.out.println("Could not close Connection "+e1);
            }
        }
    }
    public static void main(String[] args) {
        new Server();
    }
}
