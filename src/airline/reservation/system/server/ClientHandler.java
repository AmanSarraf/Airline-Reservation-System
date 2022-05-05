/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.system.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lapras
 */
class ClientHandler implements Runnable {

    final Socket SOCKET;
    final DataInputStream DIS;
    final int CLIENT_NUMBER;

    // constructor
    ClientHandler(Socket s, DataInputStream dis, int clientNumber) {
        this.SOCKET = s;
        this.DIS = dis;
        this.CLIENT_NUMBER = clientNumber;
    }

    @Override
    public void run() {
        String line = "";

        while (!line.equals("Over")) {
            try {
                line = (String) DIS.readUTF();
                System.out.println("Client " + CLIENT_NUMBER + " : " + line);
            } catch (IOException ex) {
                break;
            }
        }

        System.out.println("Closing connection : " + CLIENT_NUMBER);
        try {
            DIS.close();
            SOCKET.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
