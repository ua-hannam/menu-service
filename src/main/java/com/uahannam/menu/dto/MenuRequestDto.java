package com.uahannam.menu.dto;

import com.uahannam.menu.domain.Catalog;
import com.uahannam.menu.domain.Menu;
import com.uahannam.menu.domain.MenuGroup;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MenuRequestDto {

    private String menuName;

    private int menuPrice;

    private String menuDesc;

    private long menuGroupId;

    private long catalogId;

    public Menu toEntity() {
        return Menu.builder()
                .menuName(menuName)
                .menuPrice(menuPrice)
                .menuDesc(menuDesc)
                .menuGroup(new MenuGroup(menuGroupId))
                .catalog(new Catalog(catalogId))
                .build();
    }
}
