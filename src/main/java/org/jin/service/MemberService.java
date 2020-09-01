package org.jin.service;

import org.jin.mapper.MemberVO;

public interface MemberService {
	public MemberVO login(MemberVO member);
	
	public void createMember(MemberVO vo);

	public int idChk(MemberVO vo);
}
