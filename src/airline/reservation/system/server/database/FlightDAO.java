/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.system.server.database;

import airline.reservation.system.serialization.Flight;
import java.sql.Connection;
import java.sql.Statement;
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

    public int addFlight(Flight f) {
        try ( PreparedStatement pre_stmt = CON.prepareStatement(Queries.INSERT_FLIGHT)) {
            pre_stmt.setString(1, f.origin);
            pre_stmt.setString(2, f.destination);
            pre_stmt.setDate(3, f.departure_date);

            if (pre_stmt.executeUpdate() != 0) {
                Statement stmt = CON.createStatement();
                ResultSet res = stmt.executeQuery(Queries.GET_LAST_INSERTED_FLIGHT_ID);
                if (res.next()) {
                    return res.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
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
}
