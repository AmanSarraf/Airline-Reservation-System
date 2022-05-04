/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.system.databaseInterfaceLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lapras
 */
public class Passenger {

    public int p_id;
    public String name;
    public String email;
    public String password;
    public boolean is_admin;

    public Passenger(int p_id, String name, String email, String password, boolean is_admin) {
        this.p_id = p_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
    }

    public Passenger(ResultSet res) throws SQLException {

        this(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getBoolean(5));
    }

    @Override
    public String toString() {
        return "Passenger{" + "p_id=" + p_id + ", name=" + name + ", email=" + email + ", password=" + password + ", is_admin=" + is_admin + '}';
    }

}
