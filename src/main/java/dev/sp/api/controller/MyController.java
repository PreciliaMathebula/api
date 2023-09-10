package dev.sp.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@RestController
public class MyController {

    @GetMapping("/api")
    public Map<String, Object> getEndpointData(
            @RequestParam("slack_name") String slackName,
            @RequestParam("track") String track) {

        // Validate input
        if (slackName == null || track == null) {
            throw new IllegalArgumentException("Both slack_name and track parameters are required.");
        }


        // Get current day of the week
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String currentDay = sdf.format(new Date());

        // Get current UTC time
        SimpleDateFormat utcSdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        utcSdf.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        String utcTime = utcSdf.format(new Date());

        // Construct the response
        Map<String, Object> response = new HashMap<>();
        response.put("slack_name", slackName);
        response.put("current_day", currentDay);
        response.put("utc_time", utcTime);
        response.put("track", track);
        response.put("github_file_url", "https://github.com/PreciliaMathebula/api/blob/main/api/src/main/java/dev/sp/api/ApiApplication.java");
        response.put("github_repo_url", "https://github.com/PreciliaMathebula/api");
        response.put("status_code", 200);

        return response;
    }
}

