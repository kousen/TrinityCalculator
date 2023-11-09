package edu.trinity.optional;

import java.util.Optional;

public class Department {
    private String name;
    private Manager manager;

    public Department(String name) {
        this.name = name;
    }

    public Optional<Manager> getManager() {
        return Optional.ofNullable(manager);
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
