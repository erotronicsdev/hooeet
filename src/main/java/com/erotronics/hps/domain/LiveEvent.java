package com.erotronics.hps.domain;


import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@RedisHash("LIVE_EVENTS")
public class LiveEvent implements Serializable {

    @Id
    private String id;
    private String liveSong;
    private String currentVerse;

    public LiveEvent() {}

    public LiveEvent(String id, String liveSong, String currentVerse) {
        this.id = id;
        this.liveSong = liveSong;
        this.currentVerse = currentVerse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLiveSong() {
        return liveSong;
    }

    public void setLiveSong(String liveSong) {
        this.liveSong = liveSong;
    }

    public String getCurrentVerse() {
        return currentVerse;
    }

    public void setCurrentVerse(String currentVerse) {
        this.currentVerse = currentVerse;
    }
}
