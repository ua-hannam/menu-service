package com.uahannam.menu.repository;

import com.uahannam.menu.domain.Search;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomSearchRepository {
    List<Search> searchByName(String name, Pageable pageable);
}
