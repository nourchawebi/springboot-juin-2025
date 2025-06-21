package com.demojuin.demojuin.entities;

import jakarta.persistence.*;

@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idlikes ;
    private Integer likes;
    @ManyToOne
    @JoinColumn(name="comment_id", referencedColumnName = "commentId")
     private Comment comment;

}
