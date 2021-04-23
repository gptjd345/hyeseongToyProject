package com.example.toyProject.util;

public class Pager {
	public static final int BLOCK_SCALE = 10; //한 페이지에 보여줄 블록 수
	public static final int PAGE_SCALE = 10; //한 페이지에 보여줄 레코드수
	
	
	private int curBlock; //현재 블록 
	
	private int startBlock; //해당 블록의 첫번째 블록
	private int endBlock; //해당 블록의 마지막 블록
	
	private int pageEnd = PAGE_SCALE * curBlock;  // 해당 블록의 리스트 중 마지막 행
	private int pageBegin = pageEnd - (PAGE_SCALE-1); // 해당 블록의 리스트 중 첫번째 행 
	
	private int totPage; //전체 페이지 개수 DB에 질문해야함
	private int totBlock; //전체 블록 개수 totPage를 전체 블록수 로 나눈다. 
	
	private int prevBlock; //이전 블록
	private int nextBlock; //다음 블록
	
	//기본 값은 1로 설정
	public Pager(int totalPage,int currentBlock)
	{
		setTotPage(totalPage); //전체 레코드 수 저장 
		setTotBlock(); //전체 블록 수 저장
		
		setCurBlock(currentBlock); //현재 블록 번호 초기화
		
		setBlockRange(); //블록 범위 조정
		setPageRange(); //페이지 범위 조정
		
	}
	
	public void setBlockRange()
	{
		startBlock = curBlock - (curBlock - 1) % BLOCK_SCALE; //블록의 시작값 저장
		
		endBlock = startBlock + (BLOCK_SCALE-1); //블록의 마지막 값 저장
		
		//만약 계산한 블록 수가 전체 블록 수보다 더 크다면 전체블록 수를 따른다. 
		if(endBlock > totBlock)
			endBlock = totBlock;
		
		//이전 눌렀을 때 이동할 블럭 번호
        if(startBlock - BLOCK_SCALE > 0)
		prevBlock = startBlock - BLOCK_SCALE;
        
        else prevBlock = 1;
        
        //다음 눌렀을 때 이동할 블럭 번호
        if(endBlock + 1 < totBlock)
        nextBlock = endBlock + 1;
        else nextBlock = totBlock;
        
	
	}
	
	public void setPageRange()
	{
		pageEnd = curBlock * PAGE_SCALE ; //마지막 레코드 번호
		pageBegin = pageEnd - (PAGE_SCALE-1); //레코드 시작 번호 
		
		//만약 계산한 페이지 수가 전체 페이지 수보다 더 크다면 전체 페이지 수를 따른다. 
		if(pageEnd >= totPage)
			pageEnd = totPage;
		
		
		
		
	}
	
	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getPrevBlock() {
		return prevBlock;
	}


	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}


	public int getNextBlock() {
		return nextBlock;
	}


	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}


	public int getTotPage() {
		return totPage;
	}

	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}

	public int getTotBlock() {
		return totBlock;
	}

	public void setTotBlock() {
		totBlock = totPage / PAGE_SCALE;
		if(totPage % PAGE_SCALE > 0)
			totBlock++;
	}

	public int getStartBlock() {
		return startBlock;
	}

	public int getendBlock() {
		return endBlock;
	}
	
	public int getPageEnd() {
		return pageEnd;
	}

	public int getPageBegin() {
		return pageBegin;
	}



	
	
	
	
}
