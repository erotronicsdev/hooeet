package com.erotronics.hps.service;

import com.erotronics.hps.domain.LiveEvent;
import com.erotronics.hps.persistence.LiveEventRedisRepository;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class SongBookService {
    @Autowired
    LiveEventRedisRepository liveEventRepository;

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

    public String getEvent(String eventCode) {
       String liveEvents = liveEventRepository.findById(eventCode).get().getCurrentVerse();
        return  liveEvents;
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
}
