package com.uahannam.menu.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String storeName;

    @ManyToMany(mappedBy = "stores")
    private Set<MenuStore> menuStores = new HashSet<>();

}

