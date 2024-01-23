package com.uahannam.menu.repository;

import com.uahannam.menu.domain.Search;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchRepository extends ElasticsearchRepository<Search, Long>, CustomSearchRepository {
    List<Search> findBySearch_searchKeywordContains(String searchKeyword);
}
