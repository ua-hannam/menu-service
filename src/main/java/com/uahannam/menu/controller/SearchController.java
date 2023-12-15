package com.uahannam.menu.controller;

import com.uahannam.menu.dto.MenuRequestDto;
import com.uahannam.menu.dto.MenuResponseDto;
import com.uahannam.menu.service.MenuService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 메뉴 컨트롤러
 * @since 2023. 12. 14
 * @author swlee
 */
@Slf4j(topic = "SearchController")
@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("/search")
public class SearchController {

    private final MenuService menuService;

    /**
     * 메뉴 조회
     * @since 2023. 12. 14
     *
     * @return ResponseEntity<List<String>> 메뉴 리스트 반환
     */
//    @GetMapping("")
//    public ResponseEntity<List<MenuResponseDto>> getMenuList() {
//        log.info("getMenuList");
//        return ResponseEntity.ok().body();
//    }

    /**
     * 메뉴 상세 정보 조회
     * @since 2023. 12. 14
     *
     * @param menuId 메뉴 아이디
     * @return ResponseEntity<String> 메뉴 상세 정보 반환
     */
    @GetMapping("/{menuId}")
    public ResponseEntity<MenuResponseDto> getMenuById(@PathVariable Long menuId) {
        log.info("getMenuById");
        MenuResponseDto menu = menuService.getMenuById(menuId);
        log.info("menu : {}", menu);
        return ResponseEntity.ok().body(menu);
    }

    /**
     * 메뉴 생성
     * @since 2023. 11. 23
     *
     * @return ResponseEntity<Void> 메뉴 생성 성공 여부 반환
     */
    @PostMapping("")
    public ResponseEntity<Void> createMenu() {
        log.info("createMenu");
        log.info("createMenu : success");
        return ResponseEntity.ok().build();
    }

    /**
     * 메뉴 수정
     * @since 2023. 11. 23
     *
     * @param menuRequestDto 메뉴 수정 정보
     * @return ResponseEntity<Void> 메뉴 수정 성공 여부 반환
     */
    @PatchMapping("")
    public ResponseEntity<Void> updateMenu(@RequestBody @Valid MenuRequestDto menuRequestDto) {
        log.info("updateMenu");
        log.info("updateMenu : success");
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        log.info("deleteMenu");
        log.info("deleteMenu : success");
        return ResponseEntity.ok().build();
    }
}
