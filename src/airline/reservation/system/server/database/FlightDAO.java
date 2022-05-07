/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.system.server.database;

import airline.reservation.system.serialization.Flight;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
