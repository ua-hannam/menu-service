package com.uahannam.menu.controller;

import com.uahannam.menu.dto.*;
import com.uahannam.menu.service.SearchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 메뉴 컨트롤러
 *
 * @author swlee
 * @since 2023. 12. 14
 */
@Slf4j(topic = "SearchController")
@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    /**
     * 검색 정보 반환
     *
     * @param searchRequestDto 검색 요청
     * @return List<SearchResponseDto> 검색 결과 리스트 반환
     * @since 2023. 12. 27
     */
    @GetMapping("")
    public ResponseEntity<List<SearchResponseDto>> search(SearchRequestDto searchRequestDto) {
        log.info("search");
        List<SearchResponseDto> searchResponseDtoList = searchService.search(searchRequestDto);
        log.info("search result : {}", searchResponseDtoList);
        return ResponseEntity.ok().body(searchResponseDtoList);
    }

}
