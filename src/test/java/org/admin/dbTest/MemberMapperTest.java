package org.admin.dbTest;

import java.util.List;

import org.jin.mapper.MemberMapper;
import org.jin.mapper.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)		// 테스트 런 실행하기 위해 SpringJUnit4ClassRunner 선언
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class MemberMapperTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemberMapper memmapper;
	
//	@Test
//	public void testInsertMember() {
//		MemberVO member  = new MemberVO();
//		
//		member.setUserid("test");
//		member.setUserpw("1234");
//		member.setUsername("정발산");
//		member.setUsername("jin@kirininfo.com");
//		
//		memmapper.createMember(member);
//	}
	
	@Test
	public void testReadMember() {
		MemberVO member  = new MemberVO();
		member.setUserid("def");
		logger.info("회원정보 : " + memmapper.readMember(member));
	}
	@Test
	public void testReadMemberList() {
		List<MemberVO> memvo = memmapper.readMemberList();
		memvo.forEach(member->logger.info(""+member));
	}
	
	@Test
	public void testUpdateMember() {
		MemberVO member  = new MemberVO();
		
		member.setUserpw("9999");
		member.setUsername("아이유");
		member.setUserid("def");
		
		memmapper.updateMember(member);
	}
	
	@Test
	public void testDeleteMember() {
		MemberVO member  = new MemberVO();
		
		member.setUserid("def");
		
		memmapper.deleteMember(member);
	}
}
