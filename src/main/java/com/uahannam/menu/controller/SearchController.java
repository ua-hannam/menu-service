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
 * 검색 컨트롤러
 *
 * @author swlee
 * @since 2024. 01. 16
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
     * @since 2024. 01. 16
     */
    @GetMapping("")
    public ResponseEntity<List<MenuResponseDto>> search(@RequestParam("searchKeyword") String searchKeyword) {
        log.info("search");
        List<MenuResponseDto> searchResponseDtoList = searchService.search(searchKeyword);
        log.info("search result : {}", searchResponseDtoList);
        return ResponseEntity.ok().body(searchResponseDtoList);
    }

    /**
     * 검색 기록 삭제
     *
     * @param searchRequestDto 검색 요청
     * @return ResponseEntity<Void>
     * @since 2024. 01. 16
     */
    @DeleteMapping("/history")
    public ResponseEntity<Void> removeSearchHistory(SearchRequestDto searchRequestDto) {
        log.info("remove search history");
        searchService.removeSearchHistory(searchRequestDto);
        log.info("remove success");
        return ResponseEntity.ok().build();
    }

}
