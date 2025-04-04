package com.example.demo.entity;

import com.example.demo.dto.UserDTO;
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

    public void updateFromDTO(UserDTO dto) {
        if (dto.getName() != null) this.name = dto.getName();
        if (dto.getEmail() != null) this.email = dto.getEmail();
        if (dto.getAge() != null) this.age = dto.getAge();
        if (dto.getPhone() != null) this.phone = dto.getPhone();
        if (dto.getPassword() != null) this.password = dto.getPassword();
    }


}
