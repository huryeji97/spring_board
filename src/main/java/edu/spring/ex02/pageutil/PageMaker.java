package edu.spring.ex02.pageutil;

// 페이지 번호들의 링크를 만들기 위한 유틸리티 클래스
public class PageMaker {

	private PageCriteria criteria;
	private int totalCount; // 전체 게시글 개수
	private int numsOfPageLinks; // 페이지 번호 링크의 개수
	private int startPageNo; // 시작 페이지 링크 번호
	private int endPageNo; // 끝 페이지 링크 번호
	private boolean hasPrev; // 화면에 보이는 시작 페이지 번호보다 작은 숫자의 페이지가 있는 지
	private boolean hasNext; // 화면에 보이는 끝 페이지 번호보다 큰 숫자의 페이지가 있는 지
	
	public PageMaker() {
		this.numsOfPageLinks = 5;
	}
	
	public PageCriteria getCriteria() {
		return criteria;
	}
	
	public void setCriteria(PageCriteria criteria) {
		this.criteria = criteria;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		setPageData();
	}
	
	public int getNumsOfPageLinks() {
		return numsOfPageLinks;
	}
	
	public int getStartPageNo() {
		return startPageNo;
	}
	
	public int getEndPageNo() {
		return endPageNo;
	}
	
	public boolean isHasPrev() {
		return hasPrev;
	}
	
	public boolean isHasNext() {
		return hasNext;
	}
	
	// startPageNo, endPageNo, hasPrev, hasNext 값을 계산 및 세팅
	public void setPageData() {
		// criteria.getPage() : 현재 페이지 번호
		// 끝 페이지 번호 = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 갯수) * 화면에 보여질 페이지 번호의 갯수
		endPageNo = (int) (Math.ceil(criteria.getPage() / (double) numsOfPageLinks) * numsOfPageLinks);
 
		// //시작 페이지 번호 = (끝 페이지 번호 - 화면에 보여질 페이지 번호의 갯수) + 1
        startPageNo = (endPageNo - numsOfPageLinks) + 1;
        if(startPageNo <= 0) startPageNo = 1;
        
        // criteria.getPerPageNum() : 한 페이지당 보여줄 게시글의 갯수
        // 마지막 페이지 번호 = 총 게시글 수 / 한 페이지당 보여줄 게시글의 갯수
        int tempEndPage = (int) (Math.ceil(totalCount / (double) criteria.getPerPageNum()));
        if (endPageNo > tempEndPage) {
        	endPageNo = tempEndPage;
        }
 
        hasPrev = startPageNo == 1 ? false : true;
        hasNext = endPageNo * criteria.getPerPageNum() < totalCount ? true : false;
		// Math.ceil (올림)
		// Math.floor (버림)	
	}
} // end PageMaker