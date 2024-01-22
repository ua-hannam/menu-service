package com.uahannam.menu.controller;

import com.uahannam.menu.domain.MenuStore;
import com.uahannam.menu.domain.MenuStoreId;
import com.uahannam.menu.dto.*;
import com.uahannam.menu.service.CategoryService;
import com.uahannam.menu.service.MenuGroupService;
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
    private final MenuGroupService menuGroupService;
    private final CategoryService categoryService;

    /**
     * 가게 메뉴 리스트 반환
     *
     * @param menuStoreId 메뉴 아이디, 매장 아이디 복합 키
     * @return ResponseEntity<List < MenuStore>> 메뉴 가게 리스트
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
     * 메뉴 조회
     *
     * @param menuId 메뉴 아이디
     * @return ResponseEntity<MenuResponseDto> 메뉴 응답 DTO
     * @since 2023. 11. 23
     */
    @GetMapping("/items/{menuId}")
    public ResponseEntity<MenuResponseDto> getMenuById(@PathVariable("menuId") Long menuId) {
        log.info("getMenuById");
        MenuResponseDto menuResponseDto = menuService.getMenuById(menuId);
        log.info("menu : {}", menuResponseDto);
        return ResponseEntity.ok().body(menuResponseDto);
    }

    /**
     * 메뉴 아이템 추가
     *
     * @param menuRequestDtoList 메뉴 요청 DTO
     * @return ResponseEntity<Void> 메뉴 추가 성공 여부
     * @since 2023. 11. 23
     */
    @PostMapping("/items")
    public ResponseEntity<Void> addMenu(@RequestBody List<MenuRequestDto> menuRequestDtoList) {
        log.info("addMenu");
        menuService.addMenu(menuRequestDtoList);
        log.info("addMenu : success");
        return ResponseEntity.ok().build();
    }

    /**
     * 메뉴 수정
     *
     * @param menuRequestDto 메뉴 요청 DTO
     * @return ResponseEntity<Void> 메뉴 수정 성공 여부
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
     * @return ResponseEntity<Void> 메뉴 삭제 성공 여부
     * @since 2023. 12. 15
     */
    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable(name = "itemId") Long itemId) {
        log.info("deleteMenuItem");
        menuService.deleteMenuItem(itemId);
        log.info("deleteMenuItem : success");
        return ResponseEntity.ok().build();
    }

    /**
     * 카테고리 리스트 조회
     *
     * @return ResponseEntity<List < CategoryResponseDto>> 카테고리 응답 DTO 리스트
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
     * 카테고리 조회
     *
     * @param categoryId 카테고리 아이디
     * @return ResponseEntity<CategoryResponseDto> 카테고리 응답 DTO
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
     * @return ResponseEntity<List < MenuResponseDto>> 메뉴 응답 DTO 리스트
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
     * @param categoryRequestDto 카테고리 요청 DTO
     * @return ResponseEntity<Void> 카테고리 추가 성공 여부
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
     * 카테고리 수정
     *
     * @param categoryRequestDto 카테고리 요청 DTO
     * @return ResponseEntity<Void> 카테고리 수정 성공 여부
     * @since 2024. 01. 23
     */
    @PatchMapping("/categories/{categoryId}")
    public ResponseEntity<Void> updateCategory(@PathVariable(name = "categoryId") Long category_id, @RequestBody CategoryRequestDto categoryRequestDto) {
        log.info("updateCategory");
        categoryService.updateCategory(category_id, categoryRequestDto);
        log.info("updateCategory : success");
        return ResponseEntity.ok().build();
    }

    /**
     * 카테고리 삭제
     *
     * @param categoryId 카테고리 아이디
     * @return ResponseEntity<Void> 카테고리 삭제 성공 여부
     * @since 2024. 01. 23
     */
    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable(name = "categoryId") Long categoryId) {
        log.info("deleteCategory");
        categoryService.deleteCategory(categoryId);
        log.info("deleteCategory : success");
        return ResponseEntity.ok().build();
    }

    /**
     * 메뉴 그룹 메뉴 리스트 조회
     *
     * @param menuGroupId 메뉴 그룹 아이디
     * @return ResponseEntity<List < MenuResponseDto>> 메뉴 응답 DTO 리스트
     * @since 2024. 01. 23
     */
    @GetMapping("/groups/{menuGroupId}/items")
    public ResponseEntity<List<MenuResponseDto>> getMenuByMenuGroup(@PathVariable(name = "menuGroupId") Long menuGroupId) {
        log.info("getMenuByMenuGroup");
        List<MenuResponseDto> menuListByMenuGroupId = menuService.getMenuListByMenuGroupId(menuGroupId);
        return ResponseEntity.ok().body(menuListByMenuGroupId);
    }

    /**
     * 메뉴 그룹 조회
     *
     * @param menuGroupId 메뉴 그룹 아이디
     * @return ResponseEntity<Void> 메뉴 그룹 추가 성공 여부
     * @since 2024. 01. 23
     */
    @GetMapping("/groups/{menuGroupId}")
    public ResponseEntity<MenuGroupResponseDto> getMenuGroup(@PathVariable(name = "menuGroupId") Long menuGroupId) {
        log.info("getMenuGroup");
        MenuGroupResponseDto menuGroup = menuGroupService.getMenuGroup(menuGroupId);
        log.info("getMenuGroup : {}", menuGroup);
        return ResponseEntity.ok().body(menuGroup);
    }

    /**
     * 메뉴 그룹 추가
     *
     * @param menuGroupRequestDto 메뉴 그룹 요청 DTO
     * @return ResponseEntity<Void> 메뉴 그룹 추가 성공 여부
     * @since 2024. 01. 23
     */
    @PostMapping("/groups")
    public ResponseEntity<Void> addMenuGroup(@RequestBody MenuGroupRequestDto menuGroupRequestDto) {
        log.info("addMenuGroup");
        menuGroupService.addMenuGroup(menuGroupRequestDto);
        log.info("addMenuGroup : success");
        return ResponseEntity.ok().build();
    }

    /**
     * 메뉴 그룹 수정
     *
     * @param menuGroupId 메뉴 그룹 아이디
     * @param menuGroupRequestDto 메뉴 그룹 요청 DTO
     * @return ResponseEntity<Void> 메뉴 그룹 수정 성공 여부
     * @since 2024. 01. 23
     */
    @PatchMapping("/groups/{menuGroupId}")
    public ResponseEntity<Void> updateMenuGroup(@PathVariable("menuGroupId") Long menuGroupId, @RequestBody MenuGroupRequestDto menuGroupRequestDto) {
        log.info("updateMenuGroup");
        menuGroupService.updateMenuGroup(menuGroupId, menuGroupRequestDto);
        log.info("updateMenuGroup : success");
        return ResponseEntity.ok().build();
    }

    /**
     * 메뉴 그룹 삭제
     *
     * @param menuGroupId 메뉴 그룹 아이디
     * @return ResponseEntity<Void> 메뉴 그룹 삭제 성공 여부
     * @since 2024. 01. 23
     */
    @DeleteMapping("/groups/{menuGroupId}")
    public ResponseEntity<Void> deleteMenuGroup(@PathVariable("menuGroupId") Long menuGroupId) {
        log.info("deleteMenuGroup");
        menuGroupService.deleteMenuGroup(menuGroupId);
        log.info("deleteMenuGroup : success");
        return ResponseEntity.ok().build();
    }

}
