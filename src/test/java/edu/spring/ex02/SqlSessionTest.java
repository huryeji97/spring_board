package edu.spring.ex02;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class SqlSessionTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(SqlSessionTest.class);
	private static final String NAMESPACE = "edu.spring.ex02.BoardMapper";
	// board-mapper.xml파일의 <mapper namespace="edu.spring.ex02.BoardMapper"> namespace와 동일
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO(0, "hello", "hello", "test", null);
		int result = sqlSession.insert(NAMESPACE + ".insert", vo); 
		// .insert : mapper.xml의 id값
		LOGGER.info(result + "행 삽입");
	}
}
