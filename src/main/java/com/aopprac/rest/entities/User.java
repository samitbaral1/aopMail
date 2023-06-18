package com.aopprac.rest.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 55)
    private String email;
    @Column(nullable = false, length = 64)
    private String password;
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
    @Column(name = "last_Name", nullable = false, length = 20)
    private String lastName;
    @Column(name = "middle_name", length = 20)
    private String middleName;

}
