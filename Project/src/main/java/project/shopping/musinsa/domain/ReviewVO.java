package project.shopping.musinsa.domain;

import java.util.Date;

public class ReviewVO {
	private int reviewNumber;
	private String userId;
	private int productNumber;
	private String reviewContent;
	private int reviewGrade;
	private int userAge;
	private String userGender;
	private Date reviewDateCreated;
	private UserVO uvo;
	
	public ReviewVO() {}
	
	public ReviewVO(int reviewNumber, String userId, int productNumber, String reviewContent, int reviewGrade,
			int userAge, String userGender, Date reviewDateCreated, UserVO uvo) {
		this.reviewNumber = reviewNumber;
		this.userId = userId;
		this.productNumber = productNumber;
		this.reviewContent = reviewContent;
		this.reviewGrade = reviewGrade;
		this.userAge = userAge;
		this.userGender = userGender;
		this.reviewDateCreated = reviewDateCreated;
		this.uvo = uvo;
	}
	
	public int getReviewNumber() {
		return reviewNumber;
	}
	
	public void setReviewNumber(int reviewNumber) {
		this.reviewNumber = reviewNumber;
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
	
	public String getReviewContent() {
		return reviewContent;
	}
	
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	
	public int getReviewGrade() {
		return reviewGrade;
	}
	
	public void setReviewGrade(int reviewGrade) {
		this.reviewGrade = reviewGrade;
	}
	
	public int getUserAge() {
		return userAge;
	}
	
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
	public String getUserGender() {
		return userGender;
	}
	
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	
	public Date getReviewDateCreated() {
		return reviewDateCreated;
	}
	
	public void setReviewDateCreated(Date reviewDateCreated) {
		this.reviewDateCreated = reviewDateCreated;
	}
	
	public UserVO getUvo() {
		return uvo;
	}
	
	public void setUvo(UserVO uvo) {
		this.uvo = uvo;
	}
	
	@Override
	public String toString() {
		return "ReviewVO [reviewNumber=" + reviewNumber + ", userId=" + userId + ", productNumber=" + productNumber
				+ ", reviewContent=" + reviewContent + ", reviewGrade=" + reviewGrade + ", userAge=" + userAge
				+ ", userGender=" + userGender + ", reviewDateCreated=" + reviewDateCreated + ", uvo=" + uvo + "]";
	}
	
} // end ReviewVO
