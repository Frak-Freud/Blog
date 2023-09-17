package com.blog.controller.admin;

import com.blog.entity.BlogLink;
import com.blog.service.LinkService;
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

@Controller
@RequestMapping("/admin")
public class LinkController {

    @Resource
    private LinkService linkService;

    @GetMapping("/links")
    public String linkPage(HttpServletRequest request){
        request.setAttribute("path", "links");
        return "admin/link";
    }

    @GetMapping("/links/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params){
        if(ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit")))
            return ResultGenerator.genFailResult("参数异常！");
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(linkService.getBlogLinkPage(pageUtil));
    }

    // 友链添加
    @PostMapping("/links/save")
    @ResponseBody
    public Result save(@RequestParam(value = "linkType", required = false) Integer linkType,
                          @RequestParam(value = "linkName", required = false) String linkName,
                          @RequestParam(value = "linkUrl", required = false) String linkUrl,
                          @RequestParam(value = "linkRank", required = false) Integer linkRank,
                          @RequestParam(value = "linkDescription", required = false) String linkDescription){
        if(linkType == null || linkType < 0 || linkRank == null ||linkRank < 0 || !StringUtils.hasText(linkName) || !StringUtils.hasText(linkUrl)  || !StringUtils.hasText(linkDescription))
            return ResultGenerator.genFailResult("参数异常！");
        BlogLink blogLink = new BlogLink();
        blogLink.setLinkType(linkType.byteValue());
        blogLink.setLinkRank(linkRank);
        blogLink.setLinkName(linkName);
        blogLink.setLinkUrl(linkUrl);
        blogLink.setLinkDescription(linkDescription);
        return ResultGenerator.genSuccessResult(linkService.saveLink(blogLink));
    }

    // 详情
    @GetMapping("/links/info/{id}")
    @ResponseBody
    public Result info(@PathVariable("id") Integer id){
        BlogLink blogLink = linkService.selectById(id);
        return ResultGenerator.genSuccessResult(blogLink);
    }

    // 友链修改
    @PostMapping("/links/update")
    @ResponseBody
    public Result save(@RequestParam(value = "linkId", required = false) Integer linkId,
                       @RequestParam(value = "linkType", required = false) Integer linkType,
                       @RequestParam(value = "linkName", required = false) String linkName,
                       @RequestParam(value = "linkUrl", required = false) String linkUrl,
                       @RequestParam(value = "linkRank", required = false) Integer linkRank,
                       @RequestParam(value = "linkDescription", required = false) String linkDescription){
        BlogLink blogLink = linkService.selectById(linkId);
        if(blogLink == null)
            return ResultGenerator.genFailResult("无数据！");
        if(linkType == null || linkType < 0 || linkRank == null ||linkRank < 0 || !StringUtils.hasText(linkName) || !StringUtils.hasText(linkUrl)  || !StringUtils.hasText(linkDescription))
            return ResultGenerator.genFailResult("参数异常！");
        blogLink.setLinkType(linkType.byteValue());
        blogLink.setLinkRank(linkRank);
        blogLink.setLinkName(linkName);
        blogLink.setLinkUrl(linkUrl);
        blogLink.setLinkDescription(linkDescription);
        return ResultGenerator.genSuccessResult(linkService.updateLink(blogLink));
    }

    // 友链删除
    @PostMapping("/links/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids){
        if(ids.length < 1)
            return ResultGenerator.genFailResult("参数异常！");
        if(linkService.deleteBatch(ids))
            return ResultGenerator.genSuccessResult();
        else
            return ResultGenerator.genFailResult("删除失败");
    }

}
