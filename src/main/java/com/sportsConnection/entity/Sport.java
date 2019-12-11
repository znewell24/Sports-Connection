package com.sportsConnection.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.xml.stream.Location;

@Data
@RequiredArgsConstructor
public class Sport {

    private int id;
    private String name;
    private SportName sportName;
    private Location location;


    enum SportName {
        SOCCER,
        BASKETBALL,
        FOOTBALL,
        ULTIMATE
    }
}
