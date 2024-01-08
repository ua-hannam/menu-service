package com.uahannam.menu.dto;

import com.uahannam.menu.domain.Category;
import com.uahannam.menu.domain.Menu;
import com.uahannam.menu.domain.MenuGroup;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryRequestDto {

    private String categoryName;

    public Category toEntity() {
        return Category.builder()
                .categoryName(this.categoryName)
                .build();
    }

    public Category toEntity(Long categoryId) {
        return Category.builder()
                .categoryId(categoryId)
                .categoryName(this.categoryName)
                .build();
    }
}
