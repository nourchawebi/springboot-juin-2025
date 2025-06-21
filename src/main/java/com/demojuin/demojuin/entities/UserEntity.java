package com.demojuin.demojuin.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name= "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="firstName", length=10, nullable=true)
    @Size(max=10, message=" le nom ne doit pas depasser 10 caracteres")
    private String firstName;
    private String lastName;
    @Column(nullable = false, length=100, unique=true)
    private String email;
    private String password;
    private String address;
    private String username;
    private String confirmPassword;
@ManyToMany
@JoinTable(name="userrole", joinColumns = @JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name="idrole"))
    private Set<Role> role = new HashSet<>();
@OneToMany
     private List<Post> posts;
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="likeId",referencedColumnName = "idlikes")
    private Likes likes;
}
