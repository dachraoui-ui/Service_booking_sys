package org.newapp.service_booking_sys.Repository;

import org.newapp.service_booking_sys.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
