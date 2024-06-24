package com.hrs.booking.repository;

import com.hrs.booking.dto.request.HotelSearchRequest;
import com.hrs.booking.model.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {

    Optional<Hotel> findByHotelCode(String hotelCode);

    @Query(value = "Select h " +
                   "From Hotel h " +
                   "Where (:hotelName Is Null Or h.hotelName Like %:hotelName% ) " +
                   "And (:address Is Null Or h.hotelAddress Like %:address% )")
    Page<Hotel> searchHotel(@Param("hotelName") String hotelName, @Param("address") String address, Pageable pageable);
}
