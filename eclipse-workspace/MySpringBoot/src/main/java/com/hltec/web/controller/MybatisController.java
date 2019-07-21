package com.hltec.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hltec.web.pojo.Person;
import com.hltec.web.service.IPersonService;

@Controller
@ResponseBody
public class MybatisController {
	
	@Autowired
	private IPersonService personService;
	/**
	 *  浏览器输入：http://localhost:8081/add?id=4&name=Jack&age=30
	 *则浏览器显示：   Person [id=4, name=Jack, age=30]
	 *并且浏览器新增一条id为4，name为Jack，age为30的新记录
	 * @param person
	 * @return
	 */
	@RequestMapping(value="/add",produces="application/json;charset=utf-8")
	public String addPerson(Person person) {
		int i = personService.insert(person);
		System.out.println("****************i:"+i);
		return person.toString();
	}
	/**
	 * 浏览器输入：http://localhost:8081/qry?id=2
	 * 则浏览器显示： Person [id=2, name=wangwu, age=20]
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/qry",produces="application/json;charset=utf-8")
	public String addPerson(HttpServletRequest req) {
		String id = req.getParameter("id");
		Person person = personService.selectByPrimaryKey(id);
		return person.toString();
	}

}
