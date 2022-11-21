package project.shopping.musinsa.domain;

import java.util.Date;

public class BoardVO {
	
	// 멤버 변수
	private int boardNumber; // 게시판 번호
	private String userId; // 글 작성자
	private String boardTitle; // 게시판 제목
	private String boardContent; // 게시판 내용
	private Date boardDateCreated; // 게시판 작성 시간
	
	
	// 기본 생성자
	public BoardVO() {
	}

	
	// 매개변수가 있는 생성자
	public BoardVO(int boardNumber, String userId, String boardTitle, String boardContent, Date boardDateCreated) {
		super();
		this.boardNumber = boardNumber;
		this.userId = userId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDateCreated = boardDateCreated;
	}


	public int getBoardNumber() {
		return boardNumber;
	}


	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getBoardTitle() {
		return boardTitle;
	}


	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}


	public String getBoardContent() {
		return boardContent;
	}


	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}


	public Date getBoardDateCreated() {
		return boardDateCreated;
	}


	public void setBoardDateCreated(Date boardDateCreated) {
		this.boardDateCreated = boardDateCreated;
	}


	@Override
	public String toString() {
		return "BoardVO [boardNumber=" + boardNumber + ", userId=" + userId + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardDateCreated=" + boardDateCreated + "]";
	}

	
} // end boardVO
