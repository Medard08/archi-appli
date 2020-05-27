package org.polytech.buisness;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DeliveryInformation {
	@Column(name = "address")
	private String address;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "detail")
	private String detail;
	
	public DeliveryInformation() {
		
	}
	public DeliveryInformation(String address, String code, String detail) {
		this.address = address;
		this.code = code;
		this.detail = detail;
	}
	
	public String toString() {
		return this.address +" "+ this.code +" "+ this.detail;
	}
}
