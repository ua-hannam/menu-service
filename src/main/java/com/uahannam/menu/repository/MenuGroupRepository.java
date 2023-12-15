package com.uahannam.menu.repository;

import com.uahannam.menu.domain.MenuGroup;
import com.uahannam.menu.domain.Search;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuGroupRepository extends JpaRepository<MenuGroup, Long> {
}
