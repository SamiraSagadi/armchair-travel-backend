package com.armChairTraveller;

import com.sun.istack.NotNull;

import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "users")
@Table(name = "users",  uniqueConstraints = {
        @UniqueConstraint(name = "users_email_unique", columnNames = "email" )
})
public class User {

@Id
@SequenceGenerator(name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = SEQUENCE , generator = "users_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String firstName;
    @Column(name = "last_name",nullable = false,  columnDefinition = "TEXT")
    private String lastName;
    @Column(name = "email", nullable = false,columnDefinition = "TEXT")
    private String email;
    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;

    public User(Long id,
                String firstName,
                String lastName,
                String email,
                String password
) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                '}';
    }
}