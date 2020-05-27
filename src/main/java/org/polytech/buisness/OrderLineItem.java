package org.polytech.buisness;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Items")
public class OrderLineItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menuId")
	private Long menuId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private BigDecimal price;
	public OrderLineItem(Long menuId, String name, BigDecimal price) {
		this.menuId = menuId;
		this.name = name;
		this.price = price;
	}
}
