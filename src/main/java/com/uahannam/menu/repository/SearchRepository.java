package com.uahannam.menu.repository;

import com.uahannam.menu.domain.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SearchRepository extends JpaRepository<Search, Long> {
    Optional<List<Search>> findAllByMemberId(Long memberId);

    void deleteAllByMemberId(Long memberId);

    @Query("select e.searchKeyword, count(e.searchKeyword) from Search e group by e.searchKeyword order by count(e.searchKeyword) desc")
    List<String> findTopSearchKeywords();
}
