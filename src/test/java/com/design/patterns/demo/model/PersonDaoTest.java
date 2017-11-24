package com.design.patterns.demo.model;

import org.junit.*;


public class PersonDaoTest {

    public MySQLPersonDao dao;

    @BeforeClass
    public static void setBeforeClass() throws Exception {
        System.out.println("Setup before class");
        Database.getInstance().getCon();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Setup after class class");
        Database.getInstance().disconnect();
    }

    @Before
    public void setUp() throws Exception {

//        dao = MySQLDAOFactory.getPersonDao();
//
//        dao.deleteAll();

    }


    @Test
    public void addPerson() throws Exception {
        //dao = DAOFactory.getPersonDao();

//        Person person1 = new Person("Bob", "Bob1");
//        Person person2 = new Person("Danny", "Danny4");
//
//        dao.addPerson(person1);
//        dao.addPerson(person2);
//
//        List<Person> people = dao.getPeople();
//
//        assertEquals("Should be 2 person in database", 2, people.size());
//        assertEquals("These 2 people should be the same", person1, people.get(0));
//        assertEquals("These 2 people should be the same", person2, people.get(1));

    }

    @Ignore
    @Test
    public void getPerson() throws Exception {
    }

    @Test
    public void getPeople() throws Exception {
    }

    @Test
    public void updatePerson() throws Exception {
    }

    @Test
    public void deletePerson() throws Exception {
    }

    @Test
    public void deleteAll() throws Exception {
    }

}