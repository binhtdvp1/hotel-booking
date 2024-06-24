package com.hrs.booking.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class JwtTokenResponse {

    private String accessToken;
    private String tokenType;
    private Date expiredDate;
}
