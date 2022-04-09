package org.bonn.ooka.buchungssystem.ss2022;

import java.util.Scanner;
import java.util.List;

public class Proxy implements Hotelsuche{
    HotelRetrieval hotelRetrieval = new HotelRetrieval();

    public static void main(String[] args) {
        String repeat = "y";
        Proxy proxy = new Proxy();
        proxy.openConnection();
        Scanner myObj = new Scanner(System.in);
        while (repeat == "y") {
            System.out.println("Search for Hotel Name");
            String hotelName = myObj.nextLine();
            System.out.println("Here you go:" + proxy.getHotelbyName(hotelName));
            System.out.println("Repeat search? (y/n)");
            repeat = myObj.nextLine();
        }
        proxy.closeConnection();
    }

    @Override
    public Hotel[] getHotelbyName(String hotel) {
        return hotelRetrieval.getHotelbyName(hotel);
    }

    @Override
    public void openConnection() {
        hotelRetrieval.openConnection();
    }

    @Override
    public void closeConnection() {
        hotelRetrieval.closeConnection();
    }
}
