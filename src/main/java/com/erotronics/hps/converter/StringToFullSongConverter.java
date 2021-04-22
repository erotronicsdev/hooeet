package com.erotronics.hps.converter;

import com.erotronics.hps.domain.FullSongLyrics;
import com.erotronics.hps.domain.Verses;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StringToFullSongConverter implements Converter<String, FullSongLyrics> {
    @Override
    public FullSongLyrics convert(String s) {
        List<Verses> VerseList = new ArrayList<>();
        try {
            JSONArray songJsonAray = new JSONArray(s);
            for (int i= 0; i<songJsonAray.length(); i++) {
                JSONObject jsonObject = songJsonAray.getJSONObject(i);
               //String verse = (String) songJsonAray.get(i);

                String newString = jsonObject.get("words").toString();
                JSONArray verseJsonArray = new JSONArray(newString);
                List<String> list = new ArrayList<>();
                for (int x=0; x<verseJsonArray.length(); x++) {
                    list.add(verseJsonArray.getString(x) );
                }
                VerseList.add(new Verses(jsonObject.get("type").toString(), jsonObject.get("number").toString(), list));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new FullSongLyrics(VerseList);
    }
}
