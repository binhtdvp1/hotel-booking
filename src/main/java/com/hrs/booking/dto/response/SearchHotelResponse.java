package com.hrs.booking.dto.response;

import com.hrs.booking.model.Hotel;
import com.hrs.booking.model.RoomType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SearchHotelResponse {

    private Hotel hotel;
    private List<RoomType> roomTypeList;
}
