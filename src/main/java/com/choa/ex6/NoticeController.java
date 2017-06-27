package com.choa.ex6;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import javax.inject.Inject;
import javax.xml.ws.RequestWrapper;

import org.omg.CORBA.BAD_INV_ORDER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeServiceImpl;
import com.choa.util.ListInfo;
import com.choa.util.RowMaker;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Inject //type으로 찾아라
	private NoticeServiceImpl noticeService;
	
	//list
	@RequestMapping(value="noticeList", method=RequestMethod.GET)
	public String noticeList(Model model, ListInfo listInfo) throws Exception{
		System.out.println(listInfo.getCurPage());
		List<BoardDTO> ar=noticeService.boardList(listInfo);
		System.out.println(ar.get(1000).getTitle());
		/*try {
			System.out.println(ar.get(1000).getTitle());
			throw new IndexOutOfBoundsException();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} -> @ControllerAdvice에서 exception 처리 */
		model.addAttribute("list", ar);
		model.addAttribute("board", "notice");
		model.addAttribute("listInfo", listInfo);
		return "board/boardList";
	}
	
	//view
	@RequestMapping(value="noticeView", method=RequestMethod.GET)
	public String noticeView(Integer num, Model model) throws Exception{
		BoardDTO boardDTO= noticeService.boardView(num);
		model.addAttribute("view", boardDTO);
		return "board/boardView";
	}
	
	//writeForm
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public String noticeWrite(Model model){
		model.addAttribute("path", "Write");
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}
	
	//write
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public String noticeWrite(BoardDTO boardDTO, RedirectAttributes rd) throws Exception{	
		int result=noticeService.boardWrite(boardDTO);
		String message="Fail";
		if(result>0){
			message="success";
		}
		rd.addFlashAttribute("message", message);

		// 포워드로 return "notice/result";
		//redirect : 주소를 직접 다시 치고 가라 : 글 작성.실패와 관계없이 form으로 감
		//절대경로 return "redirect:/notice/noticeList";
		//상대경로
		return "redirect:noticeList?curPage=1";
		//절대경로나 상대경로 둘다 상관없음. 위와 같이 파라미터 전달가능
	}
	
	//updateform
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public String noticeUpdate(Integer num, Model model) throws Exception{
		BoardDTO boardDTO = noticeService.boardView(num);
		model.addAttribute("dto", boardDTO);
		model.addAttribute("path", "Update");
		return "notice/noticeWrite";
	}
	
	//update
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public String noticeUpdate2(BoardDTO boardDTO, RedirectAttributes rd) throws Exception{
		int result = noticeService.boardUpdate(boardDTO);
		String message = "Fail";
		if(result>0){
			message="success";
		}
		rd.addFlashAttribute("message", message);
		return "redirect:/notice/noticeList?curPage=1";
	}
	
	//delete
	@RequestMapping(value="noticeDelete", method=RequestMethod.GET)
	public String noticeDelete(Integer num, RedirectAttributes rd) throws Exception{
		int result = noticeService.boardDelete(num);
		String message="Fail";
		if(result>0){
			message="success";
		}
		rd.addFlashAttribute("message", message);
		return "redirect:/notice/noticeList?curPage=1";
	}
	
}
