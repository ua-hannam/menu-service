package com.uahannam.menu.repository;

import com.uahannam.menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    Optional<List<Menu>> findByCategoryCategoryId(Long categoryId);

    Optional<List<Menu>> findByMenuGroupMenuGroupId(Long menuGroupId);

    @Query("select e from Menu e where lower(e.menuName) like lower(concat('%',:searchKeyword,'%')) or lower(e.menuDesc) like lower(concat('%',:searchKeyword,'%'))")
    Optional<List<Menu>> findAll(@Param("searchKeyword") String searchKeyword);
}
