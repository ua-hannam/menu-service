package com.uahannam.menu.dto;

import com.uahannam.menu.domain.Search;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchHistoryRequestDto {

    private Long searchHistoryId;

    private String searchKeyword;
    private Long memberId;

    public Search toEntity() {
        return Search.builder()
                .searchHistoryId(searchHistoryId)
                .searchKeyword(searchKeyword)
                .memberId(memberId)
                .build();
    }
}
