package org.newapp.service_booking_sys.Service.Authentication;


import org.newapp.service_booking_sys.Dto.SignUpRequestDTO;
import org.newapp.service_booking_sys.Dto.UserDto;

public interface AuthService {
    UserDto signupClient(SignUpRequestDTO signUpRequestDTO);
    boolean presentByEmail(String email);
}
