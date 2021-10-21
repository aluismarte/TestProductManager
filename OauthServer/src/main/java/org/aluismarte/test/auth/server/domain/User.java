package org.aluismarte.test.auth.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Aluis on 10/21/2021.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private boolean active;

    @ManyToMany(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_roles")
    private Set<Role> roles;
}
