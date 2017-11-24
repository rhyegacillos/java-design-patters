package com.design.patterns.demo.model;

import org.junit.*;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;


public class PersonDaoTest {


    @BeforeClass
    public static void setBeforeClass() throws Exception {
        System.out.println("Setup before class");
        Database.getInstance().connect();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Setup after class class");
        Database.getInstance().disconnect();
    }

    @Before
    public void setUp() throws Exception {
        PersonDao dao = DAOFactory.getPersonDao();

        dao.deleteAll();
    }


    @Test
    public void addPerson() throws Exception {
        PersonDao dao = DAOFactory.getPersonDao();

        Person person1 = new Person("Bob", "letmein");
        Person person2 = new Person("Sue", "hello");

        dao.addPerson(person1);
        dao.addPerson(person2);

        List<Person> people = dao.getPeople();

        assertEquals("These two people should be the same.", person1, people.get(0));
        assertEquals("These two people should be the same.", person2, people.get(1));

    }

    @Test
    public void getPerson() throws Exception {
        PersonDao dao = DAOFactory.getPersonDao();

        Person person1 = new Person("Bob", "letmein");
        Person person2 = new Person("Sue", "hello");

        dao.addPerson(person1);
        dao.addPerson(person2);

        List<Person> people = dao.getPeople();

        Person getPerson1 = dao.getPerson(people.get(0).getId());
        Person getPerson2 = dao.getPerson(people.get(1).getId());

        assertEquals(person1, getPerson1);
        assertEquals(person2,getPerson2);
    }

    @Test
    public void getPeople() throws Exception {

        PersonDao dao = DAOFactory.getPersonDao();

        Person person1 = new Person("Bob", "letmein");
        Person person2 = new Person("Sue", "hello");

        dao.addPerson(person1);
        dao.addPerson(person2);

        List<Person> people = dao.getPeople();

        assertEquals("Should be two people in database.", 2, people.size());
    }

    @Test
    public void updatePerson() throws Exception {
        PersonDao dao = DAOFactory.getPersonDao();

        Person person1 = new Person("Bob", "letmein");

        dao.addPerson(person1);

        person1.setName("Alice");
        person1.setPassword("alice1");

        List<Person> getPeople = dao.getPeople();

        person1.setId(getPeople.get(0).getId());

        dao.updatePerson(person1);

        List<Person> people = dao.getPeople();

        assertEquals(person1.getName(), people.get(0).getName());
        assertEquals(person1.getPassword(), people.get(0).getPassword());
    }

    @Test
    public void deletePerson() throws Exception {

        PersonDao dao = DAOFactory.getPersonDao();

        Person person1 = new Person("Ray", "letmein");

        dao.addPerson(person1);

        List<Person> getPeople = dao.getPeople();

        dao.deletePerson(dao.getPeople().get(0).getId());

        assertEquals(0, dao.getPeople().size());
    }

    @Test
    public void deleteAll() throws Exception {

        PersonDao dao = DAOFactory.getPersonDao();

        Person person1 = new Person("Bob", "letmein");
        Person person2 = new Person("Sue", "hello");

        dao.addPerson(person1);
        dao.addPerson(person2);

        dao.deleteAll();

        assertEquals(0, dao.getPeople().size());

    }

}