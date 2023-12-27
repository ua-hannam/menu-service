package com.uahannam.menu.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode
public class MenuStoreId implements Serializable {

    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "store_id")
    private Long storeId;

    public MenuStoreId(Long menuId, Long storeId) {
        this.menuId = menuId;
        this.storeId = storeId;
    }
}

