package rikkei.academy.customermanager.service;

import rikkei.academy.customermanager.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements IGenericService<Customer, Integer> {
    private List<Customer> customers;

    public CustomerService() {
        customers = new ArrayList<>();
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void save(Customer customer) {
        if (findById(customer.getId()) == null) {
            customers.add(customer);
        } else {
            customers.set(customers.indexOf(findById(customer.getId())), customer);
        }
    }

    @Override
    public Customer findById(Integer integer) {
        for (Customer customer : customers) {
            if (customer.getId() == integer) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Integer integer) {
        if (findById(integer) != null) {
            customers.remove(findById(integer));
        }
    }

    public int getNewId() {
        int maxId = 0;
        for (Customer c : customers) {
            if (c.getId() > maxId) {
                maxId = c.getId();
            }
        }
        return maxId;
    }
}
