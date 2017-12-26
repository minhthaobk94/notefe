package com.thaontm.project.notefescrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scrapper {

    private static final Logger log = LoggerFactory.getLogger(Scrapper.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "0 44 17 * * ?") // 17:44:00 everyday
    public void scrape() {
        log.info("Started scrapping at {}", dateFormat.format(new Date()));
    }
}
