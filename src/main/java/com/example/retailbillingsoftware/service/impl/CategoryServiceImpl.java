package com.example.retailbillingsoftware.service.impl;

import com.example.retailbillingsoftware.entity.CategoryEntity;
import com.example.retailbillingsoftware.io.CategoryRequest;
import com.example.retailbillingsoftware.io.CategoryResponse;
import com.example.retailbillingsoftware.repository.CategoryRepository;
import com.example.retailbillingsoftware.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse add(CategoryRequest request) {
       CategoryEntity newCategory = convertToEntity(request);
       newCategory = categoryRepository.save(newCategory);
       return convetToResponse(newCategory);
    }

    private CategoryResponse convetToResponse(CategoryEntity newCategory) {
        return CategoryResponse.builder()
                .categoryId(newCategory.getCategoryId())
                .name(newCategory.getName())
                .description(newCategory.getDescription())
                .bgColor(newCategory.getBgColor())
                .imgUrl(newCategory.getImgUrl())
                .createdAt(newCategory.getCreatedAt())
                .updatedAt(newCategory.getUpdatedAt())
                .build();
    }

    private CategoryEntity convertToEntity(CategoryRequest request) {
        return CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .bgColor(request.getBgColor())
                .build();
    }
}
