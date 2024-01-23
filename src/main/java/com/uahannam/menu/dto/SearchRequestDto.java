package com.uahannam.menu.dto;

import com.uahannam.menu.domain.Search;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchRequestDto {

    private String searchKeyword;

    private String regionId;

    public Search toEntity() {
        return Search.builder()
                .searchKeyword(searchKeyword)
                .build();
    }
}