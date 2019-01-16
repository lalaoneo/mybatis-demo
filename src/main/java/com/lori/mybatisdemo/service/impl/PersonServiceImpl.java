package com.lori.mybatisdemo.service.impl;

import com.lori.mybatisdemo.dao.PersonMapper;
import com.lori.mybatisdemo.domain.Person;
import com.lori.mybatisdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public void savePerson(Person person) {
        int result = personMapper.insert(person);
        Assert.isTrue(result == 1,"保存失败");
    }
}
