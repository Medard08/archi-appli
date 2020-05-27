package org.polytech.buisness;

public class PaymentInformation {
	private String creditCard, expire, secuCode;
	public PaymentInformation(String creditCard, String expire, String secuCode) {
			this.creditCard = creditCard;
			this.expire = expire;
			this.secuCode = secuCode;
	}
	
	public String toString() {
		return this.creditCard+" "+ this.expire +" "+ this.secuCode;
	}

}
