package com.design.patterns.demo.model;

public class MySQLDAOFactory extends DAOFactory {

    @Override
    public PersonDao getPersonDao() {
        return new MySQLPersonDao();
    }

    @Override
    public LogDAO getLogDao() {
        return new MySQLLogDAO();
    }
}
