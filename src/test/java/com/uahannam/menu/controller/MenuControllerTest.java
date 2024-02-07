package com.uahannam.menu.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uahannam.menu.domain.MenuStore;
import com.uahannam.menu.dto.MenuRequestDto;
import com.uahannam.menu.service.MenuService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(MenuController.class)
class MenuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MenuService menuService;

    // getMenuList 테스트
    @Test
    void testGetMenuList() throws Exception {

        List<MenuStore> menuList = Arrays.asList(/* mock 데이터 추가 */);
        Mockito.when(menuService.getMenuList(Mockito.any())).thenReturn(menuList);

        // GET 요청
        mockMvc.perform(MockMvcRequestBuilders.get("/menu")
                        .param("storeId", "yourStoreId")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(menuList.size()));
    }

    // addMenu 테스트
    @Test
    void testAddMenu() throws Exception {
        // Mock 데이터 설정
        List<MenuRequestDto> menuRequestDtoList = Arrays.asList(/* mock 데이터 추가 */);

        // POST 요청
        mockMvc.perform(MockMvcRequestBuilders.post("/menu/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(menuRequestDtoList)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // getMenuById 테스트
    @Test
    void testGetMenuById() throws Exception {
        // Mock 데이터 설정
        Long menuId = 1L;
        // Mockito.when(menuService.getMenuById(menuId)).thenReturn(/* mock 데이터 추가 */);

        // GET 요청
        mockMvc.perform(MockMvcRequestBuilders.get("/menu/items/{menuId}", menuId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        // .andExpect(MockMvcResultMatchers.jsonPath("$.property").value(/* 예상되는 값 */));
    }

    // 나머지 메서드에 대한 테스트도 유사한 방식으로 작성 가능합니다.

}
