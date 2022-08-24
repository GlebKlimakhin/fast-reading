package com.axioma.axiomatrainee.model.user;

import com.axioma.axiomatrainee.model.Group;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "username")
    @Size(min = 3, max = 12, message = "username cannot be less than 3, and more than 12 characters")
    @NotBlank
    String username;

    @Column(name = "password")
    @Size(min = 3, max = 12, message = "password cannot be less than 3, and more than 12 characters")
    @NotBlank
    @JsonIgnore
    String password;

    @Column(name = "firstname")
    @Size(min = 3, max = 12, message = "firstname cannot be less than 3, and more than 12 characters")
    @NotBlank
    String firstname;

    @Column(name = "lastname")
    @Size(min = 3, max = 20, message = "lastname cannot be less than 3, and more than 12 characters")
    @NotBlank
    String lastname;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @NotBlank
    Status status;

    @Column(name = "email")
    @Email(regexp = ".+@.+\\..+")
    @Size(min = 3, max = 30, message = "email cannot be less than 3, and more than 30 characters")
    @NotBlank
    String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "users_groups",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    Set<Group> groups;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @NotNull
    @NotBlank
    Role role;

    @Column(name = "rating")
    @NotNull
    private Integer rating;
}