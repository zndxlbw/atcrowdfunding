package com.atguigu.crowd.mvc.config;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@ControllerAdvice注解表示当前类是一个基于注解的异常处理类
@ControllerAdvice
public class CrowdExceptionResolverOld {
    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView resolveMathException(ArithmeticException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
//1、判断当前请求类型
        boolean result = CrowdUtil.judgeRequestType(request);
        if (result){ //如果是ajax请求,则只需要返回json数据，而不需要返回或跳转一个新的界面，所以不需要使用到ModelAndView
            ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());
            //构建Gson对象
            Gson gson = new Gson();
            //将resultEntity转换为json字符串
            String json = gson.toJson(resultEntity);

            //将json字符串作为响应体返回给浏览器
            response.getWriter().write(json);
            //由于上边已经通过原生的response对象返回了响应，所以此处不提供ModelAndView对象
            return null;
        }

        //如果不是ajax请求
        //先创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //将Exception对象传入ModelAndView对象
        modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION,exception);
        //设置对应的视图
        modelAndView.setViewName("system-error");
        System.out.println("这次使用的是异常映射机制");
        //返回ModelAndView对象
        return modelAndView;
    }

    /**
     * 映射空指针异常
     * @param exception  实际捕获到的异常
     * @param request    当前请求对象
     * @return
     */
    //@ExceptionHandler将一个具体的异常类型和一个Java方法建立起连接，也就是建立起映射关系
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolveNullPointerException(NullPointerException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {

        //1、判断当前请求类型
        boolean result = CrowdUtil.judgeRequestType(request);
        if (result){ //如果是ajax请求,则只需要返回json数据，而不需要返回或跳转一个新的界面，所以不需要使用到ModelAndView
            ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());
            //构建Gson对象
            Gson gson = new Gson();
            //将resultEntity转换为json字符串
            String json = gson.toJson(resultEntity);

            //将json字符串作为响应体返回给浏览器
            response.getWriter().write(json);
            //由于上边已经通过原生的response对象返回了响应，所以此处不提供ModelAndView对象
            return null;
        }

        //如果不是ajax请求
        //先创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //将Exception对象传入ModelAndView对象
        modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION,exception);
        //设置对应的视图
        modelAndView.setViewName("system-error");
        System.out.println("这次使用的是异常映射机制");
        //返回ModelAndView对象
        return modelAndView;
    }
}
