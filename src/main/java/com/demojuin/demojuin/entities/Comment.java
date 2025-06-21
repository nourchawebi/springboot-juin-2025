package com.demojuin.demojuin.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private Timestamp created;
    private String body;
    private String attribute4;
    @ManyToOne
    private Post post;
   @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
     private List<Likes> likes;
}
