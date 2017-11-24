package com.design.patterns.demo;

import com.design.patterns.demo.controller.Controller;
import com.design.patterns.demo.model.Model;
import com.design.patterns.demo.view.View;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runApp();
            }
        });
    }

    private static void runApp() {
        Model model = new Model();

        View view = new View(model);

        Controller controller = new Controller(model, view);

        view.setCreateUserListener(controller);
        view.setSaveListener(controller);
        view.setAppListener(controller);

		/*
		 * In this implementation of MVC, the view listens
		 * to the model and updates itself if the model
		 * changes. Some people say that the view should not
		 * touch the model, but that the controller should
		 * listen to the model and tell the view to change
		 * instead (by calling methods in the view package).
		 */
        model.setPeopleChangedListener(view);


    }
}
