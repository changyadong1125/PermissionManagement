package com.atguigu.springboot.handler;

/**
 * project:PermissionManagement
 * package:handler
 * class:GlobalExceptionHandler
 *
 * @author: smile
 * @create: 2023/4/27-7:46
 * @Version: v1.0
 * @Description:
 */

import com.atguigu.springboot.common.result.Result;
import com.atguigu.springboot.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * return:
 * author: smile
 * version: 1.0
 * description:创建全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<?> error(Exception  e){
        e.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result<?> error(ArithmeticException  e){
        e.printStackTrace();
        return Result.fail().message("出现了特定的异常");

    }
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result<?> error(MyException e){
        e.printStackTrace();
        return Result.fail().message(e.getMessage()).code(e.getCode());

    }
}
