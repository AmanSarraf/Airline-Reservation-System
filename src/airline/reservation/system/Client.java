
// A Java program for a Client

import airline.reservation.system.MainScreen;
import java.net.*;
import java.io.*;

public class Client {
    
    final Socket socket;
   final ObjectOutputStream out;
    final ObjectInputStream input;
    
    
    
    public Client(String address, int port) throws Exception {
        
        // establish a connection
        socket = new Socket(address, port);
        System.out.println("Connected");

        out = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());

        
        
    }
    
    
//    boolean CreateUser() throws IOException
//    {
//        out.writeInt(1);
//        
//        
//        
//    
//    }
//    boolean Login()throws IOException{
//        out.writeInt(4);
//    
//    
//    }
//    
    

    public static void main(String args[]) throws Exception {
        //new Client("localhost", 5000);
          MainScreen Ms = new MainScreen();
        Ms.setLocationRelativeTo(null);
        Ms.setVisible(true);
    }
}



