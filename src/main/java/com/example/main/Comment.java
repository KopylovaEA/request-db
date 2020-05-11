package com.example.main;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "commentt")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "commentt")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requestt_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Request request;

    public Comment() {
    }

    public Comment(Long id, String comment, Request request1) {
        /*this.id = id;*/
        this.text = comment;
        this.request = request1;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text)
    {
        this.text = text;
    }
}
