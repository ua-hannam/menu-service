package com.uahannam.menu.repository;

import com.uahannam.menu.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Category, Long> {
}
