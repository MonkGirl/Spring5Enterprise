package com.monkgirl.spring5.chapter12.service.impl;

import com.monkgirl.spring5.chapter12.dao.CustomerDAO;
import com.monkgirl.spring5.chapter12.entity.Customer;
import com.monkgirl.spring5.chapter12.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-22 19:55
 * @description
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public int save(Customer customer) {
        return customerDAO.save(customer);
    }

    @Override
    public int update(Customer customer) {
        return customerDAO.update(customer);
    }

    @Override
    public Customer query(int customerId) {
        return customerDAO.query(customerId);
    }

    @Override
    public int delete(int customerId) {
        return customerDAO.delete(customerId);
    }
}
