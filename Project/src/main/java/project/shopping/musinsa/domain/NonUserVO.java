package project.shopping.musinsa.domain;

public class NonUserVO {
	private String nonUserPhone;
	private String nonUserEmail;
	private String nonUserAddress;
	private String userId;
	public NonUserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NonUserVO(String nonUserPhone, String nonUserEmail, String nonUserAddress, String userId) {
		super();
		this.nonUserPhone = nonUserPhone;
		this.nonUserEmail = nonUserEmail;
		this.nonUserAddress = nonUserAddress;
		this.userId = userId;
	}
	public String getNonUserPhone() {
		return nonUserPhone;
	}
	public void setNonUserPhone(String nonUserPhone) {
		this.nonUserPhone = nonUserPhone;
	}
	public String getNonUserEmail() {
		return nonUserEmail;
	}
	public void setNonUserEmail(String nonUserEmail) {
		this.nonUserEmail = nonUserEmail;
	}
	public String getNonUserAddress() {
		return nonUserAddress;
	}
	public void setNonUserAddress(String nonUserAddress) {
		this.nonUserAddress = nonUserAddress;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "NonUserVO [nonUserPhone=" + nonUserPhone + ", nonUserEmail=" + nonUserEmail + ", nonUserAddress="
				+ nonUserAddress + ", userId=" + userId + "]";
	}
	
	
	
	
}
