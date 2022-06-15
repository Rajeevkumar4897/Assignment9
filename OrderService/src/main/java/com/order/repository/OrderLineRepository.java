package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entity.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer>{

}

