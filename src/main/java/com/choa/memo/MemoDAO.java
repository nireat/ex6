package com.choa.memo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.util.ListInfo;

@Repository
public class MemoDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="MemoMapper.";

	//count
	public int boardCount(ListInfo listInfo)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"count", listInfo);
	}
	
	//list
	public List<MemoDTO> boardList(ListInfo listInfo) throws Exception{
	
		return sqlSession.selectList(NAMESPACE+"list", listInfo);
	}
	
	//insert
	public int boardWrite(MemoDTO memoDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"write", memoDTO);
	}
	
	//view
	public MemoDTO boardview(int num) throws Exception{
		
		MemoDTO memoDTO=sqlSession.selectOne(NAMESPACE+"view", num);
		return memoDTO;
	}
	
	//update
	public int boardUpdate(MemoDTO memoDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE+"update", memoDTO);
	}
	
	//delete
	public int boardDelete(int num)throws Exception{
		
		return sqlSession.delete(NAMESPACE+"delete", num); 
	}
	
	
}
