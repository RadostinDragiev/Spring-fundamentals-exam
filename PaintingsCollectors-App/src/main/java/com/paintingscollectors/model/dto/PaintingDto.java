package com.paintingscollectors.model.dto;

import com.paintingscollectors.model.entity.Style;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaintingDto {

    private String uuid;
    private String name;
    private UserDto author;
    private UserDto owner;
    private String imageUrl;
    private Style style;
}
