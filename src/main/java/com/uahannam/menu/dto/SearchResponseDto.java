package com.uahannam.menu.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchResponseDto {

    private String query;

    private String regionId;

}
