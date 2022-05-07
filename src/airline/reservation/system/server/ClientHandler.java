/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.system.server;

import java.io.IOException;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lapras
 */
class ClientHandler implements Runnable {

    final Socket SOCKET;
    final ObjectInputStream INPUT;
    final ObjectOutputStream OUTPUT;
    final int CLIENT_ID;

    ClientHandler(Socket socket, int countClient) throws IOException {
        this.SOCKET = socket;
        this.CLIENT_ID = countClient;
        INPUT = new ObjectInputStream(socket.getInputStream());
        OUTPUT = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            var serReqDTO = new ServerRequestDTO(SOCKET, INPUT, OUTPUT);
            int requestType = -1;

            while (requestType != 0) {
                try {
                    requestType = INPUT.readInt();

                    System.out.print("Client " + CLIENT_ID + " : ");

                    switch (requestType) {
                        case 1:
                            // Add new Passenger by Passenger
                            System.out.println("Register a new Passenger");
                            if (!serReqDTO.addPassengerDAO()) {
                                requestType = 0;
                            }
                            break;

                        case 2:
                            // Login Passenger using email and password
                            System.out.println("Passenger login");
                            if (!serReqDTO.loginPassengerDAO()) {
                                requestType = 0;
                            }
                            break;

                        case 3:
                            // Add Booking by Passenger ID and Flight
                            System.out.println("Book a new flight");
                            if (!serReqDTO.addBookingDAO()) {
                                requestType = 0;
                            }
                            break;

                        case 4:
                            // Get All Flights by Passenger ID
                            System.out.println("All flights given passenger");
                            if (!serReqDTO.getflightsbyPassengerDAO()) {
                                requestType = 0;
                            }
                            break;

                        case 0:
                            // Client Request closes connection
                            System.out.println("Close Connection");
                            break;

                        default:
                            throw new IOException();
                    }
                } catch (IOException ex) {
                    System.out.println("Invalid Request ID (" + requestType + ")");
                    System.out.println(ex);
                    break;
                }
            }

            System.out.println("-- Client : " + CLIENT_ID + " Disconnected --");

            INPUT.close();
            OUTPUT.close();
            SOCKET.close();

        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
