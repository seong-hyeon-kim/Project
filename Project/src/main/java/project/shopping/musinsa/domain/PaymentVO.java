package project.shopping.musinsa.domain;

import java.util.Date;

public class PaymentVO {
	private int paymentNumber;
	private String userId;
	private int productNumber;
	private int paymentPrice;
	private int paymentAmount;
	private Date paymentDateCreated;
	private String paymentProductSize;
	private String paymentState;
	private ProductVO productVO;
	
	
	public PaymentVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PaymentVO(int paymentNumber, String userId, int productNumber, int paymentPrice, int paymentAmount,
			Date paymentDateCreated, String paymentProductSize, String paymentState, ProductVO productVO) {
		super();
		this.paymentNumber = paymentNumber;
		this.userId = userId;
		this.productNumber = productNumber;
		this.paymentPrice = paymentPrice;
		this.paymentAmount = paymentAmount;
		this.paymentDateCreated = paymentDateCreated;
		this.paymentProductSize = paymentProductSize;
		this.paymentState = paymentState;
		this.productVO = productVO;
	}


	public int getPaymentNumber() {
		return paymentNumber;
	}


	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getProductNumber() {
		return productNumber;
	}


	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}


	public int getPaymentPrice() {
		return paymentPrice;
	}


	public void setPaymentPrice(int paymentPrice) {
		this.paymentPrice = paymentPrice;
	}


	public int getPaymentAmount() {
		return paymentAmount;
	}


	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}


	public Date getPaymentDateCreated() {
		return paymentDateCreated;
	}


	public void setPaymentDateCreated(Date paymentDateCreated) {
		this.paymentDateCreated = paymentDateCreated;
	}


	public String getPaymentProductSize() {
		return paymentProductSize;
	}


	public void setPaymentProductSize(String paymentProductSize) {
		this.paymentProductSize = paymentProductSize;
	}


	public String getPaymentState() {
		return paymentState;
	}


	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
	}


	public ProductVO getProductVO() {
		return productVO;
	}


	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}


	@Override
	public String toString() {
		return "PaymentVO [paymentNumber=" + paymentNumber + ", userId=" + userId + ", productNumber=" + productNumber
				+ ", paymentPrice=" + paymentPrice + ", paymentAmount=" + paymentAmount + ", paymentDateCreated="
				+ paymentDateCreated + ", paymentProductSize=" + paymentProductSize + ", paymentState=" + paymentState
				+ ", productVO=" + productVO + "]";
	}
	
	
	
}