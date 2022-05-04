/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.system.databaseInterfaceLayer;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lapras
 */
// Passenger Data Access Object
public class PassengerDAO {

    private Connection con;

    public PassengerDAO(Connection con) {
        this.con = con;
    }

    public void addPassenger(int u) {
    }

    public void removePassenger(int id) {
    }

    public String getPassenger(int id) {
        return null;
    }

    public boolean setPassenger(int id) {
        return true;
    }

    public static void showTable(Connection con) {
        String query = "select * from passenger";
        try ( Statement stmt = con.createStatement()) {
            ResultSet res = stmt.executeQuery(query);

            // Print query result
            while (res.next()) {
                String dataRow = res.getInt(1) + "  " + res.getString(2) + "  " + res.getString(3) + "  " + res.getString(4);
                System.out.println(dataRow);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PassengerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
