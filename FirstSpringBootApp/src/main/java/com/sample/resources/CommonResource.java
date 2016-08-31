package com.sample.resources;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonResource {

	@RequestMapping(value="getDateStr",produces=MediaType.TEXT_PLAIN_VALUE,method=RequestMethod.GET)
	public String getDateStr() {
		return new Date().toString();
	}
}
