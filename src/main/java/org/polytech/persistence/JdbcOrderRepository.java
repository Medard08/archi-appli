package org.polytech.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.polytech.buisness.Order;

public class JdbcOrderRepository implements OrderRepository {
	private Connection connection;
	
	public JdbcOrderRepository() {
		String url="jdbc:mysql://localhost:3306/polyfood?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username="medard";
		String password="medard";
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void save(Order order) {
		String sql = "INSERT INTO Orders VALUES('"+ order.getConsumerId() 
												+"','"+ order.getRestaurantId() 
												+"','"+ order.getDeliveryInformation() 
												+"','"+ order.getPaymentInformation() 
												+"','"+ 1 +"')";
		try {
			connection.createStatement().execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Long id) {
		
	}
	
	public List<Order> findAllBy(String consumerId){
		return null;
	}
	
	public void update(Long id, Order order) {
		
	}
}
