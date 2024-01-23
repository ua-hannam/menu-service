package com.uahannam.menu.service;

import com.uahannam.menu.domain.Menu;
import com.uahannam.menu.dto.MenuResponseDto;
import com.uahannam.menu.dto.SearchRequestDto;
import com.uahannam.menu.exception.ErrorCode;
import com.uahannam.menu.exception.MenuException;
import com.uahannam.menu.repository.MenuRepository;
import com.uahannam.menu.repository.SearchRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Transactional(readOnly = true)
public class SearchService {

    private final SearchRepository searchRepository;
    private final MenuRepository menuRepository;

    public List<MenuResponseDto> search(String searchKeyword) {
        return menuRepository.findAll(searchKeyword).orElseThrow(
                () -> new MenuException(ErrorCode.MENU_ITEM_NOT_FOUND, ErrorCode.MENU_ITEM_NOT_FOUND.getHttpStatus())
        ).stream().map(Menu::toDto).toList();
//        List<Menu> all = menuRepository.findAll(searchKeyword);
//        System.out.println("COUNT : " + all.size());
//        for (Menu menu : all) {
//            System.out.println("TEST : " + menu.getMenuName());
//        }
//        return all.stream().map(Menu::toDto).toList();
    }

    @Transactional
    public void removeSearchHistory(SearchRequestDto searchRequestDto) {
        searchRepository.delete(searchRequestDto.toEntity());
    }

}
