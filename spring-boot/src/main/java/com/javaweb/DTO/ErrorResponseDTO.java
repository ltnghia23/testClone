package com.javaweb.DTO;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponseDTO {
	private String Error;
	List<String> detail = new ArrayList();
	
	public String getError() {
		return Error;
	}
	public void setError(String error) {
		Error = error;
	}
	public List<String> getDetail() {
		return detail;
	}
	public void setDetail(List<String> detail) {
		this.detail = detail;
	}
	
	
}
