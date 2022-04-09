package org.bonn.ooka.buchungssystem.ss2022;

import java.util.ArrayList;
import java.util.List;

public class HotelRetrieval implements Hotelsuche {
    private DBAccess acc = new DBAccess();
    public List<Hotel> hotelOutput = new ArrayList<>();

    @Override
    public Hotel[] getHotelbyName(String hotel) {
        System.out.println("Test:" + acc.getObjects(0, hotel));
        List<String> hotelList = acc.getObjects(0, hotel);
        while (!hotelList.isEmpty()) {
            Hotel hotelObject = new Hotel(Integer.parseInt(hotelList.get(0)), hotelList.get(1), hotelList.get(2)); //Neues Hotel-Objekt mit jeweils ersten drei Feldern der Quellliste für Attribute
            hotelOutput.add(hotelObject);
            for(int i = 0; i <= 2; i++ ) {  //Erste drei Felder der Hotelliste löschen, um nächstes Objekt zu behandeln
                hotelList.remove(0);
            }
        }
        Hotel[] hotelArray = new Hotel[hotelList.size()];
        hotelArray = hotelList.toArray(hotelArray);

        for(Hotel h: hotelArray)
            System.out.println(h);
        /*Hotel[] hotelArray = hotelOutput.toArray(new Hotel[0]);
        System.out.println("HotelOutput:" + hotelOutput);
        hotelOutput.forEach(System.out::println);
        System.out.println("HotelArray" + hotelArray);
        for (Hotel hotel1 : hotelArray) {
            System.out.println(hotel1);
        }
        return hotelArray;*/
        return null;
    }

    @Override
    public void openConnection() {
        acc.openConnection();
    }

    @Override
    public void closeConnection() {
        acc.closeConnection();
    }
}
