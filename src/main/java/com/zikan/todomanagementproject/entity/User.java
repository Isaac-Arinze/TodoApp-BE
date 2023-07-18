package com.zikan.todomanagementproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String password;

//    To map Role and user entity we use Set cos it ontains a uniqe element
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //This creates a 3rd table from combination of role and user table
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn (name = "user_Id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")

    )

//    we also need to need define user_id
    private Set <Role> roles;
}
