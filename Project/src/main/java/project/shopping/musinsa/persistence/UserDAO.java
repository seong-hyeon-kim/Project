package project.shopping.musinsa.persistence;

import java.util.List;

import project.shopping.musinsa.domain.UserVO;

public interface UserDAO {

	// ȸ�� ���
	int insert(UserVO vo);
	
	// ȸ�� ���� �˻�
	public UserVO select(String userId) throws Exception;
	
	// ȸ�� ��ü �˻�
	List<UserVO> select();
	
	// ȸ�� ���� ����
	int update(UserVO vo);
	
	// ȸ�� Ż��
	int delete(String userId);
	
	// �α���
	UserVO login(UserVO vo);
	
	// ���̵� �ߺ�üũ
	int idChk(String userId);
	
	// �н����� üũ
	int passwordChk(UserVO vo);
	
	
} // end UserDAO

