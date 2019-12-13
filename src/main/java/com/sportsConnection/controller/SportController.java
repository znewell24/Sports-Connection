package com.sportsConnection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.sportsConnection.entity.Sport;
import com.sportsConnection.service.SportService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
