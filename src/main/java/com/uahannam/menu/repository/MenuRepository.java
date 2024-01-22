package com.uahannam.menu.repository;

import com.uahannam.menu.domain.Menu;
import com.uahannam.menu.dto.MenuResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<List<Menu>> findAllByMenuId(Long menuId);

    @Query("SELECT m FROM Menu m WHERE m.category.categoryId = :categoryId")
    Optional<List<Menu>> findAllByCategoryId(@Param("categoryId") Long categoryId);

    Optional<List<Menu>> findByCategoryCategoryId(Long categoryId);

    Optional<List<Menu>> findByMenuGroupMenuGroupId(Long menuGroupId);
}
