package project.shopping.musinsa.domain;

import java.util.Date;

public class ReplyVO {
	private int replyNumber;
	private int reviewNumber;
	private String replyContent;
	private String userId;
	private Date replyDateCreated;
	private ReReplyVO reReplyVO;
	
	public ReplyVO() {}
	
	public ReplyVO(int replyNumber, int reviewNumber, String replyContent, String userId, Date replyDateCreated,
			ReReplyVO reReplyVO) {
		this.replyNumber = replyNumber;
		this.reviewNumber = reviewNumber;
		this.replyContent = replyContent;
		this.userId = userId;
		this.replyDateCreated = replyDateCreated;
		this.reReplyVO = reReplyVO;
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
	
	public String getReplyContent() {
		return replyContent;
	}
	
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Date getReplyDateCreated() {
		return replyDateCreated;
	}
	
	public void setReplyDateCreated(Date replyDateCreated) {
		this.replyDateCreated = replyDateCreated;
	}
	
	public ReReplyVO getReReplyVO() {
		return reReplyVO;
	}
	
	public void setReReplyVO(ReReplyVO reReplyVO) {
		this.reReplyVO = reReplyVO;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [replyNumber=" + replyNumber + ", reviewNumber=" + reviewNumber + ", replyContent="
				+ replyContent + ", userId=" + userId + ", replyDateCreated=" + replyDateCreated + ", reReplyVO="
				+ reReplyVO + "]";
	}

} // end ReplyVO
