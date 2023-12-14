package com.uahannam.menu.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "catalog")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Category {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catalogId;

    @Column(nullable = false)
    private String catalogName;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modDate;

    public Category(long catalogId) {
        this.catalogId = catalogId;
    }
}
