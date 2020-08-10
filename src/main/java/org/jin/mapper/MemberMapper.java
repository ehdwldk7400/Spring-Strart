package org.jin.mapper;

import java.util.List;

public interface MemberMapper {
	
//		public String readTime() throws Exception;
		
		public void createMember(MemberVO vo);
//		
		public MemberVO readMember(MemberVO vo);
		
		public List<MemberVO> readMemberList();
	
//		public MemberVO readWithPW(String userid, String userPW) throws Exception;
}
