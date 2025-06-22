package com.MTlovec.SharedOf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity implements UserDetails {
    @Id
    private String id;

    @NotEmpty(message = "First name cannot be a null or empty")
    private String firstName;

    @NotEmpty(message = "Last name cannot be a null or empty")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email address can not be a null or empty")
    @Column(nullable = false, unique = true)
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10,11})", message = "Mobile number must between 10 and 11 digits")
    private String phoneNumber;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be greater than 8 characters")
    @ToString.Exclude
    private String password;

    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getRoleName()));
    }

    @Override
    public String getUsername() {
        return firstName+ " " + lastName;
    }
}
