package com.hrs.booking.service;

import com.hrs.booking.dto.request.BookingRequest;
import com.hrs.booking.dto.response.BookingDetailResponse;
import com.hrs.booking.model.Booking;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface BookingService {

    Booking create(BookingRequest payload);

    List<BookingDetailResponse> viewBookingDetail(int userId);
}
