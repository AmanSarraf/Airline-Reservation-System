/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.system.databaseInterfaceLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lapras
 */
// Flight Data Access Object
public class FlightDAO {

    private final Connection CON;

    public FlightDAO(Connection con) {
        this.CON = con;
    }

    public boolean addFlight(Flight f) {
        try ( PreparedStatement pre_stmt = CON.prepareStatement(Queries.INSERT_FLIGHT)) {
            pre_stmt.setString(1, f.origin);
            pre_stmt.setString(2, f.destination);
            pre_stmt.setString(3, f.departure_time);
            pre_stmt.setInt(4, f.capacity);
            pre_stmt.setInt(5, f.price);
            return pre_stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean removeFlight(int id) {
        try ( PreparedStatement pre_stmt = CON.prepareStatement(Queries.DELETE_FLIGHT)) {
            pre_stmt.setInt(1, id);
            return pre_stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Flight getFlight(int id) {
        try ( PreparedStatement pre_stmt = CON.prepareStatement(Queries.GET_FLIGHT_BY_ID)) {
            pre_stmt.setInt(1, id);
            ResultSet res = pre_stmt.executeQuery();
            return res.next() ? new Flight(res) : null;
        } catch (SQLException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Flight flightsFromOriginDestination(String origin, String destination) {
        try ( PreparedStatement pre_stmt = CON.prepareStatement(Queries.GET_FLIGHT_BY_ORIGIN_DESTINATION)) {
            pre_stmt.setString(1, origin);
            pre_stmt.setString(2, destination);
            ResultSet res = pre_stmt.executeQuery();
            return res.next() ? new Flight(res) : null;
        } catch (SQLException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void showTable(Connection con) {
        String query = Queries.GET_ALL_FLIGHT;
        try ( Statement stmt = con.createStatement()) {
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                String dataRow = res.getInt(1) + "  " + res.getString(2) + "  " + res.getString(3) + "  " + res.getString(4) + " " + res.getInt(5) + " " + res.getInt(6);
                System.out.println(dataRow);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
