package edu.spring.ex02.persistence;

import edu.spring.ex02.domain.BoardVO;

public interface BoardDAO {
	public abstract int insert(BoardVO vo);
}
