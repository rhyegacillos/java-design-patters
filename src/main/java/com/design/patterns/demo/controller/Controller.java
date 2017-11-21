package com.design.patterns.demo.controller;

import com.design.patterns.demo.model.Model;
import com.design.patterns.demo.model.Person;
import com.design.patterns.demo.model.PersonDao;
import com.design.patterns.demo.view.CreateUserEvent;
import com.design.patterns.demo.view.CreateUserListener;
import com.design.patterns.demo.view.View;

import java.sql.SQLException;

public class Controller implements CreateUserListener {

    private  Model model;
    private View view;

    private PersonDao personDao = new PersonDao();

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }


    public void userCreated(CreateUserEvent event) {

        String name = event.getName();
        String password = event.getPassword();
        try {
            personDao.addPerson(new Person(name, password));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
