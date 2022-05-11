package com.backendrecruitmenttest.ZSSN.entity;

import javax.persistence.*;

@Entity
@Table(name = "item_by_survivor")
public class ItemBySurvivorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
