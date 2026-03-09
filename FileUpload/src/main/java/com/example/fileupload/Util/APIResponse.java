package com.example.fileupload.Util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class APIResponse<T,K> {

	private String message;
	private int status;
	private Map<T,K> data =new LinkedHashMap();
}
