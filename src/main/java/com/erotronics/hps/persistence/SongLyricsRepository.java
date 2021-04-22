package com.erotronics.hps.persistence;

import com.erotronics.hps.domain.SongLyrics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongLyricsRepository extends CrudRepository<SongLyrics, Object> {
}
