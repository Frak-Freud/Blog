package com.blog.service;

import com.blog.controller.vo.BlogDetailVO;
import com.blog.controller.vo.SimpleBlogListVO;
import com.blog.entity.Blog;
import com.blog.util.PageQueryUtil;
import com.blog.util.PageResult;

import java.util.List;

public interface BlogService {

    String saveBlog(Blog blog);

    PageResult getBlogsPage(PageQueryUtil pageUtil);

    Boolean deleteBatch(Integer[] ids);

    int getTotalBlogs();

    /**
     * 根据id获取详情
     *@Param  blogId
     *@Return
     */
    Blog getBlogById(Long blogId);

    /**
     * 后台修改
     *@Param blog
     *@Return
     */
    String updateBlog(Blog blog);

    /**
     * 获取首页文章列表
     *@Param page
     *@Return
     */
    PageResult getBlogsForIndexPage(int page);

    /**
     * 首页侧边栏数据列表
     * 0-点击最多  1-最新发布
     *@Param type
     *@Return
     */
    List<SimpleBlogListVO> getBlogListForIndexPage(int type);

    /**
     * 文章详情
     *@Param blogId
     *@Return
     */
    BlogDetailVO getBlogDetail(Long blogId);

    /**
     * 根据标签获取文章列表
     *@Param tagName
     *@Param page
     *@Return
     */
    PageResult getBlogsPageByTag(String tagName, int page);

    /**
     * 根据分类获取文章列表
     *@Param categoryId
     *@Param page
     *@Return
     */
    PageResult getBlogsPageByCategory(String categoryName, int page);

    /**
     * 根据搜索获取文章列表
     *@Param keyword
     *@Param page
     *@Return
     */
    PageResult getBlogsPageBySearch(String keyword, int page);

    BlogDetailVO getBlogDetailBySubUrl(String subUrl);

}
