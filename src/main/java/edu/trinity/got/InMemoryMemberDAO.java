package edu.trinity.got;

import java.util.*;

public class InMemoryMemberDAO implements MemberDAO {
    private final Collection<Member> allMembers = MemberDB.getInstance().getAllMembers();

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAllByHouse(House house) {
        return Collections.emptyList();
    }

    @Override
    public Collection<Member> getAll() {
        return Collections.emptyList();
    }

    /**
     * Find all members whose name starts with S and sort by id (natural sort)
     */
    public List<Member> startWithSandSortAlphabetically() {
        return Collections.emptyList();
    }

    /**
     * Final all Lannisters and sort them by name
     */
    public List<Member> lannisters_alphabeticallyByName() {
        return Collections.emptyList();
    }

    /**
     * Find all members whose salary is less than the given value and sort by house
     */
    public List<Member> salaryLessThanAndSortByHouse(double max) {
        return Collections.emptyList();
    }

    /**
     * Sort members by House, then by name
     */
    public List<Member> sortByHouseNameThenSortByNameDesc() {
        return Collections.emptyList();
    }

    /**
     * Sort the members of a given House by birthdate
     */
    public List<Member> houseByDob(House house) {
        return Collections.emptyList();
    }

    /**
     * Find all Kings and sort by name in descending order
     */
    public List<Member> kingsByNameDesc() {
        return Collections.emptyList();
    }

    /**
     * Find the average salary of all the members
     */
    public double averageSalary() {
        return 0.0;
    }

    /**
     * Get the names of a given house, sorted in natural order
     * (note sort by _names_, not members)
     */
    public List<String> namesSorted(House house) {
        return Collections.emptyList();
    }

    /**
     * Are any of the salaries greater than 100K?
     */
    public boolean salariesGreaterThan(double max) {
        return false;
    }

    /**
     * Are there any members of given house?
     */
    public boolean anyMembers(House house) {
        return false;
    }

    /**
     * How many members of a given house are there?
     */
    public long howMany(House house) {
        return 0;
    }

    /**
     * Return the names of a given house as a comma-separated string
     */
    public String houseMemberNames(House house) {
        return "";
    }

    /**
     * Who has the highest salary?
     */
    public Optional<Member> highestSalary() {
        return Optional.empty();
    }

    /**
     * Partition members into royalty and non-royalty
     * (note: royalty are KINGs and QUEENs only)
     */
    public Map<Boolean, List<Member>> royaltyPartition() {
        return Collections.emptyMap();
    }

    /**
     * Group members into Houses
     */
    public Map<House, List<Member>> membersByHouse() {
        return Collections.emptyMap();
    }

    /**
     * How many members are in each house?
     * (group by house, downstream collector using counting
     */
    public Map<House, Long> numberOfMembersByHouse() {
        return Collections.emptyMap();
    }

    /**
     * Get the max, min, and ave salary for each house
     */
    public Map<House, DoubleSummaryStatistics> houseStats() {
        return Collections.emptyMap();
    }

}
