package org.newapp.service_booking_sys.Service.Client;

import org.newapp.service_booking_sys.Dto.AdDTO;

import java.util.List;

public interface ClientService {
    List<AdDTO> getAllAds();
    List<AdDTO> searchAdByName(String name);
}
