package com.design.patterns.demo.controller;

import com.design.patterns.demo.model.Model;
import com.design.patterns.demo.view.LoginFormEvent;
import com.design.patterns.demo.view.LoginListener;
import com.design.patterns.demo.view.View;

public class Controller implements LoginListener {

    private  Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void loginPerformed(LoginFormEvent event) {
        System.out.println(event.getName() + ": " + event.getPassword());
    }
}
