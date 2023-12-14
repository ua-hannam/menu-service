package com.uahannam.menu.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "search_history")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Search {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long searchHistoryId;

    @Column(nullable = false)
    private String searchKeyword;

    @Column(nullable = false)
    private Long memberId;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime regDate;

}
