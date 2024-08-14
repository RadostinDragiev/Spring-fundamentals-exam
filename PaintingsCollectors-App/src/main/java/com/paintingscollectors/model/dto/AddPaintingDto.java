package com.paintingscollectors.model.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddPaintingDto {
    @Length(min = 5, max = 40, message = "Name length must be between 5 and 40 characters!")
    private String name;

    @Length(min = 5, max = 40, message = "Author name must be between 5 and 30 characters!")
    private String author;

    @NotNull(message = "Please enter valid image URL!")
    private String imageUrl;

    @NotNull(message = "You must select a style!")
    private String style;
}
