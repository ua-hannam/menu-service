package com.uahannam.menu.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MenuGroupResponseDto {

    private Long menuGroupId;

    private String menuGroupName;
}
