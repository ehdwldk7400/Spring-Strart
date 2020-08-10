package org.jin.test;

import java.lang.ProcessBuilder.Redirect;

import org.jin.domain.SampleDTOList;
import org.jin.domain.sampleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String doE(RedirectAttributes rttr) {
		logger.info("doE �����");
		rttr.addAttribute("msg", "�����̷�Ʈ�� ���� �޽���");
		return "redirect:/board/doF";
		
	}
	@RequestMapping(value="doF",  method = RequestMethod.GET)
	public void doF(String msg) {
		logger.info("doF �����");
	}
	
	// JSON ������ ó��
	@RequestMapping(value="doJSON", method = RequestMethod.GET)
	public @ResponseBody sampleDTO doJSON() {
		sampleDTO dto = new sampleDTO();
		dto.setId("abc");
		dto.setPassword("1234");
		
		return dto;	
	}
	
	
	
	
	
	
}
