package com.hrs.booking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "hotel")
public class Hotel extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hotelId;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "hotel_code")
    private String hotelCode;

    @Column(name = "hotel_address")
    private String hotelAddress;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "active_flag")
    private int activeFlag;
}
