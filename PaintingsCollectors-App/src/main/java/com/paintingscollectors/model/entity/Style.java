package com.paintingscollectors.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "styles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Style extends BaseEntity {

    @Enumerated
    @Column(name = "name", unique = true, nullable = false)
    private StyleName name;

    // FIXME: add description depending on style name
    @Column(name = "description", nullable = false)
    private String description;
}
