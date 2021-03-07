package com.erotronics.hps.controller;

import com.erotronics.hps.domain.LiveEvent;
import com.erotronics.hps.service.SongBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/songbook")
public class SongBookController {
@Autowired
  private SongBookService songBookService;

@RequestMapping(
            value = "/currentsong/1234",
            headers = { "church=globe", "town=reading" }, consumes = MediaType.ALL_VALUE, method =  RequestMethod.GET)
    public String currentSongPosition() {
        return "Verse 4";
    }

    @RequestMapping(
            value = "/live/song/1234",
            headers = { "church=globe", "town=reading" }, consumes = MediaType.ALL_VALUE, method =  RequestMethod.GET)
    public String liveSong() {
        return songBookService.fileReader();
    }

    @RequestMapping(
            value = "/events",
            headers = { "church=globe", "town=reading" }, consumes = MediaType.ALL_VALUE, method =  RequestMethod.GET)
    public List events() {
        return songBookService.getAllEvents();
    }

    @RequestMapping(
            value = "/eventscode/{eventCode}",
            headers = { "church=globe", "town=reading" }, consumes = MediaType.ALL_VALUE, method =  RequestMethod.GET)
    public String eventsCode(@PathVariable String eventCode) {
        return songBookService.getEvent(eventCode);
    }

    @RequestMapping(
            value = "/events/update",
            headers = { "church=globe", "town=reading" }, consumes = MediaType.ALL_VALUE, method =  RequestMethod.POST)
    public LiveEvent eventsUpdate(@RequestBody LiveEvent postcode) {
         return songBookService.updateSong(postcode);
    }

    @RequestMapping(
            value = "/events/update",
            headers = { "church=globe", "town=reading" }, consumes = MediaType.ALL_VALUE, method =  RequestMethod.DELETE)
    public HttpStatus deleteAll() {
        songBookService.clearCache();
        return HttpStatus.ACCEPTED;
    }

}
