/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.system.databaseInterfaceLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lapras
 */
// Booking Data Access Object
public class BookingDAO {

    private final Connection CON;

    public BookingDAO(Connection con) {
        this.CON = con;
    }

    public boolean addBooking(int f_id, int p_id) {
        try ( PreparedStatement pre_stmt = CON.prepareStatement(Queries.INSERT_BOOKING)) {
            pre_stmt.setInt(1, f_id);
            pre_stmt.setInt(2, p_id);
            return pre_stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Flight> getflightsbyPassengerID(int p_id) {
        try ( PreparedStatement pre_stmt = CON.prepareStatement(Queries.GET_FLIGHT_BY_PASSENGERID)) {
            pre_stmt.setInt(1, p_id);
            ResultSet res = pre_stmt.executeQuery();
            if (res.next() == false) {
                return null;
            }
            ArrayList<Flight> flights = new ArrayList<>();
            do {
                flights.add(new FlightDAO(CON).getFlight(res.getInt(1)));
            } while (res.next());
            return flights;
        } catch (SQLException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
