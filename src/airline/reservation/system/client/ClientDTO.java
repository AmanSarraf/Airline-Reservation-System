/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.system.client;

import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import airline.reservation.system.serialization.Passenger;
import airline.reservation.system.serialization.Flight;

/**
 *
 * @author lapras
 */
public class ClientDTO {

    final Socket SOCKET;
    private final ObjectOutputStream OUTPUT;
    private final ObjectInputStream INPUT;
    public static Passenger currentPassenger;

    ClientDTO(Socket SOCKET) throws IOException {
        this.SOCKET = SOCKET;
        OUTPUT = new ObjectOutputStream(SOCKET.getOutputStream());
        INPUT = new ObjectInputStream(SOCKET.getInputStream());
        currentPassenger = null;
    }

    public boolean register(Passenger p) {
        try {
            OUTPUT.writeInt(1);
            OUTPUT.flush();

            OUTPUT.writeObject(p);
            OUTPUT.flush();

            return INPUT.readBoolean();
        } catch (IOException ex) {
            Logger.getLogger(ClientDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Passenger login(Passenger p) {

        try {
            OUTPUT.writeInt(2);
            OUTPUT.flush();

            OUTPUT.writeObject(p);
            OUTPUT.flush();

            p = (Passenger) INPUT.readObject();
            if (p != null) {
                currentPassenger = p;
            }

            return p;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addBooking(Flight f) {
        try {
            OUTPUT.writeInt(3);
            OUTPUT.flush();

            OUTPUT.writeInt(currentPassenger.p_id);
            OUTPUT.flush();

            OUTPUT.writeObject(f);
            OUTPUT.flush();

            return INPUT.readBoolean();
        } catch (IOException ex) {
            Logger.getLogger(ClientDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Flight> getBookings() {
        try {
            OUTPUT.writeInt(4);
            OUTPUT.flush();

            OUTPUT.writeInt(currentPassenger.p_id);
            OUTPUT.flush();

            ArrayList<Flight> flights = (ArrayList<Flight>) INPUT.readObject();
            return flights;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void removeResources() {
        try {
            System.out.println("Closing Connection");
            OUTPUT.writeInt(0);
            OUTPUT.close();
            INPUT.close();
            SOCKET.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
