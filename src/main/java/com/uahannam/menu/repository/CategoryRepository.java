package com.uahannam.menu.repository;

import com.uahannam.menu.domain.Category;
import com.uahannam.menu.domain.Search;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
