package org.polytech.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.polytech.buisness.Order;

public class JpaOrderRepository implements OrderRepository {
	
	private EntityManager entityManager;
	
	public JpaOrderRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(Order order) {
		this.entityManager.persist(order);
		
	}

	public List<Order> findAllBy(String consumerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
