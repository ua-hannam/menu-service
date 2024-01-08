package com.uahannam.menu.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MenuStoreResponseDto {

    private String menuName;

    private int menuPrice;

    private String menuDesc;

}
