package com.blog.util;

import lombok.Data;

import java.util.List;

// 分页工具类
@Data
public class PageResult {

    // 总记录数
    private int totalCount;
    // 每页记录数
    private int pageSize;
    // 总页数
    private int totalPage;
    // 当前页数
    private int currPage;
    // 列表数据
    private List<?> list;

    public PageResult(List<?> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int) Math.ceil((double) totalCount/pageSize);
    }
}
