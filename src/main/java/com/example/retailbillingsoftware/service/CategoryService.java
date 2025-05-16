package com.example.retailbillingsoftware.service;

import com.example.retailbillingsoftware.io.CategoryRequest;
import com.example.retailbillingsoftware.io.CategoryResponse;

public interface CategoryService {

    CategoryResponse add(CategoryRequest request);
}
