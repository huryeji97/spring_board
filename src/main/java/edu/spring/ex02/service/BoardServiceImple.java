package edu.spring.ex02.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;
import edu.spring.ex02.persistence.BoardDAO;

@Service
public class BoardServiceImple implements BoardService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardServiceImple.class);

	@Autowired
	private BoardDAO dao;
	
	@Override
	public int create(BoardVO vo) {
		LOGGER.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public List<BoardVO> read(PageCriteria c) {
		LOGGER.info("read() 호출 : PageCriteria = " + c);
		return dao.select(c);
	}

	@Override
	public BoardVO read(int boardSeq) {
		LOGGER.info("read() 호출 : boardSeq = " + boardSeq);
		return dao.select(boardSeq);
	}

	@Override
	public int update(BoardVO vo) {
		LOGGER.info("udpate() 호출 : vo = " + vo.toString());
		return dao.update(vo);
	}

	@Override
	public int delete(int boardSeq) {
		LOGGER.info("delete() 호출 : boardSeq = " + boardSeq);
		return dao.delete(boardSeq);
	}

	@Override
	public int getTotalNums() {
		LOGGER.info("getTotalNums() 호출");
		return dao.getTotalNums();
	}

}
