package com.blog.controller.admin;

import com.blog.service.CategoryService;
import com.blog.util.PageQueryUtil;
import com.blog.util.Result;
import com.blog.util.ResultGenerator;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// 分类管理
@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String categoryPage(HttpServletRequest request){
        request.setAttribute("path", "categories");
        return "admin/category";
    }

    // 分类列表
    @GetMapping("/categories/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params){
        if(ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit")))
            return ResultGenerator.genFailResult("参数异常！");
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(categoryService.getBlogCategoryPage(pageUtil));
    }

    // 分类添加
    @PostMapping("/categories/save")
    @ResponseBody
    public Result save(@RequestParam("categoryName") String categoryName,
                       @RequestParam("categoryIcon") String categoryIcon){
        if (!StringUtils.hasText(categoryName))
            return ResultGenerator.genFailResult("请输入分类名称！");
        if (!StringUtils.hasText(categoryIcon))
            return ResultGenerator.genFailResult("请选择分类图标！");
        if (categoryService.saveCategory(categoryName, categoryIcon))
            return ResultGenerator.genSuccessResult();
        else
            return ResultGenerator.genFailResult("分类名称重复");
    }

    // 分类修改
    @PostMapping("/categories/update")
    @ResponseBody
    public Result update(@RequestParam("categoryId") Integer categoryId,
                        @RequestParam("categoryName") String categoryName,
                       @RequestParam("categoryIcon") String categoryIcon){
        if (!StringUtils.hasText(categoryName))
            return ResultGenerator.genFailResult("请输入分类名称！");
        if (!StringUtils.hasText(categoryIcon))
            return ResultGenerator.genFailResult("请选择分类图标！");
        if (categoryService.updateCategory(categoryId, categoryName, categoryIcon))
            return ResultGenerator.genSuccessResult();
        else
            return ResultGenerator.genFailResult("分类名称重复");
    }

    // 分类删除
    @PostMapping("/categories/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids){
        if(ids.length < 1)
            return ResultGenerator.genFailResult("参数异常！");
        if(categoryService.deleteBatch(ids))
            return ResultGenerator.genSuccessResult();
        else
            return ResultGenerator.genFailResult("删除失败");
    }



}
