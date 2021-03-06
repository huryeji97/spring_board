package edu.spring.ex02;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;
import edu.spring.ex02.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class BoardDAOTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Autowired
	private BoardDAO dao;
	
	@Test
	public void testDAO() {
//		testInsert();
//		testSelectByBoardSeq();
//		testDelete();
//		testTotalCount();
		testSelectPaging();
	}
	
	private void testInsert() {
		BoardVO vo = new BoardVO(0, "test", "test", "admin", null);
		int result = dao.insert(vo);
		if(result == 1) {
			LOGGER.info("insert 성공");
		} else {
			LOGGER.info("insert 실패");
		}
	}
	
	private void testSelectByBoardSeq() {
		BoardVO vo = dao.select(2);
		LOGGER.info(vo.toString());
	}
	
	private void testSelectPaging() {
		PageCriteria criteria = new PageCriteria(1, 5);
		List<BoardVO> list = dao.select(criteria);
		for(BoardVO vo : list) {
			LOGGER.info(vo.toString());
		}
	}
	
	private void testDelete() {
		int result = dao.delete(2);
		LOGGER.info(result + "행 삭제");
	}
	
	private void testTotalCount() {
		LOGGER.info(dao.getTotalNums() + "rows");
	}
}
