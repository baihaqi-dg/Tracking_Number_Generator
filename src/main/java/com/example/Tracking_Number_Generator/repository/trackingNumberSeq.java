package com.example.Tracking_Number_Generator.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class trackingNumberSeq {
    
    private JdbcTemplate jdbcTemplate;

    public trackingNumberSeq(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long getNextSequence() {
        return jdbcTemplate.queryForObject(
            "SELECT nextval('tracking_number_seq')", Long.class
        );
    }
}
