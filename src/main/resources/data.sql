DROP TABLE IF EXISTS song_lyrics;

CREATE TABLE song_lyrics (
song_id VARCHAR(250) PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL,
  song_name VARCHAR(250) NOT NULL,
  song_lyrics VARCHAR(10000) DEFAULT NULL
);
