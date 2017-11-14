package com.imooc.dao;


import com.imooc.bean.Customer;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CustomerMapper extends Mapper<Customer> {

}
