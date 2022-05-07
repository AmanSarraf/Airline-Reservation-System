
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.system.server;

import airline.reservation.system.serialization.Flight;
import airline.reservation.system.serialization.Passenger;
import java.sql.Connection;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import airline.reservation.system.server.database.*;

import java.net.Socket;

/**
 *
 * @author lapras
 */
// Connects Server with Database (DTO: Data Transfer Object)
class ServerRequestDTO {

    private final Connection CON;
    final Socket socket;
    final ObjectInputStream INPUT;
    final ObjectOutputStream OUTPUT;

    ServerRequestDTO(Socket socket, ObjectInputStream INPUT, ObjectOutputStream OUTPUT) {
        CON = Connect.newConnection();
        this.socket = socket;
        this.INPUT = INPUT;
        this.OUTPUT = OUTPUT;
    }

    boolean addPassengerDAO() {
        var pDAO = new PassengerDAO(CON);
        try {
            Passenger p = (Passenger) INPUT.readObject();

            boolean res = pDAO.addPassenger(p);
            OUTPUT.writeBoolean(res);
            OUTPUT.flush();
            return true;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ServerRequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    boolean loginPassengerDAO() {
        var pDAO = new PassengerDAO(CON);
        try {
            Passenger p = (Passenger) INPUT.readObject();
            p = pDAO.loginPassenger(p.email, p.password);

            OUTPUT.writeObject(p);
            OUTPUT.flush();
            return true;

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ServerRequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    int addFlightDAO() {
        var fDAO = new FlightDAO(CON);
        try {
            Flight f = (Flight) INPUT.readObject();
            return fDAO.addFlight(f);

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ServerRequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    boolean addBookingDAO() {
        var bDAO = new BookingDAO(CON);
        try {
            int p_id = INPUT.readInt();
            int f_id = addFlightDAO();
            if (f_id > 0) {
                boolean res = bDAO.addBooking(f_id, p_id);
                OUTPUT.writeBoolean(res);
                OUTPUT.flush();
                return true;
            }

        } catch (IOException ex) {
            Logger.getLogger(ServerRequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    boolean getflightsbyPassengerDAO() {
        var bDAO = new BookingDAO(CON);
        try {
            int p_id = INPUT.readInt();

            ArrayList<Flight> flights = bDAO.getlAllFlightsbyPassengerID(p_id);
            OUTPUT.writeObject(flights);
            OUTPUT.flush();
            return true;

        } catch (IOException ex) {
            Logger.getLogger(ServerRequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    protected void finalize() throws Throwable {
        try {
            Connect.closeConnetion(CON);
            INPUT.close();
            OUTPUT.close();
        } finally {
            super.finalize();
        }

    }
}
