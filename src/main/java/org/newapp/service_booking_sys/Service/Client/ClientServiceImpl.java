package org.newapp.service_booking_sys.Service.Client;

import org.newapp.service_booking_sys.Dto.AdDTO;
import org.newapp.service_booking_sys.Entity.Ad;
import org.newapp.service_booking_sys.Repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private AdRepository adRepository;

    public List<AdDTO> getAllAds() {
        return adRepository.findAll().stream().map(Ad::getAdDTO).collect(Collectors.toList());
    }
    public List<AdDTO> searchAdByName(String name){
        return adRepository.findAllByServiceNameContaining(name).stream().map(Ad::getAdDTO).collect(Collectors.toList());
    }
}
