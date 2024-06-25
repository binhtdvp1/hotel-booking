package com.hrs.booking.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class BookingRequest {

    private Long hotelId;
    private Long roomTypeId;
    private Date fromDate;
    private Date toDate;
}
