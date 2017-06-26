package com.choa.ex6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;

@Controller
@RequestMapping(value="/memo/**")
public class MemoController {

	@Autowired
	private MemoService memoService; 

	//list
	@RequestMapping(value="memoList")
	public void memoList(){
		
	}
	
	@RequestMapping(value="getMemoList/{curPage}/{find}/{search}/")
	@ResponseBody
	//리턴하는 데이터를 view가 아니라 body로
	public List<MemoDTO> memoList(@PathVariable("curPage") int curPage, @PathVariable String find,@PathVariable String search)throws Exception{
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(curPage);
		listInfo.setFind(find);
		listInfo.setSearch(search);
		List<MemoDTO> list=memoService.boardList(listInfo);
		
		return list;
		
	}
	
	@RequestMapping(value="memoView/{num}")
	@ResponseBody
	public MemoDTO memoView(@PathVariable int num) throws Exception{
		MemoDTO memoDTO = memoService.boardView(num);
		return memoDTO;
	}
	
	@RequestMapping(value="memoWrite", method=RequestMethod.POST)
	@ResponseBody
	public List<MemoDTO> memoWrite(MemoDTO memoDTO, Model model) throws Exception{
		int result = memoService.boardWrite(memoDTO);
		/*String message ="fail";
		if(result>0){
			message= "success";
		}
		model.addAttribute("message", message);
		return "commons/ajaxResult";
		
		*/
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(1);
		List<MemoDTO> list=memoService.boardList(listInfo);
/*		model.addAttribute("list", list);
		memoService.boardList(listInfo);*/
		return list;
	}
	
}
