package com.uahannam.menu.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryResponseDto {

    private Long categoryId;

    private String categoryName;

}
