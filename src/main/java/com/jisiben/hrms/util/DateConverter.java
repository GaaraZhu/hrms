package com.jisiben.hrms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import javax.annotation.PostConstruct;

public class DateConverter implements Converter<String, Date>{
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	@PostConstruct
	public void init() {
		dateFormat.setLenient(false);
	}

	public Date convert(String source) {
		if(StringUtils.isEmpty(source)) {
			return null;
		}
	  	try {
		  return dateFormat.parse(source);
	 	} catch (ParseException e) {
		  e.printStackTrace();
	 	}
	 	return null;
	 }
}