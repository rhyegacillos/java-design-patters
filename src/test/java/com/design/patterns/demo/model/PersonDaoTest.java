package com.design.patterns.demo.model;

import org.junit.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class PersonDaoTest {

    DAOFactory factory = DAOFactory.getFactory(DAOFactory.MYSQL);
    PersonDao personDao = factory.getPersonDao();


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
        personDao.deleteAll();

    }


    @Test
    public void addPerson() throws Exception {

        Person person1 = new Person("Bob", "Bob1");
        Person person2 = new Person("Danny", "Danny4");

        personDao.addPerson(person1);
        personDao.addPerson(person2);

        List<Person> people = personDao.getPeople();

        assertEquals("Should be 2 person in database", 2, people.size());
        assertEquals("These 2 people should be the same", person1, people.get(0));
        assertEquals("These 2 people should be the same", person2, people.get(1));

    }

    @Test
    public void getPerson() throws Exception {
        Person person1 = new Person("Bob", "Bob1");
        Person person2 = new Person("Danny", "Danny4");

        personDao.addPerson(person1);
        personDao.addPerson(person2);
        List<Person> getPeople = personDao.getPeople();

        assertEquals(person1.getName(), getPeople.get(0).getName() );
        assertNotNull(personDao.getPerson(getPeople.get(1).getId()));
    }

    @Test
    public void getPeople() throws Exception {
        Person person1 = new Person("Bob", "Bob1");
        Person person2 = new Person("Danny", "Danny4");

        personDao.addPerson(person1);
        personDao.addPerson(person2);
        List<Person> getPeople = personDao.getPeople();

        assertEquals(2, getPeople.size());
    }

    @Test
    public void updatePerson() throws Exception {
        Person person1 = new Person("Bob", "Bob1");
        Person person2 = new Person("Danny", "Danny4");

        personDao.addPerson(person1);
        personDao.addPerson(person2);
        List<Person> getPeople = personDao.getPeople();

        Person updatePerson1 = getPeople.get(0);
        updatePerson1.setName("Andrew");
        updatePerson1.setPassword("andrew");

        personDao.updatePerson(updatePerson1);

        assertEquals("Andrew", personDao.getPerson(updatePerson1.getId()).getName());
        assertEquals("andrew", personDao.getPerson(updatePerson1.getId()).getPassword());
    }

    @Test
    public void deletePerson() throws Exception {
        Person person1 = new Person("Bob", "Bob1");
        Person person2 = new Person("Danny", "Danny4");

        personDao.addPerson(person1);
        personDao.addPerson(person2);
        List<Person> getPeople = personDao.getPeople();

        personDao.deletePerson(getPeople.get(0).getId());

        assertNull(personDao.getPerson(getPeople.get(0).getId()));
        assertEquals(1, personDao.getPeople().size());
    }

    @Test
    public void deleteAll() throws Exception {
        Person person1 = new Person("Bob", "Bob1");
        Person person2 = new Person("Danny", "Danny4");

        personDao.addPerson(person1);
        personDao.addPerson(person2);
        List<Person> getPeople = personDao.getPeople();

        assertEquals(2, getPeople.size());

        personDao.deleteAll();

        assertEquals(0, personDao.getPeople().size());
    }

}