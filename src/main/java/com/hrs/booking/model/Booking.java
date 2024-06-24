package com.hrs.booking.model;

import com.hrs.booking.enums.BookingStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private long bookingId;

    @Column(name = "ref_user_id")
    private long refUserId;

    @Column(name = "ref_hotel_id")
    private long refHotelId;

    @Column(name = "ref_room_type_id")
    private long refRoomTypeId;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;

    @Column(name = "active_flag")
    private int activeFlag;

    @Column(name = "status")
    private String status;
}
