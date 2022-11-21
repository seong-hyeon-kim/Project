package project.shopping.musinsa.service;

import java.util.List;

import project.shopping.musinsa.domain.UserVO;

// CRUD (Create, Read, Update, Delete)
public interface UserService {

	// ���
	int create(UserVO vo);
	
	// �˻�
	 UserVO read(String userId) throws Exception;
	
	// ��ü�˻�
	List<UserVO> read(UserVO vo);
	
	// ����
	int update(UserVO vo);
	
	// Ż��
	int delete(String userId);

	// �α��� 
	UserVO Login(UserVO vo); 
	
	// ���̵� �ߺ�üũ
	int idChk(String userId) throws Exception;
	
	// �н����� üũ
	int passwordChk(UserVO vo);
	
} // end userService
