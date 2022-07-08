package com.lsp.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author:
 * @createTime: 2022年07月03日 09:43:34
 * @version: 1.0
 * @Description:
 */
@RestControllerAdvice
public class ProjectExceptionAdvance {
    @ExceptionHandler(Exception.class)
    public Result doException(Exception exception){
        return new Result(777,exception,"检测到异常！");
    }
}

