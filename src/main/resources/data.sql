DROP TABLE IF EXISTS LIVE_EVENTS;

CREATE TABLE LIVE_EVENTS (
  event_code VARCHAR(250) PRIMARY KEY,
  live_song VARCHAR(250) NOT NULL,
  current_verse VARCHAR(250) DEFAULT NULL
);

INSERT INTO LIVE_EVENTS (event_code, live_song, current_verse) VALUES
  ('234567', 'amazing grace', 'verse 4'),
  ('4999559', 'amazing grace', 'verse 3');