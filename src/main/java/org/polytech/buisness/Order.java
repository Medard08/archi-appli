package org.polytech.buisness;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Orders")
public class Order {
	public Order(Long consumerId, Long restaurantId, List<OrderLineItem> orderLineItems,
			DeliveryInformation deliveryInformation, PaymentInformation paymentInformation) {
		this.consumerId = consumerId;
		this.restaurantId =restaurantId;
		this.lineItems = orderLineItems;
		this.deliveryInformation = deliveryInformation;
		this.paymentInformation = paymentInformation;
	}
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private transient OrderState state;
	@Column(name="consumerId")
	private Long consumerId;
	@Column(name="restaurantId")
	private Long restaurantId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	private List<OrderLineItem> lineItems;
	
	@Embedded
	private DeliveryInformation deliveryInformation;
	private transient PaymentInformation paymentInformation;
	
	public Long getConsumerId() { return this.consumerId; }
	public Long getRestaurantId() { return this.restaurantId; }
	public DeliveryInformation getDeliveryInformation( ) { return this.deliveryInformation; }
	public PaymentInformation getPaymentInformation( ) { return this.paymentInformation; }
	public List<OrderLineItem> getLineItems() { return this.lineItems; }

}
