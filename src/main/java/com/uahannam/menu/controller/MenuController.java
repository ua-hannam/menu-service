package com.uahannam.menu.controller;

import com.uahannam.menu.domain.MenuStore;
import com.uahannam.menu.domain.MenuStoreId;
import com.uahannam.menu.dto.CategoryRequestDto;
import com.uahannam.menu.dto.CategoryResponseDto;
import com.uahannam.menu.dto.MenuRequestDto;
import com.uahannam.menu.dto.MenuResponseDto;
import com.uahannam.menu.service.CategoryService;
import com.uahannam.menu.service.MenuService;
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
 * @since 2023. 11. 23
 */
@Slf4j(topic = "MenuController")
@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;
    private final CategoryService categoryService;

    /**
     * 가게 기반 메뉴 리스트 반환
     *
     * @param menuStoreId 메뉴 메장 아이디
     * @return ResponseEntity<List < MenuStore>> 메뉴 리스트 반환
     * @since 2023. 11. 23
     */
    @GetMapping("")
    public ResponseEntity<List<MenuStore>> getMenuList(MenuStoreId menuStoreId) {
        log.info("getMenuList");
        List<MenuStore> menuList = menuService.getMenuList(menuStoreId);
        log.info("menuList : {}", menuList);
        return ResponseEntity.ok().body(menuList);
    }

    /**
     * 메뉴 상세 조회
     *
     * @param itemId 메뉴 아이템 아이디
     * @return ResponseEntity<MenuResponseDto> 메뉴 상세 정보 반환
     * @since 2023. 11. 23
     */
    @GetMapping("/items/{itemId}")
    public ResponseEntity<MenuResponseDto> getMenuByItemId(@PathVariable(name = "itemId") Long itemId) {
        log.info("getMenuByItemId");
        MenuResponseDto menu = menuService.getMenuByItemId(itemId);
        log.info("menu : {}", menu);
        return ResponseEntity.ok().body(menu);
    }

    /**
     * 메뉴 아이템 추가
     *
     * @param menuRequestDtoList 메뉴 아이템 추가 정보 리스트
     * @return ResponseEntity<Void> 메뉴 아이템 추가 성공 여부 반환
     * @since 2023. 11. 23
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
     *
     * @param menuRequestDto 메뉴 수정 정보
     * @return ResponseEntity<Void> 메뉴 수정 성공 여부 반환
     * @since 2023. 11. 23
     */
    @PatchMapping("/items/{itemId}")
    public ResponseEntity<Void> updateMenuItem(@PathVariable(name = "itemId") Long itemId, @RequestBody MenuRequestDto menuRequestDto) {
        log.info("updateMenuItem");
        menuService.updateMenuItem(itemId, menuRequestDto);
        log.info("updateMenuItem : success");
        return ResponseEntity.ok().build();
    }

    /**
     * 메뉴 삭제
     *
     * @param itemId 메뉴 아이템 아이디
     * @return ResponseEntity<Void> 메뉴 삭제 성공 여부 반환
     * @since 2023. 12. 15
     */
    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable(name = "itemId") Long itemId) {
        log.info("deleteMenuItem");
        menuService.deleteMenuItem(itemId);
        log.info("deleteMenuItem : success");
        return ResponseEntity.ok().build();
    }

    /*-----------------------------------------------------------------------------------------*/

    /**
     * 카테고리 전체 리스트 조회
     *
     * @return ResponseEntity<List < CategoryResponseDto>> 카테고리 전체 리스트 반환
     * @since 2024. 01. 08
     */
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponseDto>> getCategoryList() {
        log.info("getCategoryList");
        List<CategoryResponseDto> categoryList = categoryService.getCategoryList();
        log.info("categoryList : {}", categoryList);
        return ResponseEntity.ok().body(categoryList);
    }

    /**
     * 카테고리 이름 조회
     *
     * @param categoryId 카테고리 아이디
     * @return ResponseEntity<CategoryResponseDto> 카테고리 DTO 반환
     * @since 2024. 01. 22
     */
    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryResponseDto> getCategoryName(@PathVariable(name = "categoryId") Long categoryId) {
        log.info("getCategoryName");
        CategoryResponseDto categoryNameById = categoryService.getCategoryNameById(categoryId);
        log.info("category name : {}", categoryNameById);
        return ResponseEntity.ok().body(categoryNameById);
    }

    /**
     * 카테고리 메뉴 리스트 조회
     *
     * @param categoryId 카테고리 아이디
     * @return ResponseEntity<List < MenuResponseDto>> 메뉴 리스트 반환
     * @since 2024. 01. 22
     */
    @GetMapping("/categories/{categoryId}/items")
    public ResponseEntity<List<MenuResponseDto>> getMenuByCategory(@PathVariable(name = "categoryId") Long categoryId) {
        log.info("getMenuByCategory");
        List<MenuResponseDto> menuListByCategoryId = menuService.getMenuListByCategoryId(categoryId);
        log.info("menuList : {}", menuListByCategoryId);
        return ResponseEntity.ok().body(menuListByCategoryId);
    }

    /**
     * 카테고리 추가
     *
     * @param categoryRequestDto 카테고리 추가 정보
     * @return ResponseEntity<Void> 카테고리 추가 성공 여부 반환
     * @since 2024. 01. 09
     */
    @PostMapping("/categories")
    public ResponseEntity<Void> addCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        log.info("addCategory");
        categoryService.addCategory(categoryRequestDto);
        log.info("addCategory : success");
        return ResponseEntity.ok().build();
    }

    /**
     * 메뉴 수정
     *
     * @param categoryRequestDto 메뉴 수정 정보
     * @return ResponseEntity<Void> 메뉴 수정 성공 여부 반환
     * @// TODO: 2024-01-09
     * @since 2024. 01. 09
     */
    @PatchMapping("/categories/{categoryId}")
    public ResponseEntity<Void> updateCategory(@PathVariable(name = "categoryId") Long category_id, @RequestBody CategoryRequestDto categoryRequestDto) {
        log.info("updateCategory");
        categoryService.updateCategory(category_id, categoryRequestDto);
        log.info("updateCategory : success");
        return ResponseEntity.ok().build();
    }

    /**
     * 메뉴 삭제
     *
     * @param categoryId 메뉴 아이템 아이디
     * @return ResponseEntity<Void> 메뉴 삭제 성공 여부 반환
     * @// TODO: 2024-01-09
     * @since 2024. 01. 09
     */
    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable(name = "categoryId") Long categoryId) {
        log.info("deleteCategory");
        menuService.deleteMenuItem(categoryId);
        log.info("deleteCategory : success");
        return ResponseEntity.ok().build();
    }
}
