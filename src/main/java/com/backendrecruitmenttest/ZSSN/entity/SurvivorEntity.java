package com.backendrecruitmenttest.ZSSN.entity;

import javax.persistence.*;

@Entity
@Table(name = "survivor")
public class SurvivorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String gender;
    @Column
    private double latitude;
    @Column
    private double longitude;
}
