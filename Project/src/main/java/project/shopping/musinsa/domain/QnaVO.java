package project.shopping.musinsa.domain;

import java.util.Date;

public class QnaVO {
	private int productQuestionNumber;
	private String userId;
	private String productQuestionWhether;
	private String productQuestionType;
	private String productQuestionContent;
	private Date productQuestionDateCreated;
	private String productQuestionTitle;
	private int productNumber;
	
	public QnaVO() {}

	public QnaVO(int productQuestionNumber, String userId, String productQuestionWhether, String productQuestionType,
			String productQuestionContent, Date productQuestionDateCreated, String productQuestionTitle, int productNumber) {
		super();
		this.productQuestionNumber = productQuestionNumber;
		this.userId = userId;
		this.productQuestionWhether = productQuestionWhether;
		this.productQuestionType = productQuestionType;
		this.productQuestionContent = productQuestionContent;
		this.productQuestionDateCreated = productQuestionDateCreated;
		this.productQuestionTitle = productQuestionTitle;
		this.productNumber = productNumber;
	}

	public int getProductQuestionNumber() {
		return productQuestionNumber;
	}

	public void setProductQuestionNumber(int productQuestionNumber) {
		this.productQuestionNumber = productQuestionNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductQuestionWhether() {
		return productQuestionWhether;
	}

	public void setProductQuestionWhether(String productQuestionWhether) {
		this.productQuestionWhether = productQuestionWhether;
	}

	public String getProductQuestionType() {
		return productQuestionType;
	}

	public void setProductQuestionType(String productQuestionType) {
		this.productQuestionType = productQuestionType;
	}

	public String getProductQuestionContent() {
		return productQuestionContent;
	}

	public void setProductQuestionContent(String productQuestionContent) {
		this.productQuestionContent = productQuestionContent;
	}

	public Date getProductQuestionDateCreated() {
		return productQuestionDateCreated;
	}

	public void setProductQuestionDateCreated(Date productQuestionDateCreated) {
		this.productQuestionDateCreated = productQuestionDateCreated;
	}

	public String getProductQuestionTitle() {
		return productQuestionTitle;
	}

	public void setProductQuestionTitle(String productQuestionTitle) {
		this.productQuestionTitle = productQuestionTitle;
	}
	
	public int getProductNumber() {
		return productNumber;
	}
	
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	@Override
	public String toString() {
		return "QnaVO [productQuestionNumber=" + productQuestionNumber + ", userId=" + userId
				+ ", productQuestionWhether=" + productQuestionWhether + ", productQuestionType=" + productQuestionType
				+ ", productQuestionContent=" + productQuestionContent + ", productQuestionDateCreated="
				+ productQuestionDateCreated + ", productQuestionTitle=" + productQuestionTitle + ", productNumber=" + productNumber + "]";
	}
	
} // end QnaVO
