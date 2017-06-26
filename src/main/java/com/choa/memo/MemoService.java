package com.choa.memo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.util.ListInfo;

@Service
public class MemoService {
	
	@Autowired
	private MemoDAO memoDAO;
	
	//list
	public List<MemoDTO> boardList(ListInfo listInfo) throws Exception{
		int count = memoDAO.boardCount(listInfo);
		listInfo.makePage(count);
		listInfo.setRow();
		return memoDAO.boardList(listInfo);
	}
	
	public int boardWrite(MemoDTO memoDTO) throws Exception{
		return memoDAO.boardWrite(memoDTO);
	}
	
	public MemoDTO boardView(int num) throws Exception{
		return memoDAO.boardview(num);
	}
	
	public int boardUpdate(MemoDTO memoDTO) throws Exception{
		return memoDAO.boardUpdate(memoDTO);
	}
	
	public int boardDelete(int num) throws Exception{
		return memoDAO.boardDelete(num);
	}
	
	
}
