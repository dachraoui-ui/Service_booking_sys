package org.newapp.service_booking_sys.Dto;

import lombok.Data;

import org.newapp.service_booking_sys.Enums.ReservationStatus;
import org.newapp.service_booking_sys.Enums.ReviewStatus;

import java.util.Date;

@Data
public class ReservationDTO {

    private Long id;

    private Date bookDate;

    private String serviceName;

    private ReservationStatus reservationStatus;

    private ReviewStatus reviewStatus;

    private Long userId;

    private String userName;

    private Long companyId;

    private Long adId;


}
