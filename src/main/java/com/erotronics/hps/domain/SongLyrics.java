package com.erotronics.hps.domain;


import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class SongLyrics implements Serializable {

    @Id
    @GeneratedValue
    private long songId;
    private String userName;
    private String songName;
    private String songLyrics;

    public SongLyrics() {}

    public SongLyrics(String userName, String songName, String songLyrics) {
        this.userName = userName;
        this.songName = songName;
        try {
            this.songLyrics = (new JSONArray(songLyrics)).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
