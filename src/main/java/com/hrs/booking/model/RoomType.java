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
@Table(name = "room_type")
public class RoomType extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_id")
    private long roomTypeId;

    @Column(name = "room_type_code")
    private String roomTypeCode;

    @Column(name = "room_type_name")
    private String roomTypeName;

    @Column(name = "ref_hotel_code")
    private String refHotelCode;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "active_flag")
    private int activeFlag;

    @Column(name = "quantity")
    private int quantity;
}
