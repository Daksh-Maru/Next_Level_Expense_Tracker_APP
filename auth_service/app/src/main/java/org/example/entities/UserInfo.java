package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

// USER TABLE DATABASE CONFIG
@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserInfo {

    @Id
    @Column(name = "user_id")
    private String userId;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( // FORMING A NEW TABLE OF PRIMARY KEYS USER_ID -- ROLE_ID
            name = "users_roles", // JOIN TABLE NAME
            joinColumns = @JoinColumn(name = "user_id"), // FOREIGN KEY TO THIS TABLE
            inverseJoinColumns = @JoinColumn(name = "role_id") // FOREIGN KEY TO ROLE TABLE
    )
    private Set<UserRole> roles = new HashSet<>();
}
