package com.monkgirl.spring5.chapter12.controller;

import com.monkgirl.spring5.chapter12.entity.Customer;
import com.monkgirl.spring5.chapter12.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-22 19:58
 * @description
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/save")
    public int save(Customer customer){
        return customerService.save(customer);
    }

    @RequestMapping("/update")
    public int update(Customer customer){
        return customerService.update(customer);
    }

    @RequestMapping("/delete")
    public int delete(int customerId){
        return customerService.delete(customerId);
    }

    @RequestMapping("/query")
    public Customer query(int customerId){
        return customerService.query(customerId);
    }
}
