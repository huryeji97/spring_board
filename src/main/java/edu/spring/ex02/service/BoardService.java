package edu.spring.ex02.service;

import java.util.List;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;

// CRUD (CREATE, READ, UPDATE, DELETE)
public interface BoardService {
	// 게시글 등록(insert)
	public abstract int create(BoardVO vo);
	// 페이지 처리가 된 전체 게시글 목록(select all)
	public abstract List<BoardVO> read(PageCriteria c);
	// 선택한 boardSeq 게시글 정보(select one)
	public abstract BoardVO read(int boardSeq);
	// 수정(update)
	public abstract int update(BoardVO vo);
	// 삭제(delete)
	public abstract int delete(int boardSeq);
	// 토탈 갯수
	public abstract int getTotalNums();
}
