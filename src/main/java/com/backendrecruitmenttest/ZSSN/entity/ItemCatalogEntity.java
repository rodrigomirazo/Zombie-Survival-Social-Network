package com.backendrecruitmenttest.ZSSN.entity;

import javax.persistence.*;

@Entity
@Table(name = "item_catalog")
public class ItemCatalogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
