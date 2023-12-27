package com.uahannam.menu.repository;

import com.uahannam.menu.domain.Menu;
import com.uahannam.menu.domain.MenuStoreId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<List<Menu>> findByStoreId(MenuStoreId menuStoreId);
}
