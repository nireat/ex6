package com.choa.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {
	
	@Autowired
	private TableDAO tableDAO;
	
	public int insertTable(TableADTO tableADTO, int num) throws Exception{
		tableDAO.insertTableA(tableADTO);
		TableBDTO tableBDTO = new TableBDTO();
		tableBDTO.setWriter(tableADTO.getWriter());
		tableBDTO.setPoint(10);
		tableBDTO.setNum(num);
		return tableDAO.insertTableB(tableBDTO);
	}

}
