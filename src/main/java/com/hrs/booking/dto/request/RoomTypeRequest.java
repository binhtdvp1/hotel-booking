package com.hrs.booking.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomTypeRequest {

    @NotEmpty(message = "room type name must not be empty")
    @NotNull(message = "room type name must not be null")
    private String roomTypeName;

    @NotEmpty(message = "room type code must not be empty")
    @NotNull(message = "room type code must not be null")
    private String roomTypeCode;

    private BigDecimal price;
}
