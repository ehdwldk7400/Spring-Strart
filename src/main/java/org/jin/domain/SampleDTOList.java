package org.jin.domain;

import java.util.ArrayList;
import java.util.List;

public class SampleDTOList {
	private List<sampleDTO> list;
	
	public SampleDTOList() {
		list = new ArrayList<>();
	}

	public List<sampleDTO> getList() {
		return list;
	}

	public void setList(List<sampleDTO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "SampleDTOList [list=" + list + "]";
	}
	
	
}
