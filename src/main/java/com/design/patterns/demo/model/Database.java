package com.design.patterns.demo.model;

public class Database {

    private static Database instance = new Database();

    private Database() {

    }

    public static Database getInstance() {
        return instance;
    }

    public void connect() {
        System.out.println("connected to Database!");
    }

    public void disconnect() {
        System.out.println("disconnected!");
    }
}
