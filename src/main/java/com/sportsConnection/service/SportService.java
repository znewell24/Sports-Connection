package com.sportsConnection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.sportsConnection.dao.SportDao;
import com.sportsConnection.entity.Sport;

import java.util.Collection;
import java.util.Map;

@Service
public class SportService {

    @Autowired
    @Qualifier("postgresqlData")
    private SportDao sportDao;

    public Collection<Sport> getAllSports() {
        return this.sportDao.getAllSports();
    }

    public Sport getSportById(int id) {
        return this.sportDao.getSportById(id);
    }

    public void removeSportById(int id) {
        this.sportDao.removeSportById(id);
    }

    public void updateSport(Sport sport) {
        this.sportDao.updateSport(sport);
    }

    public void insertSport(Sport sport) {
        this.sportDao.insertSportToDb(sport);
    }

    public String db(Map<String, Object> model) { return this.sportDao.db(model); }
}
