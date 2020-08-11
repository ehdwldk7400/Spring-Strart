package org.jin.mapper;

import java.util.List;

public interface MemberMapper {
	
		public void createMember(MemberVO vo);
		
		public MemberVO readMember(MemberVO vo);
		
		public List<MemberVO> readMemberList();
		
		public void updateMember(MemberVO vo);
		
		public void deleteMember(MemberVO vo);
	
}
