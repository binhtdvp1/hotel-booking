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

@Getter
@Setter
@Entity
@Table(name = "user_rating")
public class UserRating extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_rating_id")
    private long userRatingId;

    @Column(name = "ref_booking_id")
    private long refBookingId;

    @Column(name = "rate")
    private int rate;

    @Column(name = "active_flag")
    private int activeFlag;
}
