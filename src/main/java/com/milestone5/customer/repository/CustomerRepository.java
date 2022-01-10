package com.milestone5.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milestone5.customer.model.Customer;


public interface CustomerRepository extends  JpaRepository<Customer,Integer>{

}
