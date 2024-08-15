package com.philately.model.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticateUserDto {

    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    private String username;

    @Length(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    private String password;
}
