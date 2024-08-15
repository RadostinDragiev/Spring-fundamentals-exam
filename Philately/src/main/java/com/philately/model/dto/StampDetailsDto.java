package com.philately.model.dto;

import com.philately.model.entity.Paper;
import com.philately.model.entity.User;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StampDetailsDto {

    private String uuid;
    private String name;
    private String description;
    private String imageUrl;
    private int price;
    private Paper paper;
    private User owner;
}
