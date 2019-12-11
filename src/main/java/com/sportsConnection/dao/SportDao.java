package com.sportsConnection.dao;

import com.sportsConnection.entity.Sport;

import java.util.Collection;
import java.util.Map;

public interface SportDao {

    Collection <Sport> getAllSports();

    Sport getSportById(int id);

    void removeSportById(int id);

    void updateSport(Sport sport);

    void insertSportToDb(Sport sport);

    String db(Map<String, Object> model);

}
