package com.sportsConnection.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Location {

    private final float lat;
    private final float lon;

    public String toJson() {
        return "{\"latitude\":\"" + lat + "\",\"longitude\":\"" + lon + "\"}";
    }
}
