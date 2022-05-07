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

    Socket socket;
    final ObjectInputStream INPUT;
    final ObjectOutputStream OUTPUT;
    int CLIENT_ID;

    ClientHandler(Socket socket, int countClient) throws IOException {
        this.socket = socket;
        this.CLIENT_ID = countClient;
        INPUT = new ObjectInputStream(socket.getInputStream());
        OUTPUT = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            var serReqDTO = new ServerRequestDTO(socket, INPUT, OUTPUT);
            int requestType = 1;

            while (requestType != 0) {
                try {
                    requestType = INPUT.readInt();

                    System.out.print("Client " + CLIENT_ID + " : ");

                    switch (requestType) {
                        case 1:
                            // Add Passenger by Passenger
                            System.out.println("Register a new Passenger");
                            if (!serReqDTO.addPassengerDAO()) {
                                requestType = 0;
                            }
                            break;

                        case 2:
                            // Get Passenger by ID
                            System.out.println("Get a Passenger info");
                            if (!serReqDTO.getPassengerDAO()) {
                                requestType = 0;
                            }
                            break;

                        case 3:
                            // Login Passenger
                            System.out.println("Passenger login");
                            if (!serReqDTO.loginPassengerDAO()) {
                                requestType = 0;
                            }
                            break;

                        case 4:
                            // Get Flight by ID
                            System.out.println("Check a Flight info");
                            if (!serReqDTO.getFlightDAO()) {
                                requestType = 0;
                            }
                            break;

                        case 5:
                            // Get Flight by Origin and Destination
                            System.out.println("Check route specific Flights");
                            if (!serReqDTO.flightsFromOriginDestinationDAO()) {
                                requestType = 0;
                            }
                            break;

                        case 6:
                            // Add Booking by Passenger ID and Flight ID
                            System.out.println("Book a new flight");
                            if (!serReqDTO.addBookingDAO()) {
                                requestType = 0;
                            }
                            break;

                        case 7:
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
                    System.out.println("Invalid Request ID");
                    System.out.println(ex);
                    break;
                }
            }

            System.out.println("-- Client : " + CLIENT_ID + " Disconnected --");

            INPUT.close();
            OUTPUT.close();
            socket.close();

        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
