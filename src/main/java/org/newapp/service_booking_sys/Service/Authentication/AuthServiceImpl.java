package org.newapp.service_booking_sys.Service.Authentication;


import org.newapp.service_booking_sys.Dto.SignUpRequestDTO;
import org.newapp.service_booking_sys.Dto.UserDto;
import org.newapp.service_booking_sys.Entity.User;
import org.newapp.service_booking_sys.Enums.UserRole;
import org.newapp.service_booking_sys.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UserRepository userRepository;
    public UserDto signupClient(SignUpRequestDTO signUpRequestDTO){
        User user = new User();
        user.setName(signUpRequestDTO.getName());
        user.setLastname(signUpRequestDTO.getLastname());
        user.setEmail(signUpRequestDTO.getEmail());
        user.setPhone(signUpRequestDTO.getPhone());
        user.setPassword(signUpRequestDTO.getPassword());

        user.setRole(UserRole.CLIENT);
        return userRepository.save(user).getDto();
    }
    public boolean presentByEmail(String email){
        return userRepository.findFirstByEmail(email)!= null;
    }

    @Override
    public UserDto signupCompany(SignUpRequestDTO signUpRequestDTO) {
        User user = new User();
        user.setName(signUpRequestDTO.getName());
        user.setEmail(signUpRequestDTO.getEmail());
        user.setPhone(signUpRequestDTO.getPhone());
        user.setPassword(signUpRequestDTO.getPassword());

        user.setRole(UserRole.COMPANY);
        return userRepository.save(user).getDto();
    }
}
