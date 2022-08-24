package com.iu.start.util;

public class Pager {
	
	/*
	 * 파라미터를 담을 변수 page
	 * jsp에서 꺼내서 사용할 변수
	 * mapper에서 꺼내서 사용할 변수
	 * perPage : 한 페이지에 출력할 글의 갯수
	 * perBlock : 한 페이지에 출력할 번호의 개수
	 * 
	 * 
	*/
	
	//멤버변수
	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long startRow;
	private Long lastRow;
	private Long perPage;
	private Long perBlock;
	
	private Pager() {
		this.perPage=10L;
		this.perBlock=5L;
	}
	
	//1. mapper에서 사용할 값 계산
	public void getRowNum()throws Exception{
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPerPage()*this.getPage();
	}
	
	//2. Jsp에서 사용할 값 계산
	public void getNum(Long totalCount)throws Exception{
		//2. totalCount로 totalPage구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage()!=0) {
			totalPage +=1;
		}
		//3. totlaPage를 이용해 totalBlcok 구하기
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock()!=0) {
			totalBlock +=1;
		}
		//4. page로 curBlock 구하기
		Long curBlock = this.getPage()/this.getPerBlock();
		if(this.getPage()%this.getPerBlock()!=0) {
			curBlock +=1;
		}
		//5. curBlock으로 시작번호와 끝번호 (startNum, lastNum) 계산
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();
	}
	
	
	public Long getPage() {
		if(this.page==null) {
			this.page=1L;
		}
		
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPerBlock() {
		if(this.perBlock==null) {
			this.perBlock=5L;
		}
		return perBlock;
	}
	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}
	
	
	

}
