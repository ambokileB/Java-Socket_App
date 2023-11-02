// CREATING A CLIENT NETWORK APPLICATION 

import java.io.*;
import java.net.*;



public class Client{
    
    
    PrintStream streamToServer;
    
    BufferedReader streamFromServer;
    Socket toServer;
    
    public Client(){
        connectToServer();
    }
    
    private void connectToServer(){
        try {
            String name;
            toServer = new Socket("localhost",1001);
            streamFromServer = new BufferedReader(new  InputStreamReader((toServer.getInputStream())));
            
            streamToServer = new PrintStream(toServer.getOutputStream());
            
           System.out.println("enter connection name");
           
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           
           name = reader.readLine();
           streamToServer.println(name);
           
           String str = streamFromServer.readLine();
           
           System.out.println("The server says : "+str+" How i can assist you");
           
        } catch(Exception e) {
            System.out.println("Exception "+e);
            
        }
    }
    
    public static void main (String[] args) {
        
        new Client();
    }
}