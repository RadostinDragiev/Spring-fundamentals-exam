package com.paintingscollectors.model.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoggedUserDto {
    private String username;
    private String email;
}
