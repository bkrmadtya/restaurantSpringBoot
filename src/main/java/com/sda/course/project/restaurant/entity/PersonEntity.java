package com.sda.course.project.restaurant.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@Entity(name = "people")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToMany
    @JoinTable(
            name = "person_roles",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<RoleEntity> roles;

    @NotBlank(message = "Please provide the first name")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Please provide the last name")
    @Column(name = "last_name")
    private String lastName;

    @Column
    @NotBlank(message = "Please provide the email")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @Column
    @NotBlank(message = "Please provide a phone number")
    @Min(7)
    private long phone;
}
