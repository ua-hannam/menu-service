package com.uahannam.menu.dto;

import com.uahannam.menu.domain.Category;
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

    private long categoryId;

    public Menu toEntity() {
        return Menu.builder()
                .menuName(menuName)
                .menuDesc(menuDesc)
                .menuGroup(new MenuGroup(menuGroupId))
                .category(new Category(categoryId))
                .build();
    }

    public Menu toEntity(Long itemId) {
        return Menu.builder()
                .menuId(itemId)
                .menuName(menuName)
                .menuDesc(menuDesc)
                .menuGroup(new MenuGroup(menuGroupId))
                .category(new Category(categoryId))
                .build();
    }
}
