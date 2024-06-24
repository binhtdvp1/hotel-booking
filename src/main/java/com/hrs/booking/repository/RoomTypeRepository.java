package com.hrs.booking.repository;

import com.hrs.booking.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType,Long> {

    List<RoomType> findByRefHotelCode(String refHotelCode);
}
