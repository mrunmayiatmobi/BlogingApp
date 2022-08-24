package com.mrunmayi.blogapp.blogapp.payloads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {


    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be min 4 characters")
    private String name;

    @Email(message = "Email Address is not valid")
    private String email;

    @NotEmpty(message = "Password should not blank")
    @Size(min = 6, max = 12, message = "Password must be min 6 and max 12")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$" , message = "pass should have character and integer and symbols as well.")
    private String password;

    @NotNull(message = "Some about should specify")
    private String about;
}
