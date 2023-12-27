package com.uahannam.menu.repository;

import com.uahannam.menu.domain.MenuStore;
import com.uahannam.menu.domain.MenuStoreId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuStoreRepository extends JpaRepository<MenuStore, MenuStoreId> {
    Optional<List<MenuStore>> findByMenuStoreId(MenuStoreId menuStoreId);
}
