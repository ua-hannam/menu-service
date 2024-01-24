package com.uahannam.menu.service;

import com.uahannam.menu.domain.Menu;
import com.uahannam.menu.domain.Search;
import com.uahannam.menu.dto.MenuResponseDto;
import com.uahannam.menu.dto.SearchRequestDto;
import com.uahannam.menu.dto.SearchResponseDto;
import com.uahannam.menu.exception.ErrorCode;
import com.uahannam.menu.exception.MenuException;
import com.uahannam.menu.repository.MenuRepository;
import com.uahannam.menu.repository.SearchRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    }

    @Transactional
    public void addSearchHistory(String searchKeyword, SearchRequestDto searchRequestDto) {
        searchRepository.save(searchRequestDto.toEntity(searchKeyword));
    }

    public List<SearchResponseDto> getSearchHistory(Long memberId) {
        return searchRepository.findAllByMemberId(memberId).orElseThrow(
                () -> new MenuException(ErrorCode.MENU_ITEM_NOT_FOUND, ErrorCode.MENU_ITEM_NOT_FOUND.getHttpStatus())
        ).stream().map(Search::toDto).toList();
    }

    @Transactional
    public void removeAllSearchHistory(Long memberId) {
        searchRepository.deleteAllByMemberId(memberId);
    }

    @Transactional
    public void removeSearchHistory(Long searchId) {
        searchRepository.deleteById(searchId);
    }

    public List<String> getSearchRank() {
        List<String> topSearchKeywords = searchRepository.findTopSearchKeywords();
        return Optional.ofNullable(topSearchKeywords).orElseThrow(
                () -> new MenuException(ErrorCode.MENU_ITEM_NOT_FOUND, ErrorCode.MENU_ITEM_NOT_FOUND.getHttpStatus())
        );
    }
}
