package com.design.patterns.demo.controller;

import com.design.patterns.demo.model.*;
import com.design.patterns.demo.view.*;

import java.sql.SQLException;

public class Controller implements CreateUserListener, SaveListener,
        AppListener {

    private  Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }


    public void userCreated(CreateUserEvent event) {

        DAOFactory factory = DAOFactory.getFactory(DAOFactory.MYSQL);

        PersonDao personDao = factory.getPersonDao();

        String name = event.getName();
        String password = event.getPassword();
        try {
            personDao.addPerson(new Person(name, password));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onSave() {
        try {
            model.save();
        } catch (Exception e) {
            view.showError("Error saving to database.");
        }
    }

    @Override
    public void onOpen() {
        try {
            Database.getInstance().connect();
        } catch (Exception e) {
            view.showError("Cannot connect to database.");
        }

        try {
            model.load();
        } catch (Exception e) {
            view.showError("Error loading data from database.");
        }
    }

    @Override
    public void onClose() {
        Database.getInstance().disconnect();
    }
}
