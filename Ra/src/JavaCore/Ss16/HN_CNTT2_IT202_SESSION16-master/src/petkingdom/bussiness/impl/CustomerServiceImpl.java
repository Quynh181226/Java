package petkingdom.bussiness.impl;

import petkingdom.bussiness.IGenericRepository;
import petkingdom.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements IGenericRepository<Customer> {

    private Map<String, Customer> customers = new HashMap<>();

    public Customer add(Customer customer) {
        if (customers.containsKey(customer.getId())) {
            System.out.println("ID khách hàng đã tồn tại!");
            return null;
        }
        for (Customer c : customers.values()) {
            if (c.getPhone().equals(customer.getPhone())) {
                System.out.println("SDT đã sử dụng!");
                return null;
            }
        }
        customers.put(customer.getId(), customer);
        return customer;
    }

    @Override
    public void remove(String id) {
        customers.remove(id);
    }

    @Override
    public Customer findById(String id) {
        return customers.get(id);
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }
}