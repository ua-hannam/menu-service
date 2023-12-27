package com.uahannam.menu.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "menu_store")
@Entity
public class MenuStore implements Persistable<MenuStoreId> {

    @EmbeddedId
    private MenuStoreId id;

    @MapsId("menuId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @MapsId("storeId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(nullable = false)
    private int price;

    @CreatedDate
    @Column(name = "reg_date")
    private LocalDateTime regDate;

    public void setParent(Menu menu) {
        this.menu = menu;
        this.id = new MenuStoreId(menu.getMenuId(), store.getStoreId());
    }

    @Override
    public boolean isNew() {
        return regDate == null;
    }

}

