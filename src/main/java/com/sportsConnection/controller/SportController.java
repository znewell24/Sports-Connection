package com.sportsConnection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.sportsConnection.entity.Sport;
import com.sportsConnection.service.SportService;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/sports")
public class SportController {

    @Autowired
    private SportService sportService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Sport> getAllSports() {
        return sportService.getAllSports();
    }

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public Sport getSportById(@PathVariable int id) {
        return sportService.getSportById(id);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public void deleteSportById(@PathVariable("id") int id){
        sportService.removeSportById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateSport(@RequestBody Sport sport){
        sportService.updateSport(sport);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insertSport(@RequestBody Sport sport) {
        sportService.insertSport(sport);
    }

    @RequestMapping("/db")
    public String db(Map<String, Object> model) { return sportService.db(model); }
}
