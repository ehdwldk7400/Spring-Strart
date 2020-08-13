package org.jin.test;

import javax.inject.Inject;

import org.jin.domain.BoardVO;
import org.jin.domain.Cirteria;
import org.jin.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String registerPOST(BoardVO vo, Model model) throws Exception{
		logger.info("register POST......");
		service.create(vo);
		model.addAttribute("result", "success");
		
		return "redirect:/board/list";
	}
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void listGet(Model model, Cirteria cri) throws Exception{
		logger.info("list get.....");
		model.addAttribute("list", service.listPage(cri));
		
	}
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void readGet(BoardVO vo, Model model)  throws Exception{
		logger.info("read get....." + vo);
		
		model.addAttribute("read", service.read(vo));
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void updateGet(BoardVO vo , Model model)throws Exception {
		model.addAttribute("update", service.read(vo));
		logger.info("update get....." + vo);
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updatePost(BoardVO vo,RedirectAttributes rt)throws Exception {
		service.update(vo);
		rt.addFlashAttribute("msg", "success");
		logger.info("up실행"+vo);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "delete" , method = RequestMethod.POST)
	public String delete(BoardVO vo,RedirectAttributes rt) throws Exception {
		rt.addFlashAttribute("delmsg", "success");
		service.delete(vo);
		logger.info("삭제");
		return "redirect:/board/list";
	}
	
	/*@RequestMapping(value = "register", method = RequestMethod.POST)
	@RequestMapping(value = "mod", method = RequestMethod.POST)
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	@RequestMapping(value = "list", method = RequestMethod.GET)*/
}
