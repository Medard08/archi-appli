package org.polytech.buisness;

import org.polytech.persistence.OrderRepository;

public class OrderService {
	private OrderRepository orderRepository;
	
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
		
	}
	
	public void createOrder(Order order) {
		this.orderRepository.save(order);
		
	}

}
