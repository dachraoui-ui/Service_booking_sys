package org.newapp.service_booking_sys.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.newapp.service_booking_sys.Dto.ReservationDTO;
import org.newapp.service_booking_sys.Enums.ReservationStatus;
import org.newapp.service_booking_sys.Enums.ReviewStatus;

import java.util.Date;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ReservationStatus reservationStatus;

    private ReviewStatus reviewStatus;

    private Date bookDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User company;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ad_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ad ad;

    public ReservationDTO getReservationDTO(){
        ReservationDTO dto = new ReservationDTO();
        dto.setId(id);
        dto.setServiceName(ad.getServiceName());
        dto.setBookDate(bookDate);
        dto.setReservationStatus(reservationStatus);
        dto.setReviewStatus(reviewStatus);
        dto.setUserId(user.getId());
        dto.setCompanyId(company.getId());
        dto.setUserName(user.getName());

        return dto;
    }
}
