package com.lwando.pos.system.Service.impl;

import com.lwando.pos.system.Service.CustomerService;
import com.lwando.pos.system.model.Customer;
import com.lwando.pos.system.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


   private final CustomerRepository customerRepository;
    //7:46

    @Override
    public Customer createCustomer(Customer customer) throws Exception {
        Customer customer1 = customerRepository.findByEmail(customer.getEmail());
        if (customer1 != null) {
            throw new Exception("Email is already registered");
        }

        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) throws Exception {
        Customer customerToUpdate = customerRepository.findById(customerId)
                .orElseThrow(() -> new Exception("Customer does not found"));

        customer.setFirstName(customerToUpdate.getFirstName());
        customer.setLastName(customerToUpdate.getLastName());
        customer.setAddress(customerToUpdate.getAddress());
        customer.setEmail(customerToUpdate.getEmail());
        customer.setPhoneNumber(customerToUpdate.getPhoneNumber());
        customer.setGender(customerToUpdate.getGender());
        customer.setDateOfBirth(customerToUpdate.getDateOfBirth());

        return customerRepository.save(customerToUpdate);
    }

    @Override
    public void deleteCustomer(Long customerId) throws Exception {
        Customer customerToDelete = customerRepository.findById(customerId)
              .orElseThrow(() -> new Exception("Customer does not found"));
        customerRepository.delete(customerToDelete);
    }

    @Override
    public Customer getCustomerById(Long customerId) throws Exception {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new Exception("Customer does not found"));
    }

    @Override
   public List<Customer> getAllCustomers() {
       return customerRepository.findAll();
    }

   @Override
    public List<Customer> searchCustomers(String keyword) throws Exception {
       return customerRepository.findByFirstNameAndLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword, keyword);
   }
}
