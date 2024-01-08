package com.uahannam.menu.service;

import com.uahannam.menu.domain.Category;
import com.uahannam.menu.domain.Menu;
import com.uahannam.menu.dto.CategoryResponseDto;
import com.uahannam.menu.dto.MenuRequestDto;
import com.uahannam.menu.dto.MenuResponseDto;
import com.uahannam.menu.exception.ErrorCode;
import com.uahannam.menu.exception.MenuException;
import com.uahannam.menu.repository.CategoryRepository;
import com.uahannam.menu.repository.MenuRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryResponseDto> getCategoryList() {
        return categoryRepository.findAll()
                .stream()
                .map(Category::toDto)
                .toList();
    }
}
