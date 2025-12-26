// package com.example.demo.service;
// import java.util.List;
// import com.example.demo.model.Category;
// public interface CategoryService {
//     Category createCategory(Category category);
//     Category getCategory(Long id);
//     List<Category> getAllCategories();
// }



package com.example.demo.service;

import com.example.demo.model.Category;

public interface CategoryService {
    Category createCategory(Category category);
    Category findById(Long id);
}