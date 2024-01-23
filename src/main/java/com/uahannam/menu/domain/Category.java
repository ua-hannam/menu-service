package com.uahannam.menu.domain;

import com.uahannam.menu.dto.CategoryResponseDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    public Category(long categoryId) {
        this.categoryId = categoryId;
    }

    public CategoryResponseDto toDto() {
        return CategoryResponseDto.builder()
                .categoryId(this.categoryId)
                .categoryName(this.categoryName)
                .build();
    }

}

