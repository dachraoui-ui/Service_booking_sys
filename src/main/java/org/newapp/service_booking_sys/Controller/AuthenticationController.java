package org.newapp.service_booking_sys.Controller;

import org.newapp.service_booking_sys.Dto.SignUpRequestDTO;
import org.newapp.service_booking_sys.Dto.UserDto;
import org.newapp.service_booking_sys.Service.Authentication.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthService authService;
    @PostMapping("/client/sign-up")
    public ResponseEntity<?> signupClient(@RequestBody SignUpRequestDTO signUpRequestDTO){
        if (authService.presentByEmail(signUpRequestDTO.getEmail())){
            return new ResponseEntity<>("Client already exists with this email ", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createUser = authService.signupClient(signUpRequestDTO);
        return new ResponseEntity<>(createUser,HttpStatus.OK);
    }
}
