package com.uahannam.menu.dto;

import com.uahannam.menu.domain.MenuGroup;
import lombok.Getter;

@Getter
public class MenuGroupRequestDto {

    private Long menuGroupId;

    private String menuGroupName;

    public MenuGroup toEntity() {
        return MenuGroup.builder()
                .menuGroupName(this.menuGroupName)
                .build();
    }

    public MenuGroup toEntity(Long menuGroupId) {
        return MenuGroup.builder()
                .menuGroupId(menuGroupId)
                .menuGroupName(this.menuGroupName)
                .build();
    }

}
