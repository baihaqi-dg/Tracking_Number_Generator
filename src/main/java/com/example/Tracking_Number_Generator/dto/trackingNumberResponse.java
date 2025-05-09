package com.example.Tracking_Number_Generator.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class trackingNumberResponse {

    private String tracking_number;
    private String created_at;

    public trackingNumberResponse(String tracking_number, String created_at) {
        this.tracking_number = tracking_number;
        this.created_at = created_at;
    }

    public String getTrackingNumber() {
        return tracking_number;
    }

    public String getCreatedAt() {
        return created_at;
    }
}
