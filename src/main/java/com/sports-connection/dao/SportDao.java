package sportsConnection.dao;

import sportsConnection.entity.Sport;

import java.util.Collection;

public interface SportDao {

    Collection <Sport> getAllSports();

    Sport getSportById(int id);

    void removeSportById(int id);

    void updateSport(Sport sport);

    void insertSportToDb(Sport sport);
}
