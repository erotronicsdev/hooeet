package com.erotronics.hps.persistence;

import com.erotronics.hps.domain.SongLyrics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface SongLyricsCustomRepository extends Repository<SongLyrics, Object> {

    @Query(value = "SELECT * From song_lyrics s WHERE s.song_name = :songName AND s.user_name = :id", nativeQuery=true)
    SongLyrics findByIdAndSongName(String id, String songName);
}
