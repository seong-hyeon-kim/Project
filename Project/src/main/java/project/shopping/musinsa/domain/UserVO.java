package project.shopping.musinsa.domain;

public class UserVO {

	// 멤버 변수
	private String userId; // 회원 아이디
	private String userPassword; // 회원 비밀번호
	private String userName; // 회원 이름
	private String userGender; // 회원 성별
	private String userHeight; // 회원 키 
	private String userWeight; // 회원 몸무게
	private int userAge; // 회원 나이
	private String userEmail; // 회원 이메일
	private String userPhone; // 회원 전화번호
	private String userAddress01; // 회원 주소 1
	private String userAddress02; // 회원 주소 2
	private String userAddress03;// 회원 주소 3
	private String userAddress04;// 회원 주소 4
	private int verify; // 운영자 권한
	
	
	// 기본 생성자
	public UserVO() {}

	 // 매개변수가 있는 생성자
	public UserVO(String userId, String userPassword, String userName, String userGender, String userHeight,
			String userWeight, int userAge, String userEmail, String userPhone, String userAddress01,
			String userAddress02, String userAddress03, String userAddress04, int verify) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userGender = userGender;
		this.userHeight = userHeight;
		this.userWeight = userWeight;
		this.userAge = userAge;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAddress01 = userAddress01;
		this.userAddress02 = userAddress02;
		this.userAddress03 = userAddress03;
		this.userAddress04 = userAddress04;
		this.verify = verify;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserHeight() {
		return userHeight;
	}

	public void setUserHeight(String userHeight) {
		this.userHeight = userHeight;
	}

	public String getUserWeight() {
		return userWeight;
	}

	public void setUserWeight(String userWeight) {
		this.userWeight = userWeight;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress01() {
		return userAddress01;
	}

	public void setUserAddress01(String userAddress01) {
		this.userAddress01 = userAddress01;
	}

	public String getUserAddress02() {
		return userAddress02;
	}

	public void setUserAddress02(String userAddress02) {
		this.userAddress02 = userAddress02;
	}

	public String getUserAddress03() {
		return userAddress03;
	}

	public void setUserAddress03(String userAddress03) {
		this.userAddress03 = userAddress03;
	}

	public String getUserAddress04() {
		return userAddress04;
	}

	public void setUserAddress04(String userAddress04) {
		this.userAddress04 = userAddress04;
	}

	public int getVerify() {
		return verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userGender=" + userGender + ", userHeight=" + userHeight + ", userWeight=" + userWeight
				+ ", userAge=" + userAge + ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", userAddress01="
				+ userAddress01 + ", userAddress02=" + userAddress02 + ", userAddress03=" + userAddress03
				+ ", userAddress04=" + userAddress04 + ", verify=" + verify + "]";
	}


} // end UserVO
