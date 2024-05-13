package io.security.corespringsecurity.domain;

import lombok.Data;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String email;

    private int age;
    private String role;


}