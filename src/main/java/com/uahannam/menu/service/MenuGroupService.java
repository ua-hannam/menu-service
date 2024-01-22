package com.uahannam.menu.service;

import com.uahannam.menu.dto.MenuGroupRequestDto;
import com.uahannam.menu.dto.MenuGroupResponseDto;
import com.uahannam.menu.exception.ErrorCode;
import com.uahannam.menu.exception.MenuException;
import com.uahannam.menu.repository.MenuGroupRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Transactional(readOnly = true)
public class MenuGroupService {

    private final MenuGroupRepository menuGroupRepository;

    @Transactional
    public void addMenuGroup(MenuGroupRequestDto menuGroupRequestDto) {
        menuGroupRepository.save(menuGroupRequestDto.toEntity());
    }

    @Transactional
    public void updateMenuGroup(Long meuGroupId, MenuGroupRequestDto menuGroupRequestDto) {
        menuGroupRepository.save(menuGroupRequestDto.toEntity(meuGroupId));
    }

    @Transactional
    public void deleteMenuGroup(Long menuGroupId) {
        menuGroupRepository.deleteById(menuGroupId);
    }

    public MenuGroupResponseDto getMenuGroup(Long menuGroupId) {
        return menuGroupRepository.findById(menuGroupId).orElseThrow(
                () -> new MenuException(ErrorCode.MENU_ITEM_NOT_FOUND, ErrorCode.MENU_ITEM_NOT_FOUND.getHttpStatus())
        ).toDto();
    }
}
