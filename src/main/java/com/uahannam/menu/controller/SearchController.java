package com.uahannam.menu.controller;

import com.uahannam.menu.dto.MenuResponseDto;
import com.uahannam.menu.dto.SearchRequestDto;
import com.uahannam.menu.dto.SearchResponseDto;
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
     * 검색
     *
     * @param searchKeyword 검색 키워드
     * @return List<MenuResponseDto> 메뉴 리스트
     * @since 2024. 01. 24
     */
    @GetMapping("")
    public ResponseEntity<List<MenuResponseDto>> search(@RequestParam("searchKeyword") String searchKeyword, SearchRequestDto searchRequestDto) {
        log.info("search");
        List<MenuResponseDto> searchResponseDtoList = searchService.search(searchKeyword);
        searchService.addSearchHistory(searchKeyword, searchRequestDto);
        log.info("search result : {}", searchResponseDtoList);
        return ResponseEntity.ok().body(searchResponseDtoList);
    }

    /**
     * 검색 이력 조회
     *
     * @param memberId 사용자 ID
     * @return List<SearchResponseDto> 검색 리스트
     * @since 2024. 01. 24
     */
    @GetMapping("/history/{memberId}")
    public ResponseEntity<List<SearchResponseDto>> getSearchHistory(@PathVariable("memberId") Long memberId) {
        log.info("getSearchHistory");
        List<SearchResponseDto> searchHistoryList = searchService.getSearchHistory(memberId);
        log.info("search history result : {}", searchHistoryList);
        return ResponseEntity.ok().body(searchHistoryList);
    }

    /**
     * 검색 이력 전체 삭제
     *
     * @param memberId 사용자 ID
     * @return ResponseEntity<Void> 성공 응답
     * @since 2024. 01. 24
     */
    @DeleteMapping("/{memberId}/history")
    public ResponseEntity<Void> removeAllSearchHistory(@PathVariable("memberId") Long memberId) {
        log.info("removeAllSearchHistory");
        searchService.removeAllSearchHistory(memberId);
        log.info("removeAllSearchHistory success");
        return ResponseEntity.ok().build();
    }

    /**
     * 검색 이력 삭제
     *
     * @param searchId 검색 ID
     * @return ResponseEntity<Void> 성공 응답
     * @since 2024. 01. 24
     */
    @DeleteMapping("/history/{searchId}")
    public ResponseEntity<Void> removeSearchHistory(@PathVariable("searchId") Long searchId) {
        log.info("removeSearchHistory");
        searchService.removeSearchHistory(searchId);
        log.info("removeSearchHistory success");
        return ResponseEntity.ok().build();
    }

    /**
     * 인기 검색 순위 조회
     *
     * @return List<String> 검색 순위 리스트
     * @since 2024. 01. 24
     */
    @GetMapping("/popular")
    public ResponseEntity<List<String>> getSearchRank() {
        log.info("getSearchRank");
        List<String> searchRank = searchService.getSearchRank();
        log.info("getSearchRank result : {}", searchRank);
        return ResponseEntity.ok().body(searchRank);
    }

}
