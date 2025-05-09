package com.example.Tracking_Number_Generator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Tracking_Number_Generator.dto.trackingNumberResponse;
import com.example.Tracking_Number_Generator.services.trackingServices;

@RestController
@RequestMapping("/next-tracking-number")
public class trackingController {

    private final trackingServices trackingService;

    public trackingController(trackingServices trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping
    public ResponseEntity<trackingNumberResponse> getNextTrackingNumber(
        @RequestParam(required = true) String origin_country_id,
        @RequestParam(required = true) String destination_country_id,
        String weight,
        @RequestParam(required = true) String created_at,
        String customer_id,
        String customer_name,
        String customer_slug) {

        if (created_at.contains(" ")) {
            created_at = created_at.replace(" ", "+");
        }

        trackingNumberResponse result = trackingService.generateTrackingNumber(
                origin_country_id, destination_country_id, created_at
        );

        return ResponseEntity.ok(result);
    }
}
