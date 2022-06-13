package com.bloknote.bloknot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="appeal")
public class Appeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "client")
    private String client;

    @Column(name = "request")
    private String request;

    @Column(name = "answer")
    private String answer;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "next_date")
    private String next_date;

    @Column(name = "statys")
    private int statys;


}
