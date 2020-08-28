package org.jin.service;

import org.jin.mapper.MemberMapper;
import org.jin.mapper.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper memapper;
	@Override
	public MemberVO login(MemberVO member) {
		// TODO Auto-generated method stub
		
		return memapper.login(member);
	}

}
