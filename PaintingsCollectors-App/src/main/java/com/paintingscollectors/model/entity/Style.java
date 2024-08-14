package com.paintingscollectors.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "styles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Style extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name", unique = true, nullable = false)
    private StyleName name;

    @Column(name = "description", nullable = false)
    private String description;
}
