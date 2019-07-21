package com.hltec.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hltec.web.dao.PersonMapper;
import com.hltec.web.pojo.Person;
import com.hltec.web.service.IPersonService;
@Service("personService")
public class PersonServiceImpl implements IPersonService {
	
	@Autowired
	private PersonMapper personMapper;

	@Override
	public Person selectByPrimaryKey(String id) {
		return this.personMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(Person record) {
		return this.personMapper.insert(record);
	}

}
