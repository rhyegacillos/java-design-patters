package com.design.patterns.demo.model;

import java.util.List;

public interface LogDAO {
    void addEntry(String message);

    List<Log> getEntries(int number);
}
