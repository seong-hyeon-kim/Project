package project.shopping.musinsa.domain;

public class UserVO {

	// ��� ����
	private String userId; // ȸ�� ���̵�
	private String userPassword; // ȸ�� ��й�ȣ
	private String userName; // ȸ�� �̸�
	private String userGender; // ȸ�� ����
	private String userHeight; // ȸ�� Ű 
	private String userWeight; // ȸ�� ������
	private int userAge; // ȸ�� ����
	private String userEmail; // ȸ�� �̸���
	private String userPhone; // ȸ�� ��ȭ��ȣ
	private String userAddress01; // ȸ�� �ּ� 1
	private String userAddress02; // ȸ�� �ּ� 2
	private String userAddress03;// ȸ�� �ּ� 3
	private String userAddress04;// ȸ�� �ּ� 4
	private int verify; // ��� ����
	
	
	// �⺻ ������
	public UserVO() {}

	 // �Ű������� �ִ� ������
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
