package com.blog.service;

import com.blog.entity.BlogCategory;
import com.blog.util.PageQueryUtil;
import com.blog.util.PageResult;

import java.util.List;

public interface CategoryService {

    // 查询分类的分页数据
    PageResult getBlogCategoryPage(PageQueryUtil pageUtil);

    int getTotalCategories();

    // 添加分类数据
    Boolean saveCategory(String categoryName, String categoryIcon);

    Boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon);

    Boolean deleteBatch(Integer[] ids);

    List<BlogCategory> getAllCategories();

}
