package com.kouchos.authservice.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Builder
@ToString
public class Account {
    @Id
    @Column(name = "Id")
    private Long id;
    @Column(name = "Account_Name")
    private String accountName;
    @Column(name = "Disabled")
    private boolean disabled;
    @Column(name = "Account_Locked")
    private boolean accountLocked;
    @Column(name = "Account_Expiry")
    private LocalDate accountExpiry;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<User> users;
}
