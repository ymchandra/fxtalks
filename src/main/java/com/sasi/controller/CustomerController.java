package com.sasi.controller;

import com.sasi.entity.Customer;
import com.sasi.entity.Order;
import com.sasi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by myelleswarapu on 18-04-2017.
 */
@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("{customerId}/orders")
    public Set<Order> getAllOrders(@PathVariable Long customerId) {
        return customerService.findAllOrdersByCustomerId(customerId);
    }

    @GetMapping("")
    public List<Customer> getAll() {
        return customerService.findAll();
    }
}
