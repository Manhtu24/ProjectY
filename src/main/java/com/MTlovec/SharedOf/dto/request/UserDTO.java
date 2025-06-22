package com.MTlovec.SharedOf.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email address can not be a null or empty")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be greater than 8 characters")
    private String password;
}
