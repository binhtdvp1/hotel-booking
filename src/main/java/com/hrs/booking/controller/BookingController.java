package com.hrs.booking.controller;

import com.hrs.booking.dto.request.BookingRequest;
import com.hrs.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public HttpEntity<?> createBooking(@RequestBody BookingRequest request) {
        return new ResponseEntity<>(bookingService.create(request),HttpStatus.OK);
    }

    @GetMapping("/viewHotelBooking")
    public HttpEntity<?> viewHotelBooking(@RequestParam int userId) {
        return new ResponseEntity<>(bookingService.viewBookingDetail(userId),HttpStatus.OK);
    }

    @PostMapping("/user/rating")
    public HttpEntity<?> userRating( ) {
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
