package org.jin.test;

import javax.inject.Inject;

import org.jin.domain.BoardVO;
import org.jin.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public void registerGET() throws Exception{
		logger.info("register get......");
	}
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public void registerPOST(BoardVO vo, Model model) throws Exception{
		logger.info("register POST......");
		service.create(vo);
		model.addAttribute("result", "success");
		
	}
	
	/*@RequestMapping(value = "register", method = RequestMethod.POST)
	@RequestMapping(value = "read", method = RequestMethod.GET)
	@RequestMapping(value = "mod", method = RequestMethod.POST)
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	@RequestMapping(value = "list", method = RequestMethod.GET)*/
}
