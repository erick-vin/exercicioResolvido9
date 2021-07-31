package model.services;

public class PaypalService implements OnlinePaymentService{
	
	public static final double FEE_PORCENTAGE = 0.02;
	public static final double MONTHS_INTEREST = 0.01;
	
	@Override
	public Double paymentFee(Double amount) {
		
		return amount * FEE_PORCENTAGE;
	}
	@Override
	public Double interest(Double amount, Integer months) {
		
		return amount * MONTHS_INTEREST * months;
	}
		
}
