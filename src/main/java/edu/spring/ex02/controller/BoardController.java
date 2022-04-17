package edu.spring.ex02.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;
import edu.spring.ex02.pageutil.PageMaker;
import edu.spring.ex02.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	// 글목록 list
	@GetMapping("/list")
	public void list(Model model, Integer page, Integer perPageNum) { // perPageNum : 한페이지에 표시될 글의 갯수
		LOGGER.info("list() 호출 : page = " + page + ", perPageNum = " + perPageNum);
		
		// Paging 처리
		PageCriteria c = new PageCriteria();
		// nullPointerException 방지
		if(page != null) {
			c.setPage(page);
		}
		if(perPageNum != null) {
			c.setPerPageNum(perPageNum);
		}
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(c);
		maker.setTotalCount(boardService.getTotalNums());
		model.addAttribute("maker", maker);
		
		List<BoardVO> list = boardService.read(c);
		model.addAttribute("list", list);
	} // end list()
	
	// 글 작성 register - 페이지 GET방식
	@GetMapping("/register")
	public void registerGET() {
		LOGGER.info("registerGET() 호출");
	} // end registerGET()
	
	// 글 작성 register - 디비저장 POST방식
	@PostMapping("/register")
	public String registerPOST(BoardVO vo, RedirectAttributes reAttr) { // RedirectAttributes : 재경로 위치에 속성값을 전송하는 객체
		LOGGER.info("registerPOST() 호출 : vo = " + vo.toString());
		int result = boardService.create(vo);
		LOGGER.info(result + "행 삽입");
		
		// redirect로 넘기면서 데이터도 넘긴다.
		if(result == 1) { // 성
			// "insert_result"의 키 이름을 가진 데이터 전송
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/board/list";
		} else { // 실패
			// "insert_result"의 키 이름을 가진 데이터 전송
			reAttr.addFlashAttribute("insert_result", "fail");			
			return "redirect:/board/list";
		}
	} // end registerPOST()
}
