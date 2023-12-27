package com.uahannam.menu.domain;

import com.uahannam.menu.dto.SearchResponseDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "search")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Search {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "search_history_id")
    private Long searchHistoryId;

    @Column(name = "search_keyword", nullable = false)
    private String searchKeyword;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime regDate;

    public SearchResponseDto toDto() {
        return SearchResponseDto.builder()
                .query(searchKeyword)
                .build();
    }

}
