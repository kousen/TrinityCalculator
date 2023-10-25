package edu.trinity.got;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryMemberDAO implements MemberDAO {
    private final Collection<Member> allMembers = MemberDB.getInstance().getAllMembers();

    @Override
    public Optional<Member> findById(Long id) {
        return allMembers.stream()
                .filter(member -> member.id().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return allMembers.stream()
                .filter(member -> member.name().equals(name))
                .findFirst();
    }

    @Override
    public List<Member> findAllByHouse(House house) {
        return allMembers.stream()
                .filter(member -> member.house().equals(house))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Member> getAll() {
        return Collections.unmodifiableCollection(allMembers);
    }

    /**
     * Find all members whose name starts with S and sort by id (natural sort)
     */
    public List<Member> startWithSandSortAlphabetically() {
        return allMembers.stream()
                .filter(member -> member.name().startsWith("S"))
                .sorted()
                .toList();
    }

    /**
     * Final all Lannisters and sort them by name
     */
    public List<Member> lannisters_alphabeticallyByName() {
        return allMembers.stream()
                .filter(member -> member.house() == House.LANNISTER)
                .sorted(Comparator.comparing(Member::name))
                .toList();
    }

    /**
     * Find all members whose salary is less than the given value and sort by house
     */
    public List<Member> salaryLessThanAndSortByHouse(double max) {
        return allMembers.stream()
                .filter(member -> member.salary() < max)
                .sorted(Comparator.comparing(Member::house))
                .toList();
    }

    /**
     * Sort members by House, then by name
     */
    public List<Member> sortByHouseNameThenSortByNameDesc() {
        return allMembers.stream()
                .sorted(Comparator.comparing(Member::house)
                        .thenComparing(Comparator.comparing(Member::name).reversed()))
                .toList();
    }

    /**
     * Sort the members of a given House by birthdate
     */
    public List<Member> houseByDob(House house) {
        return allMembers.stream()
                .filter(member -> member.house() == house)
                .sorted(Comparator.comparing(Member::dob))
                .toList();
    }

    /**
     * Find all Kings and sort by name in descending order
     */
    public List<Member> kingsByNameDesc() {
        return allMembers.stream()
                .filter(member -> member.title() == Title.KING)
                .sorted(Comparator.comparing(Member::name).reversed())
                .toList();
    }

    /**
     * Find the average salary of all the members
     */
    public double averageSalary() {
        return allMembers.stream()
                .mapToDouble(Member::salary)
                .average()
                .orElse(0.0);
    }

    /**
     * Get the names of a given house, sorted in natural order
     * (note sort by _names_, not members)
     */
    public List<String> namesSorted(House house) {
        return allMembers.stream()
                .filter(member -> member.house() == house)
                .map(Member::name)
                .sorted()
                .toList();
    }

    /**
     * Are any of the salaries greater than 100K?
     */
    public boolean salariesGreaterThan(double max) {
        return allMembers.stream()
                .mapToDouble(Member::salary)
                .anyMatch(salary -> salary > max);
    }

    /**
     * Are there any members of given house?
     */
    public boolean anyMembers(House house) {
        return allMembers.stream()
                .anyMatch(member -> member.house() == house);
    }

    /**
     * How many members of a given house are there?
     */
    public long howMany(House house) {
        return allMembers.stream()
                .filter(member -> member.house() == house)
                .count();
    }

    /**
     * Return the names of a given house as a comma-separated string
     */
    public String houseMemberNames(House house) {
        return allMembers.stream()
                .filter(member -> member.house() == house)
                .map(Member::name)
                .collect(Collectors.joining(", "));
    }

    /**
     * Who has the highest salary?
     */
    public Optional<Member> highestSalary() {
        return allMembers.stream()
                .max(Comparator.comparing(Member::salary));
    }

    /**
     * Partition members into royalty and non-royalty
     * (note: royalty are KINGs and QUEENs only)
     */
    public Map<Boolean, List<Member>> royaltyPartition() {
        return allMembers.stream()
                .collect(Collectors.partitioningBy(
                        member -> member.title() == Title.KING || member.title() == Title.QUEEN));
    }

    /**
     * Group members into Houses
     */
    public Map<House, List<Member>> membersByHouse() {
        return allMembers.stream()
                .collect(Collectors.groupingBy(Member::house));
    }

    /**
     * How many members are in each house?
     * (group by house, downstream collector using counting
     */
    public Map<House, Long> numberOfMembersByHouse() {
        return allMembers.stream()
                .collect(Collectors.groupingBy(Member::house, Collectors.counting()));
    }

    /**
     * Get the max, min, and ave salary for each house
     */
    public Map<House, DoubleSummaryStatistics> houseStats() {
        return allMembers.stream()
                .collect(Collectors.groupingBy(Member::house,
                        Collectors.summarizingDouble(Member::salary)));
    }

}
