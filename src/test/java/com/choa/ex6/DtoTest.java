package com.choa.ex6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.choa.memo.MemoDAO;
import com.choa.memo.MemoDTO;

public class DtoTest extends MyAbstractTestUnit{
	
	@Autowired
	private MemoDAO memoDAO;
	
	@Test
	public void test() throws Exception{
		
		int result = memoDAO.boardDelete(1);
		assertEquals(1, result);
	}
}
