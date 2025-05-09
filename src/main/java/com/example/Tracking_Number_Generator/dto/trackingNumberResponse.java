package com.example.Tracking_Number_Generator.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class trackingNumberResponse {

    private String tracking_number;
    private String created_at;
    private String customer_name;
    private String customer_id;

    public trackingNumberResponse(String tracking_number, String created_at, String customer_id, String customer_name) {
        this.tracking_number = tracking_number;
        this.created_at = created_at;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
    }

    public String getTrackingNumber() {
        return tracking_number;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public String getCustomerName() {
        return customer_name;
    }

    public String getCustomerId() {
        return customer_id;
    }
}
