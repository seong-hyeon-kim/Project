package project.shopping.musinsa.domain;

import java.util.Date;

public class ReReplyVO {
	private int reReplyNumber;
	private int replyNumber;
	private int reviewNumber;
	private String reReplyContent;
	private String userId;
	private Date reReplyDate;
	
	public ReReplyVO() {}

	public ReReplyVO(int reReplyNumber, int replyNumber, int reviewNumber, String reReplyContent, String userId,
			Date reReplyDate) {
		this.reReplyNumber = reReplyNumber;
		this.replyNumber = replyNumber;
		this.reviewNumber = reviewNumber;
		this.reReplyContent = reReplyContent;
		this.userId = userId;
		this.reReplyDate = reReplyDate;
	}

	public int getReReplyNumber() {
		return reReplyNumber;
	}

	public void setReReplyNumber(int reReplyNumber) {
		this.reReplyNumber = reReplyNumber;
	}

	public int getReplyNumber() {
		return replyNumber;
	}

	public void setReplyNumber(int replyNumber) {
		this.replyNumber = replyNumber;
	}

	public int getReviewNumber() {
		return reviewNumber;
	}

	public void setReviewNumber(int reviewNumber) {
		this.reviewNumber = reviewNumber;
	}

	public String getReReplyContent() {
		return reReplyContent;
	}

	public void setReReplyContent(String reReplyContent) {
		this.reReplyContent = reReplyContent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getReReplyDate() {
		return reReplyDate;
	}

	public void setReReplyDate(Date reReplyDate) {
		this.reReplyDate = reReplyDate;
	}

	@Override
	public String toString() {
		return "ReReplyVO [reReplyNumber=" + reReplyNumber + ", replyNumber=" + replyNumber + ", reviewNumber="
				+ reviewNumber + ", reReplyContent=" + reReplyContent + ", userId=" + userId + ", reReplyDate="
				+ reReplyDate + "]";
	}
	
} // end ReReplyVO
