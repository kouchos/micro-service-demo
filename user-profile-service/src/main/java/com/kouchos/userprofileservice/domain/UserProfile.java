package com.kouchos.userprofileservice.domain;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@Entity
@Table(name = "UserProfile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;
    @Column(name = "Email", unique = true)
    String email;
    @Column(name = "Password")
    String password;
    @Column(name = "First_Name")
    String firstName;
    @Column(name = "Last_Name")
    String lastName;

    UserProfile() {
    }
}
