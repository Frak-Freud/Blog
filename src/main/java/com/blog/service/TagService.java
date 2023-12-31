package com.blog.service;

import com.blog.entity.BlogTagCount;
import com.blog.util.PageQueryUtil;
import com.blog.util.PageResult;

import java.util.List;

public interface TagService {
    // 查询标签的分页数据
    PageResult getBlogTagPage(PageQueryUtil pageUtil);

    int getTotalTags();

    Boolean saveTag(String tagName);

    Boolean deleteBatch(Integer[] ids);

    List<BlogTagCount> getBlogTagCountForIndex();

}
