package com.hrs.booking.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class HotelRegisterRequest {

    @NotEmpty(message = "hotel name must not be empty")
    @NotNull(message = "hotel name name must not be null")
    private String hotelName;

    @NotEmpty(message = "hotel code must not be empty")
    @NotNull(message = "hotel code name must not be null")
    private String hotelCode;

    private String hotelAddress;

    private int quantity;

    private List<RoomTypeRequest> roomTypeRequestList;

}
