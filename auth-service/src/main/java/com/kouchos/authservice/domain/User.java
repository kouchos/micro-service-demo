package com.kouchos.authservice.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Builder
public class User {
    @Id
    @Column(name = "Id")
    private Long id;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "Disabled")
    private boolean disabled;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Account_ID")
    private Account account;


}
