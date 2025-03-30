package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "age")
    private Long age;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "create_time")
    private Date createTime;

}
