package org.jin.test;

import org.jin.domain.SampleDTOList;
import org.jin.domain.sampleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "board")
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "doW", method = RequestMethod.GET)
	public void doW(@RequestParam("id") String id, @RequestParam("password") String password,
			@RequestParam("name") String name, @RequestParam("phone") int phone) {

		logger.info("@RequestMapping dow가 호출되었습니다.");
	}

	@RequestMapping(value = "doM", method = RequestMethod.GET)
	public void doM(sampleDTO sdto) {
		logger.info("@RequestMapping doM가 호출되었습니다.");
		
	}

	@RequestMapping(value = "doD", method = RequestMethod.GET)
	public String doD(SampleDTOList list, Model model) {
		
		
		logger.info("@RequestMapping doD가 호출되었습니다.");
		logger.info("SampleDTOList" + list);
		logger.info("@SampleDTOlist=" + list);
		model.addAttribute("abc", "doD에 전달하고자하 하는 데이터");
		
		return "bbb";
	}

	@RequestMapping(value = "doR", method = RequestMethod.GET)
	public void doR() {

		logger.info("@RequestMapping doR가 호출되었습니다.");
	}
	
	
	// Redirect 처리
	@RequestMapping(value="doE",  method = RequestMethod.GET)
	public String doE() {
		logger.info("doE 실행됨");
		return "redirect:/doF";
		
	}
	@RequestMapping(value="doF",  method = RequestMethod.GET)
	public void doF() {
		logger.info("doF 실행됨");
	}
	
	
	
	
	
	
	
}
