package com.imooc.web.controller;

import com.github.pagehelper.PageHelper;
import com.imooc.bean.Customer;
import com.imooc.dao.CustomerDao;
import com.imooc.dao.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    CustomerMapper customerMapper;

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable String id){
        Customer customer = customerMapper.selectByPrimaryKey(id);
        return customer;
    }

    @GetMapping("/customer/findAll")
    public List<Customer> findAll(){
        PageHelper.startPage(1,3,true);
        List<Customer> customers = customerMapper.selectAll();
        return customers;
    }

    @PostMapping("/customer/age-name")
    public List<Customer> getCustomerByNameAndAge(String name, String age){
        Example example = new Example(Customer.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name",name);
        criteria.andEqualTo("age",age);
        List<Customer> list = customerMapper.selectByExample(example);
        return list;
    }
}
