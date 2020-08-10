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

		logger.info("@RequestMapping dow�� ȣ��Ǿ����ϴ�.");
	}

	@RequestMapping(value = "doM", method = RequestMethod.GET)
	public void doM(sampleDTO sdto) {
		logger.info("@RequestMapping doM�� ȣ��Ǿ����ϴ�.");
		
	}

	@RequestMapping(value = "doD", method = RequestMethod.GET)
	public String doD(SampleDTOList list, Model model) {
		
		
		logger.info("@RequestMapping doD�� ȣ��Ǿ����ϴ�.");
		logger.info("SampleDTOList" + list);
		logger.info("@SampleDTOlist=" + list);
		model.addAttribute("abc", "doD�� �����ϰ����� �ϴ� ������");
		
		return "bbb";
	}

	@RequestMapping(value = "doR", method = RequestMethod.GET)
	public void doR() {

		logger.info("@RequestMapping doR�� ȣ��Ǿ����ϴ�.");
	}
	
	
	// Redirect ó��
	@RequestMapping(value="doE",  method = RequestMethod.GET)
	public String doE() {
		logger.info("doE �����");
		return "redirect:/doF";
		
	}
	@RequestMapping(value="doF",  method = RequestMethod.GET)
	public void doF() {
		logger.info("doF �����");
	}
	
	
	
	
	
	
	
}
