package edu.spring.ex02.persistence;

import java.util.List;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;

public interface BoardDAO {
	// 등록(insert)
	public abstract int insert(BoardVO vo);
	// 목록(select all)
	public abstract List<BoardVO> select();
	// 정보(select one)
	public abstract BoardVO select(int boardSeq);
	// 수정(update)
	public abstract int update(BoardVO vo);
	// 삭제(delete)
	public abstract int delete(int boardSeq);
	// 페이지처리한 목록(select all)
	public abstract List<BoardVO> select(PageCriteria c);
	// 토탈 갯수
	public abstract int getTotalNums();
	// 검색
	public abstract List<BoardVO> select(String userid);
	public abstract List<BoardVO> selectByTitleOrContent(String keyword);
}
