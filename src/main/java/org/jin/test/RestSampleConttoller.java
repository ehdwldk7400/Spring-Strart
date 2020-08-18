package org.jin.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jin.domain.SampleVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sample")
public class RestSampleConttoller {

	@RequestMapping("hello")
	public String sayhello() {
		return "Hello World";
	}
	@RequestMapping("sendVO")
	public SampleVO sendVO() {
		
		SampleVO vo = new SampleVO();
		vo.setFirsName("ÀÚ¹Ù");
		vo.setLastName("Á¤");
		vo.setMno(123);
		
		return vo;
	}
	@RequestMapping("sendList")
	public List<SampleVO> sendList(){
		List<SampleVO> list = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirsName("±æµ¿");
			vo.setLastName("È«");
			vo.setMno(i);
			list.add(vo);
		}
		return list;
	}
	@RequestMapping("sendMap")
	public Map<Integer, SampleVO> sendMap(){
		Map<Integer, SampleVO> list = new HashMap<>();
		
		for(int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirsName("±æµ¿");
			vo.setLastName("È«");
			vo.setMno(i);
			list.put(i, vo);
		}
		return list;
	}
	
}
