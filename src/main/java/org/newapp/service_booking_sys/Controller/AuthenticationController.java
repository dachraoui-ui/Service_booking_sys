package org.newapp.service_booking_sys.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.newapp.service_booking_sys.Dto.AuthenticationRequest;
import org.newapp.service_booking_sys.Dto.SignUpRequestDTO;
import org.newapp.service_booking_sys.Dto.UserDto;
import org.newapp.service_booking_sys.Entity.User;
import org.newapp.service_booking_sys.Repository.UserRepository;
import org.newapp.service_booking_sys.Service.Authentication.AuthService;
import org.newapp.service_booking_sys.Service.Jwt.UserDetailsServiceImpl;
import org.newapp.service_booking_sys.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

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
    @PostMapping("/authenticate")
    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws JSONException, IOException {
        try{
            authenticationManager.authenticate(new
                    UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()
            ));
        }
        catch (BadCredentialsException e){
            throw new BadCredentialsException("Incorrect username or password",e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        User user = userRepository.findFirstByEmail(authenticationRequest.getUsername());

        response.getWriter().write(new JSONObject()
                .put("userId",user.getId())
                .put("role",user.getRole())
                        .toString()
                );

        response.addHeader("Access-Control-Expose-Headers","Authorization");
        response.addHeader("Access-Control-Allow-Headers","Authorization ," +
                "X-PINGOTHER , Origin, X-Requested-With , Content-Type , Accept , X-Custom-header");

        response.addHeader(HEADER_STRING,TOKEN_PREFIX+jwt);
    }


}
