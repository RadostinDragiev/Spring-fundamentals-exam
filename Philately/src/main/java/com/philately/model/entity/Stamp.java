package com.philately.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stamps")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stamp extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "paper", nullable = false)
    private Paper paper;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;
}
