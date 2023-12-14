package com.uahannam.menu.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_store")
@IdClass(MenuStoreKey.class)
public class MenuStore {

    @Id
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Id
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(nullable = false)
    private int price;

}

