package com.paintingscollectors.model.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {
    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    private String username;

    @Length(min = 1, max = 20, message = "Email cannot be empty!")
    private String email;

    @Length(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    private String password;

    @Length(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    private String confirmPassword;
}
