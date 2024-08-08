package org.newapp.service_booking_sys.Dto;

import lombok.Data;
import org.newapp.service_booking_sys.Enums.UserRole;

@Data
public class SignUpRequestDTO {
    private long id;

    private String email;

    private String password;

    private String name;

    private String lastname;

    private String phone;

    private UserRole role;
}
