package com.design.patterns.demo.model;

public class DAOFactory {

    public static PersonDao getPersonDao() {
        return new PersonDao();
    }

    public static LogDAO getLogDao() {
        return new LogDAO();
    }
}
