package com.hrs.booking.service;

import com.hrs.booking.dto.request.HotelRegisterRequest;
import com.hrs.booking.dto.request.HotelSearchRequest;
import com.hrs.booking.dto.request.RoomTypeRequest;
import com.hrs.booking.dto.response.SearchHotelResponse;
import com.hrs.booking.exception.InvalidHotelException;
import com.hrs.booking.model.Hotel;
import com.hrs.booking.model.RoomType;
import com.hrs.booking.repository.HotelRepository;
import com.hrs.booking.repository.RoomTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    @Transactional
    public Hotel registerHotel(HotelRegisterRequest payload) throws InvalidHotelException {

        log.info("Start - registerHotel {}", payload.getHotelName());

        if (hotelRepository.findByHotelCode(payload.getHotelCode()).isPresent()) {
            throw new InvalidHotelException("Hotel is existed");
        }

        var hotel = new Hotel();
        hotel.setHotelName(payload.getHotelName());
        hotel.setHotelCode(payload.getHotelCode());
        hotel.setHotelAddress(payload.getHotelAddress());
        hotel.setActiveFlag(1);
        hotel = hotelRepository.save(hotel);

        var roomTypes = new ArrayList<RoomType>();
        for (RoomTypeRequest request : payload.getRoomTypeRequestList()) {
            RoomType roomType = new RoomType();
            roomType.setRefHotelCode(hotel.getHotelCode());
            roomType.setRoomTypeName(request.getRoomTypeName());
            roomType.setRoomTypeCode(request.getRoomTypeCode());
            roomType.setPrice(request.getPrice());
            roomType.setActiveFlag(1);
            roomTypes.add(roomType);
        }
        roomTypeRepository.saveAll(roomTypes);

        return hotel;
    }

    @Override
    public Page<SearchHotelResponse> search(HotelSearchRequest payload, Pageable pageable) {

        log.info("Start - search hotel: hotelName = {} And hotelAddress = {}", payload.getHotelName(), payload.getAddress());

        Page<Hotel> hotelList = hotelRepository.searchHotel(payload.getHotelName(), payload.getAddress(), pageable);
        List<SearchHotelResponse> responseList = new ArrayList<>();
        for (Hotel hotel : hotelList.toList()) {
            List<RoomType> roomTypeList = roomTypeRepository.findByRefHotelCode(hotel.getHotelCode());
            SearchHotelResponse response = SearchHotelResponse.builder()
                    .hotel(hotel)
                    .roomTypeList(roomTypeList)
                    .build();

            responseList.add(response);
        }

        return new PageImpl<>(responseList, pageable, hotelList.getTotalElements());
    }
}
