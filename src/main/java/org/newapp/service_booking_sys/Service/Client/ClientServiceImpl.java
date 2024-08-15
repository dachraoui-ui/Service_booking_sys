package org.newapp.service_booking_sys.Service.Client;

import org.newapp.service_booking_sys.Dto.AdDTO;
import org.newapp.service_booking_sys.Dto.ReservationDTO;
import org.newapp.service_booking_sys.Entity.Ad;
import org.newapp.service_booking_sys.Entity.Reservation;
import org.newapp.service_booking_sys.Entity.User;
import org.newapp.service_booking_sys.Enums.ReservationStatus;
import org.newapp.service_booking_sys.Enums.ReviewStatus;
import org.newapp.service_booking_sys.Repository.AdRepository;
import org.newapp.service_booking_sys.Repository.ReservationRepository;
import org.newapp.service_booking_sys.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private AdRepository adRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<AdDTO> getAllAds() {
        return adRepository.findAll().stream().map(Ad::getAdDTO).collect(Collectors.toList());
    }
    public List<AdDTO> searchAdByName(String name){
        return adRepository.findAllByServiceNameContaining(name).stream().map(Ad::getAdDTO).collect(Collectors.toList());
    }
    public boolean bookService(ReservationDTO reservationDTO){
        Optional<Ad> optionalAd = adRepository.findById(reservationDTO.getAdId());
        Optional<User> optionalUser = userRepository.findById(reservationDTO.getUserId());
        if(optionalAd.isPresent() && optionalUser.isPresent()){
            Reservation reservation = new Reservation();
            reservation.setBookDate(reservationDTO.getBookDate());
            reservation.setReservationStatus(ReservationStatus.PENDING);
            reservation.setUser(optionalUser.get());

            reservation.setAd(optionalAd.get());
            reservation.setCompany(optionalAd.get().getUser());
            reservation.setReviewStatus(ReviewStatus.FALSE);

            reservationRepository.save(reservation);
        }
        return false;
    }
}
