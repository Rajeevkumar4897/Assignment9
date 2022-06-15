package com.order.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderlineId;
	private String item;
	private float price;
	private int quantity;
	private int eta;
	@Enumerated(EnumType.STRING)
	private OrderLineStatus orderLineStatus;
	
	
	public Integer getOrderlineId() {
		return orderlineId;
	}
	public void setOrderlineId(Integer orderlineId) {
		this.orderlineId = orderlineId;
	}
	public String getItem() {
		return item; 
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public OrderLineStatus getOrderLineStatus() {
		return orderLineStatus;
	}
	public void setOrderLineStatus(OrderLineStatus orderLineStatus) {
		this.orderLineStatus = orderLineStatus;
	}
	
}
