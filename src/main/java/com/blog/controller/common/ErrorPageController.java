package com.blog.controller.common;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ErrorPageController implements ErrorViewResolver {

    private static ErrorPageController errorPageController;

    @Resource
    private ErrorAttributes errorAttributes;

    public ErrorPageController() {
        if(errorPageController == null)
            errorPageController = new ErrorPageController(errorAttributes);
    }

    public ErrorPageController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        if(status == HttpStatus.BAD_REQUEST){
            return new ModelAndView("error/error_400");
        } else if (status == HttpStatus.NOT_FOUND) {
            return new ModelAndView("error/error_404");
        } else {
            return new ModelAndView("error/error_5xx");
        }
    }
}
