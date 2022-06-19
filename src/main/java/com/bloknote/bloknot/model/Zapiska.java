package com.bloknote.bloknot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "zametki")
public class Zapiska {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "zametki")
    private String zametki;
}
