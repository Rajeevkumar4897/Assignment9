package com.order.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.order.entity.Address;
import com.order.entity.Order;
import com.order.entity.OrderLine;
import com.order.entity.OrderLineStatus;
import com.order.entity.Order;
import com.order.entity.OrderStatus;
import com.order.repository.OrderRepository;

@SpringBootTest
class OrderServiceTest {

	@Autowired
	private OrderService orderService;
	
	@MockBean
	private OrderRepository repo;
	
	private Address address;
	private Order order;
	private OrderLine orderLine;
	
	

	@Test
	 void testSaveOrder() {
		
		address = new Address();
		order = new Order();
		orderLine = new OrderLine();
		
		address.setAddressId(1);
		address.setCity("atp");
		address.setCountry("india");
		address.setPin(111111);
		
		orderLine.setOrderlineId(2);
		orderLine.setItem("laptop");
		orderLine.setPrice(60000);
		orderLine.setQuantity(1);
		orderLine.setEta(2);
		orderLine.setOrderLineStatus(OrderLineStatus.open);
		
		
		List<OrderLine> orderlinesList = new ArrayList<>();
		orderlinesList.add(orderLine);
		
		order.setOrderId(3);
		order.setTotalAmount(60000);
		order.setOrderDate("01-01-2022");
		order.setOrderStatus(OrderStatus.open);
		order.setAddress(address);
		order.setOrderlines(orderlinesList);
	
		Mockito.when(repo.save(order)).thenReturn(order);
		assertThat(orderService.saveOrder(order)).isEqualTo(order);
	}
	
	@Test
	 void testGetOrdersByPincodeWithMatchingValue() {
		
		address = new Address();
		order = new Order();
		orderLine = new OrderLine();
		
		address.setAddressId(1);
		address.setCity("atp");
		address.setCountry("india");
		address.setPin(111111);
		
		orderLine.setOrderlineId(2);
		orderLine.setItem("laptop");
		orderLine.setPrice(60000);
		orderLine.setQuantity(1);
		orderLine.setEta(2);
		orderLine.setOrderLineStatus(OrderLineStatus.open);
		
		
		List<OrderLine> orderlinesList = new ArrayList<>();
		orderlinesList.add(orderLine);
		
		order.setOrderId(3);
		order.setTotalAmount(60000);
		order.setOrderDate("01-01-2022");
		order.setOrderStatus(OrderStatus.open);
		order.setAddress(address);
		order.setOrderlines(orderlinesList);
		
		List<Order> ordersList = new ArrayList<>();
		ordersList.add(order);
		
		Integer pincode = 111111;
		Mockito.when(repo.findAll()).thenReturn(ordersList);
		List<Order> resultingOrdersList = orderService.getOrdersByPincode(pincode);
		assertEquals(pincode,resultingOrdersList.get(0).getAddress().getPin() );
		
	}
	
	@Test
	 void testGetOrdersByPincodeWithoutMatchingValue() {
		
		address = new Address();
		order = new Order();
		orderLine = new OrderLine();
		
		address.setAddressId(1);
		address.setCity("atp");
		address.setCountry("india");
		address.setPin(111111);
		
		orderLine.setOrderlineId(2);
		orderLine.setItem("laptop");
		orderLine.setPrice(60000);
		orderLine.setQuantity(1);
		orderLine.setEta(2);
		orderLine.setOrderLineStatus(OrderLineStatus.open);
		
		
		List<OrderLine> orderlinesList = new ArrayList<>();
		orderlinesList.add(orderLine);
		
		order.setOrderId(3);
		order.setTotalAmount(60000);
		order.setOrderDate("01-01-2022");
		order.setOrderStatus(OrderStatus.open);
		order.setAddress(address);
		order.setOrderlines(orderlinesList);
		
		List<Order> ordersList = new ArrayList<>();
		ordersList.add(order);
		
		Integer pincode = 111112;
		Mockito.when(repo.findAll()).thenReturn(ordersList);
		List<Order> resultingOrdersList = orderService.getOrdersByPincode(pincode);
		assertEquals(new ArrayList<>(),resultingOrdersList);
		
	}
	
	@Test
	 void testGetOrderByIdWithMatchingValue() {
		
		address = new Address();
		order = new Order();
		orderLine = new OrderLine();
		
		address.setAddressId(1);
		address.setCity("atp");
		address.setCountry("india");
		address.setPin(111111);
		
		orderLine.setOrderlineId(2);
		orderLine.setItem("laptop");
		orderLine.setPrice(60000);
		orderLine.setQuantity(1);
		orderLine.setEta(2);
		orderLine.setOrderLineStatus(OrderLineStatus.open);
		
		
		List<OrderLine> orderlinesList = new ArrayList<>();
		orderlinesList.add(orderLine);
		
		order.setOrderId(3);
		order.setTotalAmount(60000);
		order.setOrderDate("01-01-2022");
		order.setOrderStatus(OrderStatus.open);
		order.setAddress(address);
		order.setOrderlines(orderlinesList);
	
		Integer id = 3;
		Mockito.when(repo.findById(id)).thenReturn(Optional.ofNullable(order));
		assertThat(orderService.getOrderById(id)).isEqualTo(order);
	}

	@Test
	 void testGetOrderByIdWithoutMatchingValue() {
		
		Integer id = 2;
		Mockito.when(repo.findById(id)).thenReturn(Optional.ofNullable(order));
		Order orderProducts = orderService.getOrderById(id);
		assertEquals(null, orderProducts);
	}


}
