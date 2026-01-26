package com.lwando.pos.system.Service;

import com.lwando.pos.system.modal.Customer;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer) throws Exception;

    Customer updateCustomer(Long customerId, Customer customer) throws Exception;

    void deleteCustomer(Long customerId) throws Exception;

    Customer getCustomerById(Long customerId) throws Exception;

    List<Customer> getAllCustomers() throws Exception;

    List<Customer> searchCustomers(String keyword) throws Exception;
}
