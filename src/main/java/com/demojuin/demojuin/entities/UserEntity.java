package com.demojuin.demojuin.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name= "users")
public class UserEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="firstName", length=10, nullable=true)
    @Size(max=10, message=" le nom ne doit pas depasser 10 caracteres")
    private String firstName ;
    private String lastName;
    @Column(nullable = false, length = 100,unique=true)
    private String email ;
    @Column(unique=true)
    private String username;
    private String address;
    private String password;
    private String confirmPassword;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Role role;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts;
    @OneToMany( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Comment> comments;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="likeId", referencedColumnName = "idlikes")
    private Likes likes;

}
