package com.design.patterns.demo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PersonDao {

    public void addPerson(Person person) throws SQLException {
        Connection con = Database.getInstance().getCon();
        PreparedStatement p = con.prepareStatement("INSERT INTO people(name, password) VALUES (?, ?)");
        p.setString(1, person.getName());
        p.setString(2,person.getPassword());

        p.executeUpdate();
        p.close();
    }

    public Person getPerson(int id) {

        return null;
    }

    public List<Person> getPeople() {

        return null;
    }

    public void updatePerson(Person person) {

    }

    public void deletePerson(int id) {

    }
}
