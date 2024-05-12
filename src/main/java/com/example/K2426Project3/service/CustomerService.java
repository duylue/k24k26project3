package com.example.K2426Project3.service;

import com.example.K2426Project3.model.Customer;
import com.example.K2426Project3.model.Zone;

import java.util.List;

public interface CustomerService {
    List<Customer> list();
    List<Zone> listZone();
    void save(Customer customer);
    Customer findById(int id);
    void delete(int id);
}
