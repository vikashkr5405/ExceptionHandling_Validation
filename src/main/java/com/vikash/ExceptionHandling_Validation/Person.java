package com.vikash.ExceptionHandling_Validation;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity(name="Person")
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotEmpty
    @Size(min=3,max=25,message = "Name must be 3-25 characters")
    @Pattern(regexp = "[^0-9]*",message = "must not contain numbers")
    String name;
    @Email(message = "Invalid Email")
    @NotEmpty(message = "email must not be empty or null")
    String email;
    @NotEmpty(message = "Password must not be empty or null")
    @Size(min=8,max=16,message = "password should be min of 8 and max of 16 char")
    @Pattern(regexp = "^[A-Z][a-z][0-9]+",message = "Password must not contain any special character")
    String password;

    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
