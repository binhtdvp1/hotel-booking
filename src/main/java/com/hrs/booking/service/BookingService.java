package com.hrs.booking.service;

import com.hrs.booking.dto.request.BookingRequest;
import com.hrs.booking.dto.response.BookingDetailResponse;
import com.hrs.booking.model.Booking;

import java.util.List;

public interface BookingService {

    Booking create(BookingRequest request);

    List<BookingDetailResponse> viewBookingDetail(int userId);
}
