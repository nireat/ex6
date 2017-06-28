package com.choa.ex6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.table.TableADTO;
import com.choa.table.TableService;

public class TableTest extends MyAbstractTestUnit{
	
	@Autowired
	private TableService tableService;
	
	@Test
	public void test() throws Exception{
		TableADTO tableADTO = new TableADTO();
		tableADTO.setNum(4);
		tableADTO.setTitle("t3");
		tableADTO.setWriter("t3");
		int result = tableService.insertTable(tableADTO, 1);
		assertNotEquals(0, result);
	}
}
