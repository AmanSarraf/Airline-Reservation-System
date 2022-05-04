/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package airline.reservation.system;

//import airline.reservation.system.databaseInterfaceLayer.*;
/**
 *
 * @author AMAN
 */
public class AirlineReservationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainScreen Ms = new MainScreen();
        Ms.setLocationRelativeTo(null);
        Ms.setVisible(true);

//        var con = Connect.newConnection();
//        System.out.println(new PassengerDAO(con).getPassenger(1));
//        System.out.println(new FlightDAO(con).getFlight(1));
//        var flights = new BookingDAO(con).getflightsbyPassengerID(1);
//        for (Flight f : flights) {
//            System.out.println(f);
//        }
//        Connect.closeConnetion(con);
    }
}
