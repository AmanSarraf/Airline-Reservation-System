/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.system.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lapras
 */
public class Server {

    static int countClient = 0;

    public Server(int port) {
        try ( var server = new ServerSocket(port)) {
            System.out.println("Server started");

            while (true) {
                Socket socket = server.accept();
                System.out.println("-- Client : " + ++countClient + " Connected --");
                DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

                ClientHandler ch = new ClientHandler(socket, dis, countClient);
                Thread t = new Thread(ch);
                t.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        new Server(5000);
    }
}
