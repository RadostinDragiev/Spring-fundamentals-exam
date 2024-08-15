package com.philately.model.dto;

import com.philately.model.entity.PaperName;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddStampDto {

    @Length(min = 5, max = 20, message = "Name length must be between 5 and 25 characters!")
    private String name;

    @Length(min = 5, max = 20, message = "Description length must be between 5 and 25 characters!")
    private String description;

    @NotEmpty(message = "Please enter valid image URL!")
    private String imageUrl;

    @Min(message = "must be greater than 0", value = 0)
    private Integer price;

    @NotNull(message = "You must select a type of paper!")
    private PaperName paperName;
}
