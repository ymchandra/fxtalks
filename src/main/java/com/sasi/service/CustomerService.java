package com.sasi.service;

import com.sasi.entity.Address;
import com.sasi.entity.Customer;
import com.sasi.entity.Order;
import com.sasi.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

/**
 * Created by myelleswarapu on 18-04-2017.
 */
@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;


    @PostConstruct
    private void insertData(){
        Customer c = new Customer();
        c.setName("Sasi");
        c.setTotalPrice(1234.234);

        Order o = new Order();
        o.setCount(10);
        o.setItemName("Goa Package");
        o.setCustomer(c);
        c.getOrders().add(o);

        Address a = new Address();
        a.setArea("Hi Tech City");
        a.setCity("Hyderabad");
        a.setZip("135543");
        c.setAddress(a);
        customerRepo.save(c);
    }

    public Set<Order> findAllOrdersByCustomerId(Long customerId) {
        return customerRepo.findOne(customerId).getOrders();
    }

    public List<Customer> findAll() {
        return customerRepo.findAll();
    }
}
