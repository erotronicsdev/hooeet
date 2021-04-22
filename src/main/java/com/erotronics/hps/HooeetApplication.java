package com.erotronics.hps;

import com.erotronics.hps.domain.LiveEvent;
import com.erotronics.hps.domain.SongLyrics;
import com.erotronics.hps.persistence.LiveEventRedisRepository;
import com.erotronics.hps.persistence.SongLyricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
@ComponentScan({"com.erotronics.hps.controller", "com.erotronics.hps.service", "com.erotronics.hps.converter", "com.erotronics.hps.config.WebConfig" })
public class HooeetApplication implements CommandLineRunner {

	@Autowired
	private LiveEventRedisRepository liveEventRepository;
	@Autowired
	private SongLyricsRepository songLyricsRepository;

	public static void main(String[] args) {
		SpringApplication.run(HooeetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		liveEventRepository.save(new LiveEvent("1226", "Amazing Grace", "Verse 4"));

		String filePaths = "/Users/User/Development/hooeet-service/src/main/resources/";

		List<String> listSongs = new ArrayList<>();
		listSongs.add("amazinggrace");
		listSongs.add("greatisthyfaithfulness");
		listSongs.add("howgreatthouart");
		listSongs.add("inchristalone");

		listSongs.forEach(song -> {
			String songLyrics = readAllBytesJava7(filePaths + song + ".json");
			songLyricsRepository.save(new SongLyrics("seledev", song, songLyrics));
			System.out.println(songLyricsRepository.count());
		});


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
