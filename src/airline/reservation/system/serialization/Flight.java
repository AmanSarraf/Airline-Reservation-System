/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation.system.serialization;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lapras
 */
public class Flight implements Serializable {

    public int f_id;
    public String origin;
    public String destination;
    public String departure_time;
    public int capacity;
    public int price;

    public Flight(int f_id, String origin, String destination, String departure_time, int capacity, int price) {
        this.f_id = f_id;
        this.origin = origin;
        this.destination = destination;
        this.departure_time = departure_time;
        this.capacity = capacity;
        this.price = price;
    }

    public Flight(ResultSet res) throws SQLException {
        this(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5), res.getInt(6));
    }

    @Override
    public String toString() {
        return "Flight{" + "f_id=" + f_id + ", origin=" + origin + ", destination=" + destination + ", departure_time=" + departure_time + ", capacity=" + capacity + ", price=" + price + '}';
    }

}
