package com.choa.ex6;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDAOImpl;


public class ConnectionTest extends MyAbstractTestUnit{
	@Autowired
	//private SqlSession sqlSession;
	private NoticeDAOImpl noticeDAOImpl;
	@Test
	public void test()throws Exception{
		//assertNotNull(sqlSession);
		BoardDTO boardDTO=noticeDAOImpl.boardView(47);
		assertNotNull(boardDTO);
	}
	
	

}
