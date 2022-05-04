/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.system.databaseInterfaceLayer;

/**
 *
 * @author lapras
 */
class Queries {

    static final String GET_ALL_PASSENGER = "SELECT * FROM passenger";
    static final String GET_ALL_BOOKING = "SELECT * FROM booking";
    static final String GET_ALL_FLIGHT = "SELECT * FROM flight";

    /*
     * Passenger Table
     */
    static final String GET_PASSENGER_BY_EMAIL_AND_PASSWORD = "SELECT * from passenger where email = ? and password = ?";
    static final String GET_PASSENGERID_BY_EMAIL_AND_PASSWORD = "SELECT p_id from passenger where email = ? and password = ?";
    static final String GET_PASSENGER_BY_EMAIL = "SELECT * from passenger where email = ?";
    static final String GET_PASSENGER_BY_PASSENGERID = "SELECT * FROM passenger WHERE p_id = ?";
    static final String INSERT_PASSENGER = "INSERT INTO passenger (name, email, password, is_admin) VALUES(?, ?, ?, ?)";
    static final String DELETE_PASSENGER = "DELETE FROM passenger WHERE p_id = ?";


    /*
     * Flight table
     */
    static final String GET_FLIGHT_BY_ID = "SELECT * FROM flight Where f_id = ?";
    static final String GET_FLIGHT_BY_ORIGIN_DESTINATION = "SELECT * FROM flight WHERE origin = ? AND destination = ?";
    static final String INSERT_FLIGHT = "INSERT INTO airline.flight (origin, destination, departure_time, capacity, price) VALUES(?, ?, ?, ?, ?)";
    static final String DELETE_FLIGHT = "DELETE FROM flight WHERE f_id = ?";

    /*
     * Booking Table
     */
    static final String INSERT_BOOKING = "INSERT INTO airline.booking (f_id, p_id) VALUES (? ,?)";
    static final String GET_FLIGHT_BY_PASSENGERID = "SELECT f_id FROM Booking WHERE p_id = ?";
}
