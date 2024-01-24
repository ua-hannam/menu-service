package com.uahannam.menu.dto;

import com.uahannam.menu.domain.Search;
import lombok.Getter;

@Getter
public class SearchRequestDto {

    private String searchKeyword;

    private String regionId;

    public Search toEntity() {
        return Search.builder()
                .searchKeyword(this.searchKeyword)
                .build();
    }

    public Search toEntity(String searchKeyword) {
        return Search.builder()
                .searchKeyword(searchKeyword)
                .memberId(1L)
                .build();
    }
}
