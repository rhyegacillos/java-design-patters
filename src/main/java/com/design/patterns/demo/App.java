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
    }
}
