package com.example.main;

import com.example.status.Status;

import javax.persistence.*;

@Entity
@Table(name = "requestt")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column (name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    public Request() {
    }

    public Request(String description) {
        this.description = description;
        this.status = Status.NEW.getStatus();
    }

    public Request(Long id) {
        this.id = id;
    }

    public Request(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//getters and setters
}