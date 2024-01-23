package com.uahannam.menu.service;

import com.uahannam.menu.domain.Category;
import com.uahannam.menu.dto.CategoryRequestDto;
import com.uahannam.menu.dto.CategoryResponseDto;
import com.uahannam.menu.exception.ErrorCode;
import com.uahannam.menu.exception.MenuException;
import com.uahannam.menu.repository.CategoryRepository;
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

    @Transactional
    public void addCategory(CategoryRequestDto categoryRequestDto) {
        categoryRepository.findByCategoryName(categoryRequestDto.getCategoryName())
                .ifPresent(category -> {
                    throw new MenuException(ErrorCode.DUPLICATE_MENU_ITEM, ErrorCode.DUPLICATE_MENU_ITEM.getHttpStatus());
                });
        categoryRepository.save(categoryRequestDto.toEntity());
    }

    @Transactional
    public void updateCategory(Long category_id, CategoryRequestDto categoryRequestDto) {
        categoryRepository.save(categoryRequestDto.toEntity(category_id));
    }

    public CategoryResponseDto getCategoryNameById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(
                () -> new MenuException(ErrorCode.CATEGORY_NAME_NOT_FOUND, ErrorCode.CATEGORY_NAME_NOT_FOUND.getHttpStatus())
        ).toDto();
    }

    @Transactional
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
