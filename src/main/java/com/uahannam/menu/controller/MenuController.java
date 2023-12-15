package com.uahannam.menu.controller;

import com.uahannam.menu.dto.MenuRequestDto;
import com.uahannam.menu.dto.MenuResponseDto;
import com.uahannam.menu.service.MenuService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 메뉴 컨트롤러
 * @since 2023. 11. 23
 * @author swlee
 */
@Slf4j(topic = "MenuController")
@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    /**
     * 메뉴 가게 전체 리스트 조회
     * @since 2023. 11. 23
     *
     * @param storeId 가게 아이디
     * @return ResponseEntity<List<String>> 메뉴 가게 전체 리스트 반환
     */
    @GetMapping("/{storeId}")
    public ResponseEntity<List<MenuResponseDto>> getMenuList(@PathVariable Long storeId) {
        log.info("getMenuList");
        List<MenuResponseDto> menuList = menuService.getMenuList(storeId);
        log.info("menuList : {}", menuList);
        return ResponseEntity.ok().body(menuList);
    }

    /**
     * 메뉴 상세 조회
     * @since 2023. 11. 23
     *
     * @param itemId 메뉴 아이템 아이디
     * @return ResponseEntity<String> 메뉴 상세 정보 반환
     */
    @GetMapping("/items/{itemId}")
    public ResponseEntity<MenuResponseDto> getMenuById(@PathVariable Long itemId) {
        log.info("getMenuById");
        MenuResponseDto menu = menuService.getMenuById(itemId);
        log.info("menu : {}", menu);
        return ResponseEntity.ok().body(menu);
    }

    /**
     * 메뉴 아이템 추가
     * @since 2023. 11. 23
     *
     * @param menuRequestDtoList 메뉴 아이템 추가 정보 리스트
     * @return ResponseEntity<Void> 메뉴 아이템 추가 성공 여부 반환
     */
    @PostMapping("/items")
    public ResponseEntity<Void> addMenuItem(@RequestBody List<MenuRequestDto> menuRequestDtoList) {
        log.info("addMenuItem");
        menuService.addMenuItem(menuRequestDtoList);
        log.info("addMenuItem : success");
        return ResponseEntity.ok().build();
    }

    /**
     * 메뉴 수정
     * @since 2023. 11. 23
     *
     * @param menuRequestDto 메뉴 수정 정보
     * @return ResponseEntity<Void> 메뉴 수정 성공 여부 반환
     */
    @PatchMapping("/items/{itemId}")
    public ResponseEntity<Void> updateMenuItem(@PathVariable Long itemId, @RequestBody MenuRequestDto menuRequestDto) {
        log.info("updateMenuItem");
        menuService.updateMenuItem(menuRequestDto);
        log.info("updateMenuItem : success");
        return ResponseEntity.ok().build();
    }

    /**
     * 메뉴 삭제
     * @since 2023. 12. 15
     *
     * @param itemId 메뉴 아이템 아이디
     * @return ResponseEntity<Void> 메뉴 삭제 성공 여부 반환
     */
    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long itemId) {
        log.info("deleteMenuItem");
        menuService.deleteMenuItem(itemId);
        log.info("deleteMenuItem : success");
        return ResponseEntity.ok().build();
    }
}
