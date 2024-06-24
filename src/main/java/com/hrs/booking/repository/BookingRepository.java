package com.hrs.booking.repository;

import com.hrs.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    @Query(value = "Select b From Booking b Where b.refUserId = :userId And b.status = :bookingStatus And b.activeFlag = 1")
    List<Booking> findByUserAndBookingStatus(@Param("userId") int userId, @Param("bookingStatus") String bookingStatus);
}
