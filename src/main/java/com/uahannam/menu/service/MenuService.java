package com.uahannam.menu.service;

import com.uahannam.menu.domain.Menu;
import com.uahannam.menu.domain.MenuStore;
import com.uahannam.menu.domain.MenuStoreId;
import com.uahannam.menu.dto.CategoryResponseDto;
import com.uahannam.menu.dto.MenuRequestDto;
import com.uahannam.menu.dto.MenuResponseDto;
import com.uahannam.menu.exception.ErrorCode;
import com.uahannam.menu.exception.MenuException;
import com.uahannam.menu.repository.MenuRepository;
import com.uahannam.menu.repository.MenuStoreRepository;
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
    private final MenuStoreRepository menuStoreRepository;

    public List<MenuStore> getMenuList(MenuStoreId menuStoreId) {
        return menuStoreRepository.findByMenuStoreId(menuStoreId)
                .orElseThrow(
                        () -> new MenuException(ErrorCode.MENU_ITEM_NOT_FOUND, ErrorCode.MENU_ITEM_NOT_FOUND.getHttpStatus())
                );
    }

    public MenuResponseDto getMenuByItemId(Long menuId) {
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
    public void updateMenuItem(Long itemId, MenuRequestDto menuRequestDto) {
        menuRepository.save(menuRequestDto.toEntity(itemId));
    }

    @Transactional
    public void deleteMenuItem(Long itemId) {
        menuRepository.deleteById(itemId);
    }

    public List<MenuResponseDto> getMenuByCategoryId(Long categoryId) {
        return menuRepository.findAllByCategoryId(categoryId)
                .orElseThrow(
                        () -> new MenuException(ErrorCode.MENU_ITEM_NOT_FOUND, ErrorCode.MENU_ITEM_NOT_FOUND.getHttpStatus())
                ).stream()
                .map(Menu::toDto)
                .toList();
    }

    public List<MenuResponseDto> getMenuListByCategoryId(Long categoryId) {
        return menuRepository.findByCategoryCategoryId(categoryId).orElseThrow(
                () -> new MenuException(ErrorCode.MENU_ITEM_NOT_FOUND, ErrorCode.MENU_ITEM_NOT_FOUND.getHttpStatus())
        ).stream().map(Menu::toDto).toList();
    }
}
