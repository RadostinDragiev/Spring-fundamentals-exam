package com.philately.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    // TODO: Delete when logout
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Stamp> wishedStamps;

    @ManyToMany
    private Set<Stamp> purchasedStamps;
}
