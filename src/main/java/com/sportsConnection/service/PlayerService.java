package com.sportsConnection.service;

import com.sportsConnection.dao.SportDao;
import com.sportsConnection.entity.Player;
import com.sportsConnection.entity.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PlayerService {

    @Autowired
    private SportDao sportDao;

    public Collection <Player> getAllPlayersForSport(Sport sport) {
        return this.sportDao.getAllPlayersForSport(sport);
    }

    public void removePlayerById(int id) { this.sportDao.removePlayerById(id); }

    public void insertPlayerToSport(Player player, int sportId) {
        this.sportDao.insertPlayerToSport(player, sportId);
    }

    public void updatePlayer(Player player) { this.sportDao.updatePlayer(player); }

}
