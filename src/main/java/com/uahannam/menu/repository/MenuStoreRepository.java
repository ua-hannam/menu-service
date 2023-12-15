package com.uahannam.menu.repository;

import com.uahannam.menu.domain.MenuStore;
import com.uahannam.menu.domain.Search;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuStoreRepository extends JpaRepository<MenuStore, Long> {
}
