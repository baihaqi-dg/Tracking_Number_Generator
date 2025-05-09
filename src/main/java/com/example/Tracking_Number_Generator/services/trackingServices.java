package com.example.Tracking_Number_Generator.services;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.example.Tracking_Number_Generator.dto.trackingNumberResponse;
import com.example.Tracking_Number_Generator.repository.trackingNumberSeq;

@Service
public class trackingServices {

    private final trackingNumberSeq trackingRepo;

    public trackingServices(trackingNumberSeq trackingRepo) {
        this.trackingRepo = trackingRepo;
    }

    public trackingNumberResponse generateTrackingNumber(String origin_country_id, 
                                         String destination_country_id, 
                                         String created_at,
                                         String customer_id,
                                         String customer_name) {
                                            
        if (!isValidCountryCode(origin_country_id)) {
            throw new IllegalArgumentException("Invalid origin_country_id: " + origin_country_id);
        }
        if (!isValidCountryCode(destination_country_id)) {
            throw new IllegalArgumentException("Invalid destination_country_id: " + destination_country_id);
        }
        
        OffsetDateTime createdDate;
        try { 
            if (created_at.contains(" ")) {
                created_at = created_at.replace(" ", "+");
            }
            createdDate = OffsetDateTime.parse(created_at);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format for created_at: " + created_at);
        }

        String dayCode = String.format("%02d%02d%02d",createdDate.getYear() % 100,createdDate.getMonthValue(),createdDate.getDayOfMonth());

        long sequence = trackingRepo.getNextSequence();
        String counter = String.format("%04d", sequence);

        // Generate the tracking number
        String trackingNumber = (origin_country_id + destination_country_id + dayCode+counter).toUpperCase();

        // Validate the format
        if (!trackingNumber.matches("^[A-Z0-9]{1,16}$")) {
            throw new IllegalStateException("Generated tracking number is invalid: " + trackingNumber);
        }

        return new trackingNumberResponse(trackingNumber,createdDate.toString(),customer_id,customer_name);
    }

    private boolean isValidCountryCode(String code) {
        return code != null && code.matches("^[A-Z]{2}$") && Arrays.asList(Locale.getISOCountries()).contains(code);
    }

}
