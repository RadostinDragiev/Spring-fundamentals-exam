package com.paintingscollectors.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "paintings")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Painting extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    private User author;

    // TODO: private Style style;

    @ManyToOne
    @JoinColumn(name = "owner", nullable = false)
    private User owner;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "is_favorite", nullable = false)
    private boolean isFavorite;

    @Column(name = "votes", nullable = false)
    private long votes;
}
