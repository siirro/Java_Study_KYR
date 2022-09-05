package com.iu.start.bankBook;

import com.iu.start.board.impl.CommentDTO;

public class BankBookCommentDTO extends CommentDTO{
	
	private Long BookNum;

	public Long getBookNum() {
		return BookNum;
	}

	public void setBookNum(Long bookNum) {
		BookNum = bookNum;
	}
	
	

}
