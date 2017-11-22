package com.design.patterns.demo.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

    public int addPerson(Person person) throws SQLException {

        Connection conn = Database.getInstance().getCon();

        PreparedStatement p = conn
                .prepareStatement("insert into people (name, password) values (?,?)");

        p.setString(1, person.getName());
        p.setString(2, person.getPassword());

        int updated = p.executeUpdate();

        p.close();

        return updated;
    }

    public Person getPerson(int id) throws SQLException {
        Connection conn = Database.getInstance().getCon();

        String sql = "select id, name, password from people where id=? order by id";
        PreparedStatement selectStatement = conn.prepareStatement(sql);

        selectStatement.setInt(1, id);

        ResultSet results = selectStatement.executeQuery();

        Person person = null;

        if (results.next()) {
            String name = results.getString("name");
            String password = results.getString("password");

            person = new Person(id, name, password);
        }

        results.close();
        selectStatement.close();

        return person;
    }

    public List<Person> getPeople() throws SQLException {

        List<Person> people = new ArrayList<Person>();

        Connection conn = Database.getInstance().getCon();

        String sql = "select id, name, password from people order by id";
        Statement selectStatement = conn.createStatement();

        ResultSet results = selectStatement.executeQuery(sql);

        while (results.next()) {
            int id = results.getInt("id");
            String name = results.getString("name");
            String password = results.getString("password");

            Person person = new Person(id, name, password);
            people.add(person);
        }

        results.close();
        selectStatement.close();

        return people;
    }

    public int updatePerson(Person person) throws SQLException {
        Connection conn = Database.getInstance().getCon();

        PreparedStatement p = conn
                .prepareStatement("update people set name=?, password=? where id=?");

        p.setString(1, person.getName());
        p.setString(2, person.getPassword());
        p.setInt(3, person.getId());

        int updated = p.executeUpdate();

        p.close();

        return updated;
    }

    public int deletePerson(int id) throws SQLException {
        Connection conn = Database.getInstance().getCon();

        PreparedStatement p = conn
                .prepareStatement("delete from people where id=?");

        p.setInt(1, id);

        int deleted = p.executeUpdate();

        p.close();

        return deleted;
    }

    public int deleteAll() throws SQLException {
        Connection conn = Database.getInstance().getCon();

        PreparedStatement p = conn
                .prepareStatement("delete from people");

        int deleted = p.executeUpdate();

        p.close();

        return deleted;
    }
}
