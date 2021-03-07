package com.erotronics.hps;

import com.erotronics.hps.domain.LiveEvent;
import com.erotronics.hps.persistence.LiveEventRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan({"com.erotronics.hps.controller", "com.erotronics.hps.service" })
public class HooeetApplication implements CommandLineRunner {

	@Autowired
	private LiveEventRedisRepository liveEventRepository;

	public static void main(String[] args) {
		SpringApplication.run(HooeetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		liveEventRepository.save(new LiveEvent("1226", "Amazing Grace", "Verse 4"));
	}

}
