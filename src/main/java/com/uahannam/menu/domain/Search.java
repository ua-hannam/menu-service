package com.uahannam.menu.domain;

import com.uahannam.menu.dto.SearchResponseDto;
import jakarta.persistence.*;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "search")
@Entity
@Table(name = "search")
public class Search extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "search_history_id")
    private Long searchHistoryId;

    @Column(name = "search_keyword", nullable = false)
    private String searchKeyword;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    protected Search() {
    }

    public SearchResponseDto toDto() {
        return SearchResponseDto.builder()
                .query(searchKeyword)
                .build();
    }

    @PersistenceConstructor
    public Search(Long searchHistoryId, String searchKeyword, Long memberId) {
        this.searchHistoryId = searchHistoryId;
        this.searchKeyword = searchKeyword;
        this.memberId = memberId;
    }

}
