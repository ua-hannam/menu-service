package com.uahannam.menu.service;

import com.uahannam.menu.domain.Search;
import com.uahannam.menu.dto.MenuRequestDto;
import com.uahannam.menu.dto.SearchRequestDto;
import com.uahannam.menu.dto.SearchResponseDto;
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

    public List<SearchResponseDto> search(SearchRequestDto searchRequestDto) {
        return searchRepository.findAll()
                .stream()
                .map(Search::toDto)
                .toList();
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
