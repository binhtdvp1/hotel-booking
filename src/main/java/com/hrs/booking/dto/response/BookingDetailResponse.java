package com.hrs.booking.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookingDetailResponse {

    private String hotelName;
    private String hotelAddress;
    private String roomType;
    private Date fromDate;
    private Date toDate;
    private BigDecimal totalPrice;
}
