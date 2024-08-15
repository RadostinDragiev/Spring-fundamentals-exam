package com.philately.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "papers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paper extends BaseEntity {

    @Enumerated
    @Column(name = "paper_name", unique = true, nullable = false)
    private PaperName paperName;

    @Column(name = "description", nullable = false)
    private String  description;
}
