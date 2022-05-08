/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.system.client;

import airline.reservation.system.client.ui.MainScreen;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lapras
 */
public class Client {

    public static ClientDTO CLIENTDTO;

    public static void main(String args[]) {
//        try {
//            Socket SOCKET = new Socket("localhost", 5000);
//            System.out.println("Connected to server");
//            CLIENTDTO = new ClientDTO(SOCKET);

        // Run Main Screen
        MainScreen Ms = new MainScreen();
        Ms.setLocationRelativeTo(null);
        Ms.setVisible(true);
//        } catch (IOException ex) {
//            System.out.println("Host does not respond to request");
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
