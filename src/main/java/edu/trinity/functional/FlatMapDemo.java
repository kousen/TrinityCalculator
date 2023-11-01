package edu.trinity.functional;

import java.util.List;

public class FlatMapDemo {
    public static void main(String[] args) {

        record Order(int id) {}

        record Customer(int id, List<Order> orders) {}

        Customer jeanLuc = new Customer(1, List.of(new Order(1), new Order(2)));
        Customer william = new Customer(2, List.of(new Order(3)));
        Customer deanna = new Customer(3, List.of());

        List<Customer> customers = List.of(jeanLuc, william, deanna);
        List<Integer> ids = customers.stream()
                .map(Customer::id)
                .toList();
        System.out.println(ids);

        customers.stream()
                .flatMap(customer -> customer.orders().stream())
                .forEach(System.out::println);
    }
}
