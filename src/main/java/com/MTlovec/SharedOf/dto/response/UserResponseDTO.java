package com.MTlovec.SharedOf.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    private String id;
    private  String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private boolean isActive;
}
