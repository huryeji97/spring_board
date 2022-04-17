package edu.spring.ex02.pageutil;

// 브라우저에서 보여질 페이지 번호와
// 한 페이지에서 보여질 게시글의 개수를 저장하는 클래스
// -> paging 처리에 필요한 start와 end 번호를 알 수 있음
public class PageCriteria {
	private int page; // 현재 페이지 번호
	private int perPageNum; // 한 페이지의 게시글 갯수
	
	public PageCriteria() {
		this.page = 1;
		this.perPageNum = 10;
	}
	
	// 특정 페이지의 게시글 시작번호, 게시글 시작 행 번호
	public int getPageStart() { 
        return (this.page - 1) * perPageNum;
    }
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if(page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }
    
    public int getPerPageNum() {
        return perPageNum;
    }
    
    public void setPerPageNum(int pageCount) {
        int count = this.perPageNum;
        if(pageCount != count) {
            this.perPageNum = count;
        } else {
            this.perPageNum = pageCount;
        }
    }
}