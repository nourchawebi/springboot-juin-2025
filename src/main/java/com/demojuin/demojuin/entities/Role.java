package com.demojuin.demojuin.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrole;
    private RoleName RoleName;
    @JsonIgnore
 @ManyToMany(mappedBy = "role")
    private Set<UserEntity> users=new HashSet<>();
}
