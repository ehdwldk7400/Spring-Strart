package org.jin.test;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jin.mapper.MemberVO;
import org.jin.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	// 회원가입 처리
	@RequestMapping(value="member", method = RequestMethod.POST)
	public void memberpost(MemberVO vo) {
		meservice.createMember(vo);
	}
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public void loginGet() throws Exception{
		logger.info("로그인 화면 이동");
	}
	@RequestMapping(value="loginPost", method = RequestMethod.POST)
	public String loginPost(MemberVO member, Model model, HttpServletRequest request) throws Exception{
		MemberVO vo =meservice.login(member);
		logger.info("로그인 처리");
		String result = "";
		logger.info("vo값 : " + vo);
		
		HttpSession session = request.getSession();
		if(vo != null) {
			session.setAttribute("login", vo);
			logger.info("세션 값 : " + session.getAttribute("login"));
			return "redirect:/";
		}else {
			return "redirect:/member/login";
		}
		
		
		//		if(vo == null) return;
//		
//		model.addAttribute("userVO", vo);
		
//		return ret;
	}
	@RequestMapping(value="idChk", method = RequestMethod.POST)
	public ResponseEntity<Integer> idChk(MemberVO vo) {
		
		logger.info("vo : " + vo);
		return new ResponseEntity<Integer>(meservice.idChk(vo),HttpStatus.OK);	
	}
}
