CREATE TABLE sports (
  ID serial PRIMARY KEY
  , name VARCHAR (50) NOT NULL
  , sportName VARCHAR (50) NOT NULL
  , lat FLOAT NOT NULL
  , lon FLOAT NOT NULL
  , start_at TIME (0)
);

INSERT INTO sports(name, sportName, lat, lon)
VALUES ('Zach', 'Soccer', 100, 100);

CREATE TABLE players (
  id SERIAL PRIMARY KEY
  , playerName VARCHAR (50)
  , sport_id INT
);

INSERT INTO players(playerName, sport_id)
VALUES ('Joe', 1);