package com.design.patterns.demo.model;

public class OracleDAOFactory extends DAOFactory {
    @Override
    public PersonDao getPersonDao() {
        return new OraclePersonDao();
    }

    @Override
    public LogDAO getLogDao() {
        return new OracleLogDao();
    }
}
