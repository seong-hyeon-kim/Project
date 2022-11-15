package project.shopping.musinsa.domain;

public class CartVO {
	private int cartNumber;
	private String userId;
	private int productNumber;
	private int cartAmount;
	private String cartSize;
	private ProductVO productVO;
	
	public CartVO() {

	}

	public CartVO(int cartNumber, String userId, int productNumber, int cartAmount, String cartSize,
			ProductVO productVO) {
		super();
		this.cartNumber = cartNumber;
		this.userId = userId;
		this.productNumber = productNumber;
		this.cartAmount = cartAmount;
		this.cartSize = cartSize;
		this.productVO = productVO;
	}

	public int getCartNumber() {
		return cartNumber;
	}

	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
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

	public int getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(int cartAmount) {
		this.cartAmount = cartAmount;
	}

	public String getCartSize() {
		return cartSize;
	}

	public void setCartSize(String cartSize) {
		this.cartSize = cartSize;
	}

	public ProductVO getProductVO() {
		return productVO;
	}

	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}

	@Override
	public String toString() {
		return "CartVO [cartNumber=" + cartNumber + ", userId=" + userId + ", productNumber=" + productNumber
				+ ", cartAmount=" + cartAmount + ", cartSize=" + cartSize + ", productVO=" + productVO + "]";
	}
	
	
	
	
	}
