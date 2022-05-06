package airline.reservation.system.server;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import airline.reservation.system.databaseInterfaceLayer.Connect;
import airline.reservation.system.databaseInterfaceLayer.Passenger;
import airline.reservation.system.databaseInterfaceLayer.Flight;
import airline.reservation.system.databaseInterfaceLayer.PassengerDAO;
import airline.reservation.system.databaseInterfaceLayer.FlightDAO;
import airline.reservation.system.databaseInterfaceLayer.BookingDAO;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author lapras
 */
// Connects Server with Database (DTO: Data Transfer Object)
class ServerRequestDTO {

    private final Connection CON;

    ServerRequestDTO() {
        CON = Connect.newConnection();
    }

    boolean addPassengerDAO(String data) {
        return false;
    }

    boolean removePassengerDAO(String data) {
        return false;
    }

    Passenger getPassengerDAO(String data) {
        return null;
    }

    Passenger loginPassengerDAO(String data) {
        return null;
    }

    boolean addFlightDAO(String data) {
        return false;
    }

    boolean removeFlightDAO(String data) {
        return false;
    }

    Flight getFlightDAO(String data) {
        return null;
    }

    Flight flightsFromOriginDestinationDAO(String data) {
        return null;
    }

    boolean addBookingDAO(String data) {
        return false;
    }

    ArrayList<Flight> getflightsbyPassengerIDDAO(String data) {
        return null;
    }

}
