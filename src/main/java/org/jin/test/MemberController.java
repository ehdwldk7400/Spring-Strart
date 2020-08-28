package org.jin.test;

import org.jin.mapper.MemberVO;
import org.jin.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("member")
public class MemberController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	MemberService meservice;
	
	@RequestMapping(value="member", method = RequestMethod.GET)
	public void memberget() {
		
	}
	@RequestMapping(value="login", method = RequestMethod.GET)
	public void loginGet() throws Exception{
		logger.info("로그인 화면 이동");
	}
	@RequestMapping(value="loginPost", method = RequestMethod.POST)
	public void loginPost(MemberVO member, Model model) throws Exception{
		logger.info("로그인 처리");
		MemberVO vo =meservice.login(member);
		if(vo == null) return;
		
		model.addAttribute("userVO", vo);
	}
}
