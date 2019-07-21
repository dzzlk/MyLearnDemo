package com.hltec.web.service;

import com.hltec.web.pojo.Person;

public interface IPersonService {
	
	Person selectByPrimaryKey(String id);
	
	int insert(Person record);

}
