package com.hrs.booking.service;

import com.hrs.booking.dto.request.HotelRegisterRequest;
import com.hrs.booking.dto.request.HotelSearchRequest;
import com.hrs.booking.dto.response.SearchHotelResponse;
import com.hrs.booking.exception.InvalidHotelException;
import com.hrs.booking.model.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HotelService {

    Hotel registerHotel(HotelRegisterRequest payload) throws InvalidHotelException;

    Page<SearchHotelResponse> search(HotelSearchRequest payload, Pageable pageable);
}
