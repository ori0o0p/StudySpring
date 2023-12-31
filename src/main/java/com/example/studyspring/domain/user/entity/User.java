package com.example.studyspring.domain.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String accountId;
    @Column
    private String password;

    @Builder
    public User(String name, String email, String accountId, String password) {
        this.name = name;
        this.accountId = accountId;
        this.email = email;
        this.password = password;
    }

}
