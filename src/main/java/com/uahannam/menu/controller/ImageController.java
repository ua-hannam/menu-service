package com.uahannam.menu.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 이미지 컨트롤러
 *
 * @author swlee
 * @since 2023. 12. 27
 */
@Slf4j(topic = "ImageController")
@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("/menu/images")
public class ImageController {

    /**
     * 이미지 조회
     *
     * @return ResponseEntity<List < String>> 이미지 주소 반환
     * @since 2023. 12. 27
     */
    @GetMapping("")
    public ResponseEntity<List<String>> getMenuList() {
        log.info("getMenuList");
        List<String> strings = new ArrayList<>();
        log.info("menuList : {}", strings);
        return ResponseEntity.ok().body(strings);
    }

    /**
     * 이미지 생성
     *
     * @return ResponseEntity<Void> 이미지 생성 성공 여부 반환
     * @since 2023. 12. 27
     */
    @PostMapping("")
    public ResponseEntity<Void> createMenu() {
        log.info("createMenu");
        log.info("createMenu : success");
        return ResponseEntity.ok().build();
    }

    /**
     * 이미지 삭제
     *
     * @return ResponseEntity<Void> 이미지 삭제 성공 여부 반환
     * @since 2023. 12. 27
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        log.info("deleteMenu");
        log.info("deleteMenu : success");
        return ResponseEntity.ok().build();
    }
}
