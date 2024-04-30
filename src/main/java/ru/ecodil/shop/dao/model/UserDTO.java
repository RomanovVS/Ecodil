package ru.ecodil.shop.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.lang.Nullable;
import ru.ecodil.shop.annotation.PasswordMatches;
import ru.ecodil.shop.annotation.ValidEmail;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER")
@PasswordMatches
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @Column(name = "USER_ID")
    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String password;
    private String matchingPassword;

    @NonNull
    private String roles;

    @Nullable
    private String firstName;

    @Nullable
    private String lastName;

    @NonNull
    private String phone;

    @NonNull
    @ValidEmail
    private String email;

    private String lastAddressOfDelivery;

    private Boolean isPhoneVerified;

    private Boolean isEmailVerified;

}
