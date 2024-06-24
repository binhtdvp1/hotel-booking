package com.hrs.booking.dto.request;

import lombok.Data;

@Data
public class JwtTokenRequest {

    private String email;
    private String password;
}
