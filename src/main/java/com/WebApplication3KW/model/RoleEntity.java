package com.WebApplication3KW.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "`ROLE`")
@Setter
@Getter
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;
}
