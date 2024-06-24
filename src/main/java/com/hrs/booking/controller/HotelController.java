package com.hrs.booking.controller;

import com.hrs.booking.dto.request.HotelRegisterRequest;
import com.hrs.booking.dto.request.HotelSearchRequest;
import com.hrs.booking.exception.InvalidHotelException;
import com.hrs.booking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/admin/register")
    public HttpEntity<?> register(@RequestBody HotelRegisterRequest request) throws InvalidHotelException {
        try{
            return new ResponseEntity<>(hotelService.registerHotel(request), HttpStatus.OK);
        }catch (InvalidHotelException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user/search")
    public HttpEntity<?> search(@RequestBody HotelSearchRequest request, Pageable pageable) {
        return new ResponseEntity<>(hotelService.search(request, pageable), HttpStatus.OK);
    }
}
