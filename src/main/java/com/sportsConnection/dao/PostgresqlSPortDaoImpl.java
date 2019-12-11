package com.sportsConnection.dao;

import com.sportsConnection.entity.Sport;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public abstract class PostgresqlSPortDaoImpl implements SportDao {


    @Autowired
    private DataSource dataSource;

    @Override
    public Collection<Sport> getAllSports() {
        return null;
    }

    @Override
    public Sport getSportById(int id) {
        return null;
    }

    @Override
    public void removeSportById(int id) {

    }

    @Override
    public void updateSport(Sport sport) {

    }

    @Override
    public void insertSportToDb(Sport sport) {

    }

    @Override
    public String db(Map<String, Object> model) {


        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS sports (sport timestamp)");
            statement.executeUpdate("INSERT INTO sports VALUES (now())");
            ResultSet resultSet = statement.executeQuery("SELECT sport FROM sports");

            ArrayList<String> output = new ArrayList<String>();
            while (resultSet.next()) {
                output.add("Read from DB: " + resultSet.getTimestamp("sport"));
            }

            model.put("records", output);
            return "db";
        } catch (Exception e) {
            model.put("message", e.getMessage());
            return "Error: " + e.getMessage();
        }
    }

}
