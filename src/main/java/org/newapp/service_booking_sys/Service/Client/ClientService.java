package org.newapp.service_booking_sys.Service.Client;

import org.newapp.service_booking_sys.Dto.AdDTO;
import org.newapp.service_booking_sys.Dto.AdDetailsForClientDTO;
import org.newapp.service_booking_sys.Dto.ReservationDTO;
import org.newapp.service_booking_sys.Dto.ReviewDTO;

import java.util.List;

public interface ClientService {
    List<AdDTO> getAllAds();
    List<AdDTO> searchAdByName(String name);
    boolean bookService(ReservationDTO reservationDTO);
    AdDetailsForClientDTO getAdDetailsByAdId(Long adId);
    List<ReservationDTO> getAllBookingsByUserId(Long userId);
    boolean giveReview(ReviewDTO reviewDTO);

}
