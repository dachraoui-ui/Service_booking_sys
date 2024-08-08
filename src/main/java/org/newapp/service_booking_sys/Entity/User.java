package org.newapp.service_booking_sys.Entity;


import jakarta.persistence.*;
import lombok.Data;
import org.newapp.service_booking_sys.Enums.UserRole;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    private String password;

    private String name;

    private String lastname;

    private String phone;

    private UserRole role;



}
