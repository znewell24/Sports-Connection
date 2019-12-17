package com.sportsConnection.controller;

import com.sportsConnection.entity.Player;
import com.sportsConnection.entity.Sport;
import com.sportsConnection.service.PlayerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/players")
@Log4j2
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity <Collection <Player>> getAllPlayersForSport(@RequestBody Sport sport) {
        log.info("Made it to get all players");
        return new ResponseEntity<>(playerService.getAllPlayersForSport(sport),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/id", method = RequestMethod.DELETE)
    public ResponseEntity removePlayerById(@PathVariable("id") int id) {
        log.info("Made it to delete player");
        playerService.removePlayerById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/insert/{sportId}", method = RequestMethod.POST)
    public void insertPlayerToSport(@RequestBody Player player,
                                    @PathVariable int sportId) {
        playerService.insertPlayerToSport(player, sportId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updatePlayer(@RequestBody Player player) { playerService.updatePlayer(player); }
}
