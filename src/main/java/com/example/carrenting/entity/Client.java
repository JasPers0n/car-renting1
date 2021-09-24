package com.example.carrenting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "musi posiadać niebiały znak")
    @Size(min=2,message = "Imię musi posiadać conajmniej {min} znaków")
    private String name;
    @NotBlank(message = "musi posiadać niebiały znak")
    @Size(min=2, message = "Nazwisko musi posiadać minimum {min} znaków")
    private String surname;


    @Email(regexp = ".+@.+\\..+|")
    @Target({METHOD, FIELD, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Constraint(validatedBy = {})
    @Documented
    public @interface ExtendedEmail {

        @OverridesAttribute(constraint = Email.class, name = "message")
        String message() default "{javax.validation.constraints.Email.message}";

        @OverridesAttribute(constraint = Email.class, name = "groups")
        Class<?>[] groups() default {};

        @OverridesAttribute(constraint = Email.class, name = "payload")
        Class<? extends Payload>[] payload() default {};
    }

    @ExtendedEmail
    private String email;

    @NotBlank
    @Size(min = 10, message = "Pole nie może być puste. Proszę podać pełny adres")
    private String address;




    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return name + surname;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
