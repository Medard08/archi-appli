package org.polytech.persistence;

import java.util.List;

import org.polytech.buisness.Order;

public interface OrderRepository {
	void save(Order order);
	public List<Order> findAllBy(String consumerId);
		
}
