package org.newapp.service_booking_sys.Dto;

import lombok.Data;
import org.newapp.service_booking_sys.Entity.User;
import org.newapp.service_booking_sys.Enums.UserRole;

@Data
public class UserDto {
    private long id;

    private String email;

    private String password;

    private String name;

    private String lastname;

    private String phone;

    private UserRole role;
    public UserDto getDto(){
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName(name);
        userDto.setEmail(email);
        userDto.setRole(role);
        return userDto;
    }
}
