package com.sportsConnection.dao;

import com.sportsConnection.entity.Location;
import com.sportsConnection.entity.Player;
import com.sportsConnection.entity.Sport;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class PostgresqlSPortDaoImpl implements SportDao {

    @Autowired
    private BasicDataSource dataSource;

    @Override
    public Collection<Sport> getAllSports() {
        ArrayList<Sport> sports = new ArrayList<>();
        String q = "SELECT * FROM sports";

        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(q);

            while (rs.next()) {
                Sport sport = new Sport(rs.getInt("ID")
                ,rs.getString("name")
                ,rs.getString("sportName")
                , new Location(rs.getFloat("lat"), rs.getFloat("lon"))
                , rs.getTime("start_at"));
                sports.add(sport);
            }

        } catch (Exception e) {

        }

        return sports;
    }

    @Override
    public Sport getSportById(int id) {
        String q = "SELECT * FROM sports WHERE ID = ?";
        Sport sport = null;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement prepared = connection.prepareStatement(q);
            prepared.setInt(1, id);

            ResultSet rs = prepared.executeQuery();

            while (rs.next()) {
                sport = new Sport(rs.getInt("ID")
                ,rs.getString("name")
                ,rs.getString("sportName")
                , new Location(rs.getFloat("lat"), rs.getFloat("lon"))
                , rs.getTime("start_at"));
            }

        } catch (Exception e) {

        }

        return sport;
    }

    @Override
    public void removeSportById(int id) {
        String q = "DELETE * FROM sports WHERE id = ?";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement prepared = connection.prepareStatement(q);
            prepared.setInt(1, id);

            prepared.executeQuery();
        } catch (Exception e) {
        }
    }

    @Override
    public void updateSport(Sport sport) {
        String q = "UPDATE sports" +
                "SET ID = ?," +
                "    name = ?," +
                "    sportName = ?," +
                "    lat = ?," +
                "    lon = ?" +
                "    start_at = ?" +
                "WHERE ID = ?";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement prepared = connection.prepareStatement(q);
            prepared.setInt(1, sport.getId());
            prepared.setString(2, sport.getName());
            prepared.setString(3, sport.getSportName());
            prepared.setFloat(4, sport.getLocation().getLat());
            prepared.setFloat(5, sport.getLocation().getLon());
            prepared.setTime(6, sport.getTime());
            prepared.setInt(7, sport.getId());

            prepared.executeQuery();

        } catch (Exception e) {
        }

    }

    @Override
    public void insertSportToDb(Sport sport) {
        String q = "INSERT INTO sports(ID, name, sportName, lat, lon, start_at)" +
                "VALUES (?,?,?,?,?,?)";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement prepared = connection.prepareStatement(q);
            prepared.setInt(1, sport.getId());
            prepared.setString(2, sport.getName());
            prepared.setString(3, sport.getSportName());
            prepared.setFloat(4, sport.getLocation().getLat());
            prepared.setFloat(5, sport.getLocation().getLon());
            prepared.setTime(6, sport.getTime());

            prepared.executeQuery();

        } catch (Exception e) {
        }
    }

    @Override
    public Collection <Player> getAllPlayersForSport(Sport sport) {
        ArrayList<Player> players = new ArrayList<>();
        String q = "SELECT * FROM players WHERE sport_id = ?";

        try (Connection connection = dataSource.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(q);
            statement.setInt(1, sport.getId());

            ResultSet rs = statement.executeQuery(q);

            while (rs.next()) {
                Player player = new Player(rs.getInt("id")
                ,rs.getString("playerName")
                , rs.getInt("sport_id"));
                players.add(player);
            }

        } catch (Exception e) {
        }

        return players;
    }

    @Override
    public void removePlayerById(int id) {
        String q = "DELETE * FROM players WHERE id = ?";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement prepared = connection.prepareStatement(q);
            prepared.setInt(1, id);

            prepared.executeQuery();
        } catch (Exception e) {
        }
    }

    @Override
    public void updatePlayer(Player player) {
        String q = "UPDATE players" +
                "SET id = ?," +
                "    playerName = ?," +
                "    sport_id = ?" +
                "WHERE id = ?";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement prepared = connection.prepareStatement(q);
            prepared.setInt(1, player.getId());
            prepared.setString(2, player.getName());
            prepared.setInt(3, player.getSportId());
            prepared.setInt(4, player.getId());

            prepared.executeQuery();

        } catch (Exception e) {
        }

    }

    @Override
    public void insertPlayerToSport(Player player, int sportId) {
        String q = "INSERT INTO players(id, playerName, lon)" +
                "VALUES (?,?,?)";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement prepared = connection.prepareStatement(q);
            prepared.setInt(1, player.getId());
            prepared.setString(2, player.getName());
            prepared.setInt(3, sportId);

            prepared.executeQuery();

        } catch (Exception e) {
        }
    }

    @Override
    public String db(Map<String, Object> model) {


        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS sports (sport timestamp)");
            statement.executeUpdate("INSERT INTO sports(name) VALUES ('Z')");
            ResultSet resultSet = statement.executeQuery("SELECT name FROM sports");

            ArrayList<String> output = new ArrayList<String>();
            while (resultSet.next()) {
                output.add("Read from DB: " + resultSet.getString("sport"));
            }

            model.put("records", output);
            return "db";
        } catch (Exception e) {
            model.put("message", e.getMessage());
            return "Error: " + e.getMessage();
        }
    }

}
