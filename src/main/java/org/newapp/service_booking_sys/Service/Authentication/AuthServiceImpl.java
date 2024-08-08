package org.newapp.service_booking_sys.Service.Authentication;


import org.newapp.service_booking_sys.Dto.SignUpRequestDTO;
import org.newapp.service_booking_sys.Entity.User;
import org.newapp.service_booking_sys.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UserRepository userRepository;
    public userDto signupClient(SignUpRequestDTO signUpRequestDTO){
        User user = new User();
        user.setName(signUpRequestDTO.getName());
        user.setLastname(signUpRequestDTO.getLastname());
        user.setEmail(signUpRequestDTO.getEmail());


    }
}
