/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.system.serialization;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author lapras
 */
public class Flight implements Serializable {

    public int f_id;
    public String origin;
    public String destination;
    public Date departure_date;
    public int capacity;
    public int price;

    public Flight(int f_id, String origin, String destination, Date departure_date) {
        this.f_id = f_id;
        this.origin = origin;
        this.destination = destination;
        this.departure_date = departure_date;
    }

    public Flight(ResultSet res) throws SQLException {
        this(res.getInt(1), res.getString(2), res.getString(3), res.getDate(4));
        this.capacity = res.getInt(6);
        this.price = res.getInt(6);
    }

    @Override
    public String toString() {
        return "Flight{" + "f_id=" + f_id + ", origin=" + origin + ", destination=" + destination + ", departure_date=" + departure_date + ", capacity=" + capacity + ", price=" + price + '}';
    }

}
