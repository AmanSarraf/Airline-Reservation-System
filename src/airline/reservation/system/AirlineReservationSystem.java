/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package airline.reservation.system;

import airline.reservation.system.databaseInterfaceLayer.*;
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

        var con = Connect.newConnection();
        var pDAO = new PassengerDAO(con);
        var p = pDAO.getPassenger(1);
        System.out.println(p);
        Connect.closeConnetion(con);
    }

}
