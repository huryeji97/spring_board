package edu.spring.ex02.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;

@Repository
public class BoardDAOImple implements BoardDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardDAOImple.class);
	private static final String NAMESPACE = "edu.spring.ex02.BoardMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(BoardVO vo) {
		LOGGER.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<BoardVO> select(PageCriteria c) {
		LOGGER.info("select() 호출 : PageCriteria = " + c);
		return sqlSession.selectList(NAMESPACE + ".select_all_paging", c);
	}
	
	@Override
	public BoardVO select(int boardSeq) {
		LOGGER.info("select() 호출 : boardSeq = " + boardSeq);
		return sqlSession.selectOne(NAMESPACE + ".select_by_board_seq", boardSeq);
	}

	@Override
	public int update(BoardVO vo) {
		LOGGER.info("update() 호출 : vo = " + vo);
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int boardSeq) {
		LOGGER.info("delete() 호출 : boardSeq = " + boardSeq);
		return sqlSession.delete(NAMESPACE + ".delete", boardSeq);
	}

	@Override
	public int getTotalNums() {
		LOGGER.info("getTotalNums() 호출");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}
}
