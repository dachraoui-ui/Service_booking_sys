package org.newapp.service_booking_sys.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.newapp.service_booking_sys.Dto.SignUpRequestDTO;
import org.newapp.service_booking_sys.Dto.UserDto;
import org.newapp.service_booking_sys.Service.Authentication.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "Authorization";

    @PostMapping("/client/sign-up")
    public ResponseEntity<?> signupClient(@RequestBody SignUpRequestDTO signUpRequestDTO){
        if (authService.presentByEmail(signUpRequestDTO.getEmail())){
            return new ResponseEntity<>("Client already exists with this email ", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createUser = authService.signupClient(signUpRequestDTO);
        return new ResponseEntity<>(createUser,HttpStatus.OK);
    }
    @PostMapping("/company/sign-up")
    public ResponseEntity<?> signupCompany(@RequestBody SignUpRequestDTO signUpRequestDTO){
        if (authService.presentByEmail(signUpRequestDTO.getEmail())){
            return new ResponseEntity<>("Company already exists with this email ", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createUser = authService.signupCompany(signUpRequestDTO);
        return new ResponseEntity<>(createUser,HttpStatus.OK);
    }
    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse httpServletResponsef){
        try{
            authenticationRequest.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
        }
        catch ()
    }

}
