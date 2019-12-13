package com.sportsConnection.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Player {
    private final int id;
    private final String name;
    private final int sportId;
}
