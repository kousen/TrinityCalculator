package edu.trinity.optional;

import java.util.Objects;
import java.util.Optional;

public final class Manager {
    private final String first;
    private final String middle;
    private final String last;

    public Manager(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public Optional<String> getMiddle() {
        return Optional.ofNullable(middle);
    }

    public String getLast() {
        return last;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Manager) obj;
        return Objects.equals(this.first, that.first) &&
               Objects.equals(this.middle, that.middle) &&
               Objects.equals(this.last, that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, middle, last);
    }

    @Override
    public String toString() {
        return "Manager[" +
               "first=" + first + ", " +
               "middle=" + middle + ", " +
               "last=" + last + ']';
    }

}