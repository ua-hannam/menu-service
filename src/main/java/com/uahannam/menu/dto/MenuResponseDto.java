package com.uahannam.menu.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MenuResponseDto {

    private String menuName;

    private int menuPrice;

    private String menuDesc;

}
