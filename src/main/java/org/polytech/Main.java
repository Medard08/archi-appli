package org.polytech;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.polytech.buisness.*;
import org.polytech.persistence.JdbcOrderRepository;
import org.polytech.persistence.JpaOrderRepository;


public class Main {
	
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		JpaOrderRepository jpaOrderRepository = new JpaOrderRepository(session);

		
		OrderService orderService = new OrderService(jpaOrderRepository);
		
		//OrderService orderService = new OrderService(new JdbcOrderRepository());
		
		Long  consumerId = 803L;
		Long restaurantId = 389L;
		OrderLineItem item1 = new OrderLineItem(9L, "Salade papaye", BigDecimal.valueOf(8.9));
		OrderLineItem item2 = new OrderLineItem(9L, "Fruit", BigDecimal.valueOf(5.9));
		OrderLineItem item3 = new OrderLineItem(9L, "Evian", BigDecimal.valueOf(2.5));
		List<OrderLineItem> orderLineItems = Arrays.asList(item1, item2, item3);
		
		DeliveryInformation deliveryInformation = new DeliveryInformation("33 rue la fayette", "13010", "Immeuble Vitrolles");
		
		PaymentInformation paymentInformation = new PaymentInformation("978995666", "02/2024", "221");
		
		Order order = new Order(consumerId, restaurantId, orderLineItems, deliveryInformation, paymentInformation);
		orderService.createOrder(order);
		
		transaction.commit();
		
		System.out.println("######");
		

	}
	
	
	public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();

        // Hibernate settings equivalent to hibernate.cfg.xml's properties

        Properties settings = new Properties();

        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");

        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/polyfood?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

        settings.put(Environment.USER, "medard");

        settings.put(Environment.PASS, "medard");

        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

        settings.put(Environment.SHOW_SQL, "true");

        //settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

        settings.put(Environment.HBM2DDL_AUTO, "update");

        configuration.setProperties(settings);

        configuration.addAnnotatedClass(Order.class);
        
        configuration.addAnnotatedClass(OrderLineItem.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()

            .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
	}
}
