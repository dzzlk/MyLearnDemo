package com.hltec.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hltec.web.pojo.User;
import com.hltec.web.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		User user = userRepository.getOne(id);
		return user;
	}
	/**
	 * 启动后浏览器访问:http://localhost:8081/user?lastName=Jack&email=DB
	 * 则数据库中插入一条记录并返回:{"id":1,"lastName":"Jack","email":"DB"}
	 *启动后浏览器访问:http://localhost:8081/user?lastName=Mark&email=DB 
	 * 则数据库中再插入一条记录并返回:{"id":2,"lastName":"Mark","email":"DB"}
	 * @param user
	 * @return
	 */
	@GetMapping("/user")
	public User insertUser(User user) {
		User save = userRepository.save(user);
		return save;
	}

}
