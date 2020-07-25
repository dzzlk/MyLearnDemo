package com.hltec.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody注解,放到类上面以后 则 这个类的所有方法返回的数据直接写给浏览器（如果是对象则转为json数据）
//在spring4.2新加一个注解@RestController，用来代替@ResponseBody + @Controller
/*@ResponseBody
@Controller*/
@RestController
public class HelloController
{
    
//  @ResponseBody//如果控制器类HelloController里面的所有方法都要加@ResponseBody注解,则可以统一加到类上面去
    @RequestMapping("/hello")
    public String hello()
    {
        return "hello world quick!";
    }
    
    //RESTAPI的方式
}
