package com.uahannam.menu.repository;

import com.uahannam.menu.domain.Category;
import com.uahannam.menu.domain.Search;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryName(String categoryName);

    Optional<Category> findMenuByCategoryId(Long categoryId);
}
