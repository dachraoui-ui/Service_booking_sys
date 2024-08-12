package org.newapp.service_booking_sys.Repository;

import org.newapp.service_booking_sys.Entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad,Long> {
    List<Ad> findAllByUserId(Long userId);
}
