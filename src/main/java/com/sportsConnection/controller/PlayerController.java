package com.sportsConnection.controller;

import com.sportsConnection.entity.Player;
import com.sportsConnection.entity.Sport;
import com.sportsConnection.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection <Player> getAllPlayersForSport(Sport sport) {
        return playerService.getAllPlayersForSport(sport);
    }

    @RequestMapping(value = "/id", method = RequestMethod.DELETE)
    public void removePlayerById(@PathVariable("id") int id) { playerService.removePlayerById(id); }

    @RequestMapping(value = "/insert/{sportId}", method = RequestMethod.POST)
    public void insertPlayerToSport(@RequestBody Player player,
                                    @PathVariable int sportId) {
        playerService.insertPlayerToSport(player, sportId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updatePlayer(@RequestBody Player player) { playerService.updatePlayer(player); }
}
