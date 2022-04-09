package org.bonn.ooka.buchungssystem.ss2022;

import java.util.List;

public interface Hotelsuche {
    Hotel[] getHotelbyName(String name);
    void openConnection();
    void closeConnection();
}
