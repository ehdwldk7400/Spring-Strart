package org.jin.test;

import java.util.List;

import org.jin.domain.Cirteria;
import org.jin.domain.ReplyPageVO;
import org.jin.domain.ReplyVO;
import org.jin.service.ReplySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("replies")
public class ReplyController {
   @Autowired
   private ReplySerivce reservice;
   
   @RequestMapping(value="/{bno}/{page}", method=RequestMethod.GET)
   public ResponseEntity<ReplyPageVO> list (@PathVariable("bno") int bno, @PathVariable("page") int page) throws Exception{
	   
	   Cirteria cri = new Cirteria(page, 10);
	   return new ResponseEntity<>(reservice.list(bno, cri), HttpStatus.OK);
   }
   
   @RequestMapping(value="", method=RequestMethod.POST)
   public ResponseEntity<String> list(@RequestBody ReplyVO vo) throws Exception{
	   ResponseEntity<String> entity = null;
	   try {
		reservice.create(vo);
		entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
	} catch (Exception e) {
		// TODO: handle exception
		entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
	}
	   return entity;
   }
   
   @RequestMapping(value="{rno}",  method=RequestMethod.PUT)
   public ResponseEntity<String> update(@PathVariable("rno") int rno, @RequestBody ReplyVO vo) throws Exception{
	   ResponseEntity<String> entity = null;
	   try {
		   vo.setRno(rno);
		reservice.update(vo);
		entity = new ResponseEntity<String>("Update SUCCESS",HttpStatus.OK);
	} catch (Exception e) {
		// TODO: handle exception
		entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
	}
	   return entity;
   }
   @RequestMapping(value="{rno}",  method=RequestMethod.DELETE)
   public ResponseEntity<String> delete(@PathVariable("rno") int rno) throws Exception{
	   ResponseEntity<String> entity = null;
	   try {
		   reservice.delete(rno);;
		   entity = new ResponseEntity<String>("DELETE SUCCESS",HttpStatus.OK);
	   } catch (Exception e) {
		   // TODO: handle exception
		   entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
	   }
	   return entity;
   }
}