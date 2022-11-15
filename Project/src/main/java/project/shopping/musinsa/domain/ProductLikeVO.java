package project.shopping.musinsa.domain;

public class ProductLikeVO {
	private int likeNumber;
	private String userId;
	private int productNumber;
	private ProductVO productVO;
	
	public ProductLikeVO() {

	}
	
	public ProductLikeVO(int likeNumber, String userId, int productNumber, ProductVO productVO) {
		this.likeNumber = likeNumber;
		this.userId = userId;
		this.productNumber = productNumber;
		this.productVO = productVO;
	}
	public int getLikeNumber() {
		return likeNumber;
	}
	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
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
	public ProductVO getProductVO() {
		return productVO;
	}
	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}
	@Override
	public String toString() {
		return "ProductLikeVO [likeNumber=" + likeNumber + ", userId=" + userId + ", productNumber=" + productNumber
				+ ", productVO=" + productVO + "]";
	}
	
	
	
}