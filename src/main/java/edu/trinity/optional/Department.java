package edu.trinity.optional;

import java.util.Optional;

public class Department {
    private final Manager manager;

    public Department(Manager manager) {
        this.manager = manager;
    }

    public Optional<Manager> getManager() {
        return Optional.ofNullable(manager);
    }
}
