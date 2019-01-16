package com.lori.mybatisdemo.service;
import java.util.Date;


import com.lori.mybatisdemo.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void testPersonService() {

        Person person = createPerson();
        personService.savePerson(person);

    }

    private Person createPerson() {

        Person person = new Person();
        person.setName("lori");
        person.setAge(30);
        person.setSex(1);
        person.setCreateUser("lori");
        person.setUpdateUser("lori");
        person.setCreateTime(new Date());
        person.setUpdateTime(new Date());
        person.setYn(1);
        return person;

    }

}
