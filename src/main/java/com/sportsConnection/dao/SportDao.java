package com.sportsConnection.dao;

import com.sportsConnection.entity.Player;
import com.sportsConnection.entity.Sport;

import java.util.Collection;
import java.util.Map;

public interface SportDao {

    Collection <Sport> getAllSports();

    Sport getSportById(int id);

    void removeSportById(int id);

    void updateSport(Sport sport);

    void insertSportToDb(Sport sport);

    Collection <Player> getAllPlayersForSport(Sport sport);

    void removePlayerById(int id);

    void insertPlayerToSport(Player player, int sportId);

    void updatePlayer(Player player);

    String db(Map<String, Object> model);

}
