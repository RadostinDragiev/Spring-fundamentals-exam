package com.paintingscollectors.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
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

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Painting> paintings;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Painting> favoritePaintings;

    @ManyToMany
    private Set<Painting> ratedPaintings;
}
