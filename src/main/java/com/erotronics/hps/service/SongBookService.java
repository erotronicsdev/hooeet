package com.erotronics.hps.service;

import com.erotronics.hps.domain.Employee;
import com.erotronics.hps.domain.FullSongLyrics;
import com.erotronics.hps.domain.LiveEvent;
import com.erotronics.hps.domain.SongLyrics;
import com.erotronics.hps.persistence.LiveEventRedisRepository;
import com.erotronics.hps.persistence.SongLyricsCustomRepository;
import com.erotronics.hps.persistence.SongLyricsRepository;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SongBookService {
    @Autowired
    LiveEventRedisRepository liveEventRepository;
    @Autowired
    SongLyricsRepository songLyricsRepository;
    @Autowired
    ConversionService conversionService;
    @Autowired
    SongLyricsCustomRepository songLyricsCustomRepository;

    public String fileReader() {
        JSONParser parser = new JSONParser();
        JSONArray jsonObject = null;
        try (Reader reader = new FileReader("/Users/User/Documents/workspace/songbook/src/main/resources/amazinggrace.json")) {

            jsonObject = (JSONArray) parser.parse(reader);
            return jsonObject.toJSONString();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject.toJSONString();
    }

    public List getAllEvents() {
        List liveEvents = new ArrayList<>();
        liveEventRepository.findAll().forEach(liveEvents::add);
        return  liveEvents;
    }

    public LiveEvent getEvent(String eventCode) {
       return liveEventRepository.findById(eventCode).get();
    }

    public void clearCache() {
        liveEventRepository.deleteAll();
    }

    public LiveEvent updateSong(LiveEvent postCode) {
      if (liveEventRepository.findById(postCode.getId()).isPresent())
      {
          liveEventRepository.deleteById(postCode.getId());
      }
      return liveEventRepository.save(postCode);
    }

    public FullSongLyrics getSongLyrics() {
        log.info("Test: " +songLyricsRepository.findById("seledev").get());
        FullSongLyrics fullSongLyrics = conversionService.convert(songLyricsRepository.findById("seledev").get().getSongLyrics(), FullSongLyrics.class);
        //Employee employee= conversionService.convert("1,50000.00", Employee.class);
        log.info("Test: " +fullSongLyrics);
        return fullSongLyrics;
    }

    public void postFullSongLyrics(SongLyrics name) {

    }

    public FullSongLyrics getSongLyricsWithNameAndId(String songName) {
        //log.info("Test: " +songLyricsRepository.findById("seledev").get());
        songName.toLowerCase();
        FullSongLyrics fullSongLyrics = conversionService.convert(songLyricsCustomRepository.findByIdAndSongName("seledev", songName).getSongLyrics(), FullSongLyrics.class);
        //Employee employee= conversionService.convert("1,50000.00", Employee.class);
        log.info("Test: " +fullSongLyrics);
        return fullSongLyrics;
    }

    private static String readAllBytesJava7(String filePath)
    {
        String content = "";

        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return content;
    }
}
