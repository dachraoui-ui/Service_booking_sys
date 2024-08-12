package org.newapp.service_booking_sys.Service.company;

import org.newapp.service_booking_sys.Dto.AdDTO;

import java.io.IOException;

public interface CompanyService {
    boolean postAd(Long userId, AdDTO adDTO) throws IOException;
}
