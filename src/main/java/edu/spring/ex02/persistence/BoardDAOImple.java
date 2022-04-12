package edu.spring.ex02.persistence;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.BoardVO;

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
}
