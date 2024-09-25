package com.userservice.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "f_name")
    private  String f_name;
    @Column(name = "l_name")
    private String l_name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

}
