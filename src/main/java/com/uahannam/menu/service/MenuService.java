package com.uahannam.menu.service;

import com.uahannam.menu.domain.Menu;
import com.uahannam.menu.domain.MenuStoreId;
import com.uahannam.menu.dto.MenuRequestDto;
import com.uahannam.menu.dto.MenuResponseDto;
import com.uahannam.menu.exception.ErrorCode;
import com.uahannam.menu.exception.MenuException;
import com.uahannam.menu.repository.MenuRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Transactional(readOnly = true)
public class MenuService {

    private final MenuRepository menuRepository;

    public List<MenuResponseDto> getMenuList(MenuStoreId menuStoreId) {
        return menuRepository.findByStoreId(menuStoreId)
                .orElseThrow(
                        () -> new MenuException(ErrorCode.MENU_ITEM_NOT_FOUND, ErrorCode.MENU_ITEM_NOT_FOUND.getHttpStatus())
                ).stream()
                .map(Menu::toDto)
                .toList();
    }

    public MenuResponseDto getMenuById(Long menuId) {
        return menuRepository.findById(menuId).orElseThrow(
                () -> new MenuException(ErrorCode.MENU_ITEM_NOT_FOUND, ErrorCode.MENU_ITEM_NOT_FOUND.getHttpStatus())
        ).toDto();
    }

    @Transactional
    public void addMenuItem(List<MenuRequestDto> menuRequestDtoList) {
        menuRepository.saveAll((menuRequestDtoList.stream()
                .map(MenuRequestDto::toEntity))
                .toList());
    }

    @Transactional
    public void updateMenuItem(MenuRequestDto menuRequestDto) {
        menuRepository.save(menuRequestDto.toEntity());
    }

    @Transactional
    public void deleteMenuItem(Long itemId) {
        menuRepository.deleteById(itemId);
    }

}
