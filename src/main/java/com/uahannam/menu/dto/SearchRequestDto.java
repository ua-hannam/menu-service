package com.uahannam.menu.dto;

import com.uahannam.menu.domain.Search;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchRequestDto {

    private String query;

    private String regionId;

    public Search toEntity() {
        return Search.builder()
                .searchKeyword(query)
                .build();
    }
}
