package com.hrs.booking.dto.request;

import lombok.Data;

@Data
public class UserRegisterRequest {

    private String password;
    private String email;
    private String phoneNumber;
}
