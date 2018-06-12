package com.imooc.service.impl;

import com.imooc.bean.Customer;
import com.imooc.dao.CustomerDao;
import com.imooc.dao.CustomerMapper;
import com.imooc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer findById(String id) {
        return customerDao.getCustomer(id);
    }
}
