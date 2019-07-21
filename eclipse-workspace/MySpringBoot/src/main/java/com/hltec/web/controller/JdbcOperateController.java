package com.hltec.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * spring boot之原生jdbc访问数据库
 * @author dzzlk
 *
 */
@Controller
public class JdbcOperateController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@ResponseBody
	@GetMapping(value="/query")
	public Map<String,Object> jdbcQuery() {
		List<Map<String,Object>> list = jdbcTemplate.queryForList("SELECT * FROM person");
		return list.get(0);
		
	}
	/**mysql里面的test数据库下面有一张person表，里面有三条记录
	 * 建表语句:
	 * CREATE TABLE `person` (
	  `id` char(32) NOT NULL,
	  `name` char(64) DEFAULT NULL,
	  `age` char(24) DEFAULT NULL,
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=latin1;
	 * 启动spring boot后页面访问http://localhost:8081/query
	 * 浏览器上显示:
	 * {"id":"1","name":"zhangsan","age":"18"}
	 */

}
