package com.uahannam.menu.repository;

import com.uahannam.menu.domain.MenuStore;
import com.uahannam.menu.domain.MenuStoreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MenuStoreRepository extends JpaRepository<MenuStore, MenuStoreId> {
    Optional<List<MenuStore>> findByMenuStoreId(MenuStoreId menuStoreId);

    @Query("SELECT m FROM MenuStore m JOIN FETCH m.menu JOIN FETCH m.store WHERE m.id = :id")
    MenuStore findByIdWithDetails(MenuStoreId menuStoreId);
}
