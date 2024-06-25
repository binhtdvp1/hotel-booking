package com.hrs.booking.service;

import com.hrs.booking.config.JwtGenerator;
import com.hrs.booking.dto.response.BookingDetailResponse;
import com.hrs.booking.enums.BookingStatus;
import com.hrs.booking.dto.request.BookingRequest;
import com.hrs.booking.handler.UserLoginHandler;
import com.hrs.booking.model.Booking;
import com.hrs.booking.model.Hotel;
import com.hrs.booking.model.RoomType;
import com.hrs.booking.repository.BookingRepository;
import com.hrs.booking.repository.HotelRepository;
import com.hrs.booking.repository.RoomTypeRepository;
import com.hrs.booking.util.DateTimeUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private UserLoginHandler userLoginHandler;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    @Transactional
    public Booking create(BookingRequest payload) {

        log.info("Start - register booking for user");

        Booking booking = new Booking();
        booking.setActiveFlag(1);
        booking.setStatus(BookingStatus.WAITING_CHECK_IN.name());
        booking.setFromDate(DateTimeUtils.clearTime(payload.getFromDate()));
        booking.setToDate(DateTimeUtils.clearTime(payload.getToDate()));
        booking.setRefHotelId(payload.getHotelId());
        booking.setRefRoomTypeId(payload.getRoomTypeId());
        booking.setRefUserId(userLoginHandler.getLoginUserId());
        booking.setCreatedBy("system");
        booking.setUpdatedBy("system");

        return bookingRepository.save(booking);
    }

    @Override
    public List<BookingDetailResponse> viewBookingDetail(int userId) {

        log.info("Start - view booking detail");

        return bookingRepository.findByUserAndBookingStatus(userId,BookingStatus.WAITING_CHECK_IN.name()).stream().map(this::convert).toList();
    }

    private BookingDetailResponse convert(Booking booking) {

        log.info("Start - convert booking detail");

        Hotel hotel = hotelRepository.findById(booking.getRefHotelId()).orElseThrow();
        RoomType roomType = roomTypeRepository.findById(booking.getRefRoomTypeId()).orElseThrow();
        BookingDetailResponse response = new BookingDetailResponse();
        response.setFromDate(booking.getFromDate());
        response.setToDate(booking.getToDate());
        response.setHotelAddress(hotel.getHotelAddress());
        response.setHotelName(hotel.getHotelName());
        response.setRoomType(roomType.getRoomTypeName());
        response.setTotalPrice(roomType.getPrice().multiply(new BigDecimal(DateTimeUtils.dateDiff(booking.getFromDate(),booking.getToDate()))));
        return response;
    }
}
