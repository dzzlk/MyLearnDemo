package com.hltec.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RestController
public class DemoController {
	//日志记录器
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		//日志的级别；
		//由低到高 trace<debug<info<warn<error
		//可以调整输出的日志级别；日志就只会在这个级别及以后的高级别生效,只会输出此级别及以后级别的日志
		logger.trace("这是trace日志… …");
		logger.debug("这是debug日志… …");
		//SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root
//		级别
//		在配置文件比如application.properties可以自定义日志级别比如我们定义com.hltec包下面记录日志的级别为
//		trace则:
//		logging.level.com.hltec=trace
//		日志一般只默认输出到控制台，要想日志输入到指定文件里面则这么写就会输出到项目目录下的hltec.log文件里面
//		logging.file=hltec.log
//		我们可以指定完整的日志路径，则可以我们指定的路径下生成(不一定在项目目录下)，比如
//		logging.file=D:/pj/hltec.log
//		# 在当前磁盘的根路径下创建spring文件夹和里面的log文件夹；使用 spring.log 作为默认文件
//		logging.path=/spring/log
//		一般logging.file 与 logging.path 二者选其一
//		可以自定义日志输出格式
//		# 在控制台输出的日志的格式
//		logging.pattern.console=%d{yyyy‐MM‐dd} [%thread] %‐5level %logger{50} ‐ %msg%n
//		# 指定文件中日志输出的格式
//		logging.pattern.file=%d{yyyy‐MM‐dd} === [%thread] === %‐5level === %logger{50} ==== %msg%n
//		访问静态资源:http://localhost:8081/assets/js/src/application.js
		logger.info("这是info日志… …");
		logger.warn("这是warn日志… …");
		logger.error("这是error日志… …");
		return "hello world!";
	}
	
	@RequestMapping("/abc")
	public String success() {
		return "success";
	}

}
