package org.jin.service;

import org.jin.aop.SampleAdvice;
import org.jin.mapper.Tran1DAO;
import org.jin.mapper.Tran2DAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TranServiceImpl implements TranService{
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleAdvice.class);
	@Autowired
	private Tran1DAO tdao1;
	@Autowired
	private Tran2DAO tdao2;
	
	@Transactional
	@Override
	public void addData(String value) {
		// TODO Auto-generated method stub
		logger.info("transaction 적용하기 후");
		tdao1.inserCol1(value);
		tdao2.inserCol1(value);
		
	}
	
	

}
