package org.newapp.service_booking_sys.Dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;

    private String password;
}
