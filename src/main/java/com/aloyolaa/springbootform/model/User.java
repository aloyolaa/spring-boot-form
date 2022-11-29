package com.aloyolaa.springbootform.model;

import com.aloyolaa.springbootform.validator.annotation.RegexIdentificator;
import com.aloyolaa.springbootform.validator.annotation.RequiredField;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    //@Pattern(regexp = "\\d{8}")
    @RegexIdentificator
    private String dni;

    //@NotBlank
    private String firstName;

    //@NotBlank
    @RequiredField
    private String lastName;

    @NotBlank
    @Size(min = 3, max = 8, message = "Username must be between 3 and 8 characters")
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Min(5)
    @Max(5000)
    private Integer account;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private LocalDate birthDate;

    @NotNull
    private Country country;

    @NotEmpty
    private List<Role> roles;

    private Boolean enable;

    @NotBlank
    private String gender;

    private String secretValue;

}
