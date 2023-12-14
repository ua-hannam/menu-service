package com.uahannam.menu.service;

import com.uahannam.menu.domain.Menu;
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
public class SearchService {

    private final MenuRepository menuRepository;

    public List<MenuResponseDto> getMenuList() {
        return menuRepository.findAll()
                .stream()
                .map(Menu::toDto)
                .toList();
    }

    public MenuResponseDto getMenuById(Long menuId) {
        return menuRepository.findById(menuId).orElseThrow(
                () -> new MenuException(ErrorCode.MENU_ITEM_NOT_FOUND, ErrorCode.MENU_ITEM_NOT_FOUND.getHttpStatus())
        ).toDto();
    }

    @Transactional
    public void createMenu() {

    }

    @Transactional
    public void updateMenu(MenuRequestDto menuRequestDto) {

    }

    @Transactional
    public void deleteMenu(Long id) {
    }

}
